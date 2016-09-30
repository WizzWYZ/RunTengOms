/**
 * Created by wyz on 16/9/29.
 */
const express = require('express');
const qs = require('querystring');
const app = express();

var mysql = require('mysql');
const datefomat = require('dateformat');
const uuid = require('uuid');
const async = require('async');
var pool = mysql.createPool({
    connectionLimit: 20,
    host: 'rm-bp1l07gc716p220p0i.mysql.rds.aliyuncs.com',
    user: 'runteng',
    password: 'runteng_123',
    database: 'db_order'
});
const md5 = require('md5');


process.on('uncaughtException', function (err) {
    console.log('Caught exception: ' + err);
    console.log(err.stack);
});

var funs = [];
app.get('/ping.rt', (req, res) => {
    res.send("SUCCESS");
})
//用户
app.post('/sync.rt', (req, res) => {
    var datass = [];
    req.on('data', (data) => {
        datass.push(data);
    });
    req.on('end', ()=> {
        try {
            var param = datass.join('');
            try {
                param = qs.parse(decodeURIComponent(param));
            } catch (e) {
                console.log(e.stack);
                res.send(JSON.stringify({
                    success: false,
                    error: "格式错误",
                    result: decodeURIComponent(param)
                }))
            }
            if (param.method != "sync" || param.appkey != "SKU360") {
                res.send('{"success":false,"error":"参数错误"}');
                return;
            }
            if (md5("SKU360" + "uksevol1237890" + param.datetime).toUpperCase() != param.sign) {
                res.send('{"success":false,"error":"密码校验错误"}');
                return;
            }

            try {
                var datas = JSON.parse(param.data);
                saveDatas(datas, 0);
            } catch (e) {
                console.log(e);
            }
        } catch (e) {
            console.log(e.stack);
            res.send(JSON.stringify({
                success: false,
                error: "系统内部错误"
            }))
        }
        ;
    })
});
function saveDatas(datas, step) {
    if (step < 10) {
        datas.forEach((data) => {
            var order = {
                ID: uuid.v1(),
                ORDER_ID: data.ORDER_ID,
                CUST: data.CUST,
                EXPRESS_NO: data.EXPRESS_NO,
                WEIGHT: data.WEIGHT,
                PROVINCE: data.PROVINCE,
                CITY: data.CITY,
                EXPRESS_CODE: data.EXPRESS_CODE,
                MODIFY_DATE: data.MODIFY_DATE
            };
            funs.push((cb)=> {
                save(cb, order)
            });
        })
        async.parallel(funs, (err, results)=> {
            var finalResults = [];
            results.forEach((row) => {
                if (row != null) {
                    finalResults.push(row);
                }
            });
            if (finalResults.length!=0) {
                saveDatas(finalResults, step + 1);
            }
        });
    }
}

function save(cb, order) {
    pool.getConnection((err, connection) => {
        if (err) {
            console.log(err);
            cb(null, order);
        }
        connection.query("INSERT INTO t_order SET ? ", order, (err, rows) => {
            connection.release();
            if (err) {
                console.log(err);
                cb(null, order);
            }
            cb(null);
        });
    });
}


app.listen(process.argv[2]);