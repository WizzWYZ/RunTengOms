package util.exceptions;

/**
 * Created by zhangming on 2015/7/31.
 */
public class CalculateNotFoundException extends Exception {
    public CalculateNotFoundException(String customerCode){
        setCustomerCode(customerCode);
    }
    private String customerCode;

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }
}
