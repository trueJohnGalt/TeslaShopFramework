package tesla.automation.utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Storage {

    private static final Map<String, Object> storage = new HashMap<>();

    public void saveObject(final String key, final Object object) {
        storage.put(key, object);
    }

    public <T> T getObject(final String key, Class<T> requiredType) {
        return requiredType.cast(storage.get(key));
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> getObjects(final String key) {
        return (List<T>) storage.get(key);
    }
}
