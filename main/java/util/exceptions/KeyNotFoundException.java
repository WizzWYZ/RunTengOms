package util.exceptions;

/**
 * Created by zhangming on 2015/7/15.
 */
public class KeyNotFoundException extends Exception {
    public KeyNotFoundException(String propertiesName,String key){
        setProperitesName(propertiesName);setKey(key);
    }
    private String properitesName;
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getProperitesName() {
        return properitesName;
    }

    public void setProperitesName(String properitesName) {
        this.properitesName = properitesName;
    }
}
