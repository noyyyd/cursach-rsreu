package cursach.providers;

import java.util.ResourceBundle;

public class QueriesProvider {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("queries");

    public static String get(String key) {
        return resourceBundle.getString(key);
    }
}
