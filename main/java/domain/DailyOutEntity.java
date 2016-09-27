package domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by wyz on 16/9/23.
 */
@Entity
@Table(name = "t_daily_out", schema = "rtOrderBilling")
public class DailyOutEntity {
    private int id;
    private String supplier;
    private String date;
    private BigDecimal costPrice;
    private String type;
    private String calculateType;
    private Timestamp createDate;
    private Integer costOrderNumber;
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
    @Column(name = "SUPPLIER")
    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
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
    @Column(name = "COST_PRICE")
    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
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
    @Column(name = "COST_ORDER_NUMBER")
    public Integer getCostOrderNumber() {
        return costOrderNumber;
    }

    public void setCostOrderNumber(Integer costOrderNumber) {
        this.costOrderNumber = costOrderNumber;
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

        DailyOutEntity that = (DailyOutEntity) o;

        if (id != that.id) return false;
        if (supplier != null ? !supplier.equals(that.supplier) : that.supplier != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (costPrice != null ? !costPrice.equals(that.costPrice) : that.costPrice != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (calculateType != null ? !calculateType.equals(that.calculateType) : that.calculateType != null)
            return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (costOrderNumber != null ? !costOrderNumber.equals(that.costOrderNumber) : that.costOrderNumber != null)
            return false;
        if (cancelOrderNumber != null ? !cancelOrderNumber.equals(that.cancelOrderNumber) : that.cancelOrderNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (supplier != null ? supplier.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (costPrice != null ? costPrice.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (calculateType != null ? calculateType.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (costOrderNumber != null ? costOrderNumber.hashCode() : 0);
        result = 31 * result + (cancelOrderNumber != null ? cancelOrderNumber.hashCode() : 0);
        return result;
    }
}
