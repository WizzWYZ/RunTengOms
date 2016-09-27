package domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by wyz on 16/9/23.
 */
@Entity
@Table(name = "t_order", schema = "rtOrderBilling")
public class OrderEntity {
    private String id;                      //id
    private String client;                  //客户
    private String orderCode;               //订单编号
    private String clientInfo;              //客户额外信息
    private String orderType;               //订单类型
    private String supplier;                //供应商
    private String chargeTerm;              //账期
    private String addressProvince;         //省份
    private String addressCity;             //城市
    private String addressCounty;           //区县
    private String shippingStatus;          //订单运送状态
    private Double totalWeight;             //毛重量
    private Double actualWeight;            //净重量
    private Timestamp createDate;           //创建日期
    private Timestamp finishDate;           //完成日期
    private Timestamp modifyDate;           //修改日期
    private Integer itemQty;                //商品数量
    private String chargeProperty;          //订单收费配置文件
    private String costProperty;            //订单成本配置文件
    private BigDecimal chargePrice;         //订单收费金额
    private BigDecimal costPrice;           //订单成本金额
    private String calculateType;           //订单计算类型
    private String calculateMemo;           //订单计算备忘
    private String memo;                    //订单备忘
    private String type;                    //类型

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
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
    @Column(name = "ORDER_CODE")
    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    @Basic
    @Column(name = "CLIENT_INFO")
    public String getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(String clientInfo) {
        this.clientInfo = clientInfo;
    }

    @Basic
    @Column(name = "ORDER_TYPE")
    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
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
    @Column(name = "CHARGE_TERM")
    public String getChargeTerm() {
        return chargeTerm;
    }

    public void setChargeTerm(String chargeTerm) {
        this.chargeTerm = chargeTerm;
    }

    @Basic
    @Column(name = "ADDRESS_PROVINCE")
    public String getAddressProvince() {
        return addressProvince;
    }

    public void setAddressProvince(String addressProvince) {
        this.addressProvince = addressProvince;
    }

    @Basic
    @Column(name = "ADDRESS_CITY")
    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    @Basic
    @Column(name = "ADDRESS_COUNTY")
    public String getAddressCounty() {
        return addressCounty;
    }

    public void setAddressCounty(String addressCounty) {
        this.addressCounty = addressCounty;
    }

    @Basic
    @Column(name = "SHIPPING_STATUS")
    public String getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(String shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    @Basic
    @Column(name = "TOTAL_WEIGHT")
    public Double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Double totalWeight) {
        this.totalWeight = totalWeight;
    }

    @Basic
    @Column(name = "ACTUAL_WEIGHT")
    public Double getActualWeight() {
        return actualWeight;
    }

    public void setActualWeight(Double actualWeight) {
        this.actualWeight = actualWeight;
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
    @Column(name = "FINISH_DATE")
    public Timestamp getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Timestamp finishDate) {
        this.finishDate = finishDate;
    }

    @Basic
    @Column(name = "MODIFY_DATE")
    public Timestamp getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Timestamp modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Basic
    @Column(name = "ITEM_QTY")
    public Integer getItemQty() {
        return itemQty;
    }

    public void setItemQty(Integer itemQty) {
        this.itemQty = itemQty;
    }

    @Basic
    @Column(name = "CHARGE_PROPERTY")
    public String getChargeProperty() {
        return chargeProperty;
    }

    public void setChargeProperty(String chargeProperty) {
        this.chargeProperty = chargeProperty;
    }

    @Basic
    @Column(name = "COST_PROPERTY")
    public String getCostProperty() {
        return costProperty;
    }

