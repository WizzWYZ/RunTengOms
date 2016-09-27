package client.sku360;

import client.Client;
import domain.OrderEntity;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.util.Properties;

/**
 * Created by wyz on 16/9/27.
 */
public class sku360v1 extends Client {

    public sku360v1(Properties p, String clientName,String clientPropertiesRoute){
        super(p,clientName,clientPropertiesRoute);
    }

    @Override
    protected void onCalculating(Session session, String[] standard, Double weight, OrderEntity orderEntity) {
        orderEntity.setChargeProperty(clientPropertiesRoute);
        orderEntity.setCostPrice(new BigDecimal(10));
        orderEntity.setChargePrice(new BigDecimal(15));
    }

}
