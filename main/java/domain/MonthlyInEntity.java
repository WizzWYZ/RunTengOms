package domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by wyz on 16/9/23.
 */
@Entity
@Table(name = "t_monthly_in", schema = "rtOrderBilling")
public class MonthlyInEntity {
    private int id;
    private String client;
    private String month;
    private BigDecimal chargePeice;
    private BigDecimal expressPrice;
    private BigDecimal stockPrice;
    private String type;
    private String calculateType;
    private Timestamp createDate;
    private Integer chargeOrderNumber;
    private Integer cancelOrderNumber;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CLIENT")
    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    @Basic
    @Column(name = "MONTH")
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Basic
    @Column(name = "CHARGE_PEICE")
    public BigDecimal getChargePeice() {
        return chargePeice;
    }

    public void setChargePeice(BigDecimal chargePeice) {
        this.chargePeice = chargePeice;
    }

    @Basic
    @Column(name = "EXPRESS_PRICE")
    public BigDecimal getExpressPrice() {
        return expressPrice;
    }

    public void setExpressPrice(BigDecimal expressPrice) {
        this.expressPrice = expressPrice;
    }

    @Basic
    @Column(name = "STOCK_PRICE")
    public BigDecimal getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(BigDecimal stockPrice) {
        this.stockPrice = stockPrice;
    }

    @Basic
    @Column(name = "TYPE")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "CALCULATE_TYPE")
    public String getCalculateType() {
        return calculateType;
    }

    public void setCalculateType(String calculateType) {
        this.calculateType = calculateType;
    }

    @Basic
    @Column(name = "CREATE_DATE")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "CHARGE_ORDER_NUMBER")
    public Integer getChargeOrderNumber() {
        return chargeOrderNumber;
    }

    public void setChargeOrderNumber(Integer chargeOrderNumber) {
        this.chargeOrderNumber = chargeOrderNumber;
    }

    @Basic
    @Column(name = "CANCEL_ORDER_NUMBER")
    public Integer getCancelOrderNumber() {
        return cancelOrderNumber;
    }

    public void setCancelOrderNumber(Integer cancelOrderNumber) {
        this.cancelOrderNumber = cancelOrderNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MonthlyInEntity that = (MonthlyInEntity) o;

        if (id != that.id) return false;
        if (client != null ? !client.equals(that.client) : that.client != null) return false;
        if (month != null ? !month.equals(that.month) : that.month != null) return false;
        if (chargePeice != null ? !chargePeice.equals(that.chargePeice) : that.chargePeice != null) return false;
        if (expressPrice != null ? !expressPrice.equals(that.expressPrice) : that.expressPrice != null) return false;
        if (stockPrice != null ? !stockPrice.equals(that.stockPrice) : that.stockPrice != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (calculateType != null ? !calculateType.equals(that.calculateType) : that.calculateType != null)
            return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (chargeOrderNumber != null ? !chargeOrderNumber.equals(that.chargeOrderNumber) : that.chargeOrderNumber != null)
            return false;
        if (cancelOrderNumber != null ? !cancelOrderNumber.equals(that.cancelOrderNumber) : that.cancelOrderNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (client != null ? client.hashCode() : 0);
        result = 31 * result + (month != null ? month.hashCode() : 0);
        result = 31 * result + (chargePeice != null ? chargePeice.hashCode() : 0);
        result = 31 * result + (expressPrice != null ? expressPrice.hashCode() : 0);
        result = 31 * result + (stockPrice != null ? stockPrice.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (calculateType != null ? calculateType.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (chargeOrderNumber != null ? chargeOrderNumber.hashCode() : 0);
        result = 31 * result + (cancelOrderNumber != null ? cancelOrderNumber.hashCode() : 0);
        return result;
    }
}