    public void setCostProperty(String costProperty) {
        this.costProperty = costProperty;
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
    @Column(name = "COST_PRICE")
    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
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
    @Column(name = "CALCULATE_MEMO")
    public String getCalculateMemo() {
        return calculateMemo;
    }

    public void setCalculateMemo(String calculateMemo) {
        this.calculateMemo = calculateMemo;
    }

    @Basic
    @Column(name = "MEMO")
    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Basic
    @Column(name = "TYPE")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity that = (OrderEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (client != null ? !client.equals(that.client) : that.client != null) return false;
        if (orderCode != null ? !orderCode.equals(that.orderCode) : that.orderCode != null) return false;
        if (clientInfo != null ? !clientInfo.equals(that.clientInfo) : that.clientInfo != null) return false;
        if (orderType != null ? !orderType.equals(that.orderType) : that.orderType != null) return false;
        if (supplier != null ? !supplier.equals(that.supplier) : that.supplier != null) return false;
        if (chargeTerm != null ? !chargeTerm.equals(that.chargeTerm) : that.chargeTerm != null) return false;
        if (addressProvince != null ? !addressProvince.equals(that.addressProvince) : that.addressProvince != null)
            return false;
        if (addressCity != null ? !addressCity.equals(that.addressCity) : that.addressCity != null) return false;
        if (addressCounty != null ? !addressCounty.equals(that.addressCounty) : that.addressCounty != null)
            return false;
        if (shippingStatus != null ? !shippingStatus.equals(that.shippingStatus) : that.shippingStatus != null)
            return false;
        if (totalWeight != null ? !totalWeight.equals(that.totalWeight) : that.totalWeight != null) return false;
        if (actualWeight != null ? !actualWeight.equals(that.actualWeight) : that.actualWeight != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (finishDate != null ? !finishDate.equals(that.finishDate) : that.finishDate != null) return false;
        if (modifyDate != null ? !modifyDate.equals(that.modifyDate) : that.modifyDate != null) return false;
        if (itemQty != null ? !itemQty.equals(that.itemQty) : that.itemQty != null) return false;
        if (chargeProperty != null ? !chargeProperty.equals(that.chargeProperty) : that.chargeProperty != null)
            return false;
        if (costProperty != null ? !costProperty.equals(that.costProperty) : that.costProperty != null) return false;
        if (chargePrice != null ? !chargePrice.equals(that.chargePrice) : that.chargePrice != null) return false;
        if (costPrice != null ? !costPrice.equals(that.costPrice) : that.costPrice != null) return false;
        if (calculateType != null ? !calculateType.equals(that.calculateType) : that.calculateType != null)
            return false;
        if (calculateMemo != null ? !calculateMemo.equals(that.calculateMemo) : that.calculateMemo != null)
            return false;
        if (memo != null ? !memo.equals(that.memo) : that.memo != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (client != null ? client.hashCode() : 0);
        result = 31 * result + (orderCode != null ? orderCode.hashCode() : 0);
        result = 31 * result + (clientInfo != null ? clientInfo.hashCode() : 0);
        result = 31 * result + (orderType != null ? orderType.hashCode() : 0);
        result = 31 * result + (supplier != null ? supplier.hashCode() : 0);
        result = 31 * result + (chargeTerm != null ? chargeTerm.hashCode() : 0);
        result = 31 * result + (addressProvince != null ? addressProvince.hashCode() : 0);
        result = 31 * result + (addressCity != null ? addressCity.hashCode() : 0);
        result = 31 * result + (addressCounty != null ? addressCounty.hashCode() : 0);
        result = 31 * result + (shippingStatus != null ? shippingStatus.hashCode() : 0);
        result = 31 * result + (totalWeight != null ? totalWeight.hashCode() : 0);
        result = 31 * result + (actualWeight != null ? actualWeight.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (finishDate != null ? finishDate.hashCode() : 0);
        result = 31 * result + (modifyDate != null ? modifyDate.hashCode() : 0);
        result = 31 * result + (itemQty != null ? itemQty.hashCode() : 0);
        result = 31 * result + (chargeProperty != null ? chargeProperty.hashCode() : 0);
        result = 31 * result + (costProperty != null ? costProperty.hashCode() : 0);
        result = 31 * result + (chargePrice != null ? chargePrice.hashCode() : 0);
        result = 31 * result + (costPrice != null ? costPrice.hashCode() : 0);
        result = 31 * result + (calculateType != null ? calculateType.hashCode() : 0);
        result = 31 * result + (calculateMemo != null ? calculateMemo.hashCode() : 0);
        result = 31 * result + (memo != null ? memo.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
