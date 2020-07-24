package tesla.automation.utils;

public class EnumUtils {

    public static <E extends Enum<E>> E toEnum(Class<E> requiredEnum, String string) {
        return E.valueOf(requiredEnum, string.toUpperCase().replaceAll("\\s+", "_"));
    }

}
