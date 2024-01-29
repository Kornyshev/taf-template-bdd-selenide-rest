package org.example.core;

public class DataUtils {

    public static final String SPACES_REG_EXP = "[\\r\\n]+";

    public static synchronized String timestamp() {
        return String.valueOf(System.currentTimeMillis());
    }

}
