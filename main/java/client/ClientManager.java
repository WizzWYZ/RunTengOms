package client;

import util.PropertiesHelper;
import util.exceptions.ClientNotFoundException;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by wyz on 16/9/22.
 */
public class ClientManager {
    private static Map<String, Properties> clientPropertiesMap = new HashMap<String, Properties>();

    public static Properties getClientProperties() throws IOException {
        PropertiesHelper.getProperties("client.properties", clientPropertiesMap, Client.class);
        Properties clientProperties = clientPropertiesMap.get("client.properties");
        return clientProperties;
    }

    public static Client getClient(String client) throws IOException, ClientNotFoundException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Properties clientProperties = ClientManager.getClientProperties();
        Client clientD;
        if (clientProperties.containsKey(client)) {
            String clientDetail = clientProperties.get(client).toString();
            Properties p = PropertiesHelper.getProperties(clientDetail, Client.class);
            Class clazz = Class.forName("client." + p.get("class"));
            Constructor constructor = clazz.getConstructor(Properties.class,String.class,String.class);
            clientD = (Client) constructor.newInstance(p,client,clientProperties.get(client));
        }else{
            throw new ClientNotFoundException(client);
        }

        return clientD;
    }
}
