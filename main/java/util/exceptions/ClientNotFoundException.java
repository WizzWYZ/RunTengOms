package util.exceptions;

/**
 * Created by zhangming on 2015/7/15.
 */
public class ClientNotFoundException extends Exception {
    public ClientNotFoundException(String client){
        setClient(client);
    }
    private String client;

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
