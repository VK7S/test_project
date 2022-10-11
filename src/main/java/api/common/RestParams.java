package api.common;

import java.util.HashMap;

public class RestParams extends HashMap<String, String> {

    public String put(String key, boolean value) {
        return super.put(key, String.valueOf(value));
    }

    public String put(String key, int value) {
        return super.put(key, String.valueOf(value));
    }

}
