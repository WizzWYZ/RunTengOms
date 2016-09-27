package client;

import domain.OrderEntity;
import org.hibernate.Session;
import util.exceptions.KeyNotFoundException;

import java.util.Properties;

/**
 * Created by wyz on 16/9/22.
 */
public abstract class Client {
    protected String clientName;
    protected Properties clientProperties;
    protected String clientPropertiesRoute;

    public Client(Properties p,String clientName,String clientPropertiesRoute) {
        this.clientName = clientName;
        this.clientProperties = p;
        this.clientPropertiesRoute = clientPropertiesRoute;
    }

    private String[] getStandard(String province) throws KeyNotFoundException {
        System.out.println(province);
        if(province.startsWith("内蒙古") || province.startsWith("黑龙江")){
            province = province.substring(0,3);
        }else{
            province = province.substring(0,2);
        }
        if(!clientProperties.containsKey(province)){
            throw new KeyNotFoundException(clientName,province);
        }
        String value = clientProperties.getProperty(province);
        String[] standard = value.split(" ");

        return standard;
    }

    public void startCalculate(Session session, String province, Double weight, OrderEntity orderEntity) throws KeyNotFoundException {
        String[] standard = null;
        if(clientProperties != null) {
            standard = getStandard(province);
        }
        onCalculating(session,standard,weight,orderEntity);
    };
    protected abstract void onCalculating(Session session, String[] standard, Double weight, OrderEntity orderEntity);


}
