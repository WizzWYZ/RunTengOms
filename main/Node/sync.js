/**
 * Created by wyz on 16/9/29.
 */
var mysql = require('mysql');
const datefomat = require('dateformat');
const uuid = require('uuid');

var pool = mysql.createPool({
    connectionLimit: 500,
    host: 'rubicware.mysql.rds.aliyuncs.com',
    user: 'oms',
    password: 'rub_oms123',
    database: 'db_tms'
});
var poolRT = mysql.createPool({
    connectionLimit: 200,
    host: 'rm-bp1l07gc716p220p0i.mysql.rds.aliyuncs.com',
    user: 'runteng',
    password: 'runteng_123',
    database: 'db_order'
});

const pagination = 100;
const code = ["t_bto", "t_cnp", "t_cnp2", "t_ems", "t_gto", "t_sto", "t_ttk", "t_yto", "t_yunda", "t_zto"];
var request = code.map((table) => {
    return new Promise((resolve) => {
            pool.getConnection((err, connection)=> {
                if (err){
                    console.log(err);
                    return;
                }
                var sql = "select count(1) from "+table+" where sync = '4' and DATE_FORMAT(`MODIFY_DATE`,'%Y%m%d') > '20160401'  and DATE_FORMAT(`MODIFY_DATE`,'%Y%m%d') < '20160801'";
                connection.query(sql, (err, count) => {
                    if (err) {
                        console.log(err);
                        return;
                    }
                    var number = count[0]['count(1)'];
                    if (number == 0) {
                        connection.release();
                        return;
                    }
                    var page = [];
                    var pages = 0;
                    while (pages < Math.ceil(number / pagination)) {
                        page.push(pages);
                        pages++;
                    }
                    var subRequest = page.map((i)=> {
                        return new Promise((solve) => {
                            var subSql = "select * from "+ table +" where sync = '4' and DATE_FORMAT(`MODIFY_DATE`,'%Y%m%d') > '20160401' " +
                                " and DATE_FORMAT(`MODIFY_DATE`,'%Y%m%d') < '20160801' LIMIT ?,?";
                            connection.query(subSql, [i * pagination, (i + 1) * pagination - 1], (err, rows)=> {
                                if (err) {
                                    console.log(err);
                                    connection.release();
                                    return;
                                }
                                rows.forEach((row)=> {
                                    poolRT.getConnection((err, rtconnection)=> {
                                        if (err) {
                                            console.log(err);
                                            return;
                                        }
                                        var subsubSql = "insert into t_order values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                                        rtconnection.query(subsubSql, [uuid.v1(), row.ORDER_ID, row.ORDER_CODE, row.CUST, row.EXPRESS_NO, row.NAME, row.ADDRESS, row.WEIGHT, row.AREA_CODE, row.MOBILE, row.CREATE_DATE, row.TEL, row.PROVINCE, row.CITY, row.DISTRICT, row.SYNC, row.MSG, row.ITEM_QTY, row.EXPRESS_CODE, row.MODIFY_DATE],
                                            (err)=> {
                                                if (err) {
                                                    console.log(err);
                                                    return;
                                                }
                                                solve();
                                            })
                                    })
                                })
                            })
                        })
                    });
                    Promise.all(subRequest).then(() => {resolve();});
                })

            })
        }
    )
})
Promise.all(request).then(() => {pool.end();poolRT.end();});