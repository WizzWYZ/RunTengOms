package util.exceptions;

/**
 * Created by zhangming on 2015/7/15.
 */
public class SupplierNotFoundException extends Exception {
    public SupplierNotFoundException(String supplier){
        setSupplier(supplier);
    }
    private String supplier;

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
