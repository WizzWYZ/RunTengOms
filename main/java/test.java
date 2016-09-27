import runnable.CaculateOrderChargePrice;

/**
 * Created by wyz on 16/9/27.
 */
public class test {
    public static void main(String[] args) {
        Thread thread = new Thread(new CaculateOrderChargePrice());
        thread.run();
    }
}
