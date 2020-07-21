package tesla.automation.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SessionStorage {

    private static final Map<String, Object> session = new HashMap<>();

    public void storeObject(final String key, final Object object) {
        session.put(key, object);
    }

    public <T> T getObject(final String key, Class<T> requiredType) {
        return requiredType.cast(session.get(key));
    }

    public <T> List<T> getListOfObjects(final String key, Class<T> requiredType) {
        return (List<T>) session.get(key);
    }
}
