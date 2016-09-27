package util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by zhangming on 2015/7/15.
 */
@SuppressWarnings("Since15")
public class PropertiesHelper {
    public static Properties getProperties(String path) throws IOException {
        Properties p = new Properties();
        try {
            InputStream inputStream = Thread.currentThread().getClass().getResourceAsStream(path);
            p.load(new InputStreamReader(inputStream, "utf-8"));
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;

    }

    public static Properties getProperties(String path, Map<String, Properties> map, Class c) throws IOException {
        if (map == null) {
            map = new HashMap<String, Properties>();
        }
        if (map.containsKey(path)) {
            return map.get(path);
        }
        InputStreamReader sr = null;

        try {
            InputStream inputStream = c.getClassLoader().getResourceAsStream(path);
            Properties p = new Properties();
            p.load(new InputStreamReader(inputStream, "utf-8"));
            map.put(path, p);
            return p;
        } finally {
            if (sr != null) {
                sr.close();
            }
        }
    }

    public static Properties getProperties(String path, Class c) throws IOException {
        InputStreamReader sr = null;

        try {
            InputStream inputStream = c.getClassLoader().getResourceAsStream(path);
            Properties p = new Properties();
            p.load(new InputStreamReader(inputStream, "utf-8"));
            return p;
        } finally {
            if (sr != null) {
                sr.close();
            }
        }
    }
}
