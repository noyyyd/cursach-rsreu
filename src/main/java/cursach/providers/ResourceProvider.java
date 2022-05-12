package cursach.providers;

import java.util.ResourceBundle;

public class ResourceProvider {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("connection");

    public static String get(String key) {
        return resourceBundle.getString(key);
    }
}
