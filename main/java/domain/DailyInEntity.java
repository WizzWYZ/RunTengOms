package domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by wyz on 16/9/23.
 */
@Entity
@Table(name = "t_daily_in", schema = "rtOrderBilling")
public class DailyInEntity {
    private int id;
    private String client;
    private String date;
    private BigDecimal chargePrice;
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
    @Column(name = "DATE")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Basic
    @Column(name = "CHARGE_PRICE")
    public BigDecimal getChargePrice() {
        return chargePrice;
    }

    public void setChargePrice(BigDecimal chargePrice) {
        this.chargePrice = chargePrice;
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

        DailyInEntity that = (DailyInEntity) o;

        if (id != that.id) return false;
        if (client != null ? !client.equals(that.client) : that.client != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (chargePrice != null ? !chargePrice.equals(that.chargePrice) : that.chargePrice != null) return false;
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
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (chargePrice != null ? chargePrice.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (calculateType != null ? calculateType.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (chargeOrderNumber != null ? chargeOrderNumber.hashCode() : 0);
        result = 31 * result + (cancelOrderNumber != null ? cancelOrderNumber.hashCode() : 0);
        return result;
    }
}
