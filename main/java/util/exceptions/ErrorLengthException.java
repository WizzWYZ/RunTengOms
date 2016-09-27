package util.exceptions;

/**
 * Created by zhangming on 2015/7/15.
 */
public class ErrorLengthException extends Exception {
    public ErrorLengthException(String properitesName,String key){
        setProperitesName(properitesName);
        setKey(key);
    }
    private String properitesName;
    private String key;

    public String getProperitesName() {
        return properitesName;
    }

    public void setProperitesName(String properitesName) {
        this.properitesName = properitesName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
