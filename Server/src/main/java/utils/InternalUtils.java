package utils;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class InternalUtils {
    private static final String EMPTY_STRING = "";

    public static boolean isNotBlank(String string) {
        return string != null && !string.equals(EMPTY_STRING);
    }

    public static boolean isBlank(String string) {
        return string == null || string.equals(EMPTY_STRING);
    }

    public static Integer getIntegerFromString(String intString) {
        if (InternalUtils.isBlank(intString)) {
            return 0;
        }
        try {
            return Integer.parseInt(intString);
        } catch (NumberFormatException numberFormatException) {
        }
        return null;
    }

    public static <T> Stream<T> safeStream(Collection<T> collection) {
        return collection == null ? Stream.empty() : collection.stream();
    }

    public static <T> Stream<T> safeParallelStream(Collection<T> collection) {
        return collection == null ? Stream.empty() : collection.parallelStream();
    }

    public static String safeString(String str) {
        return str == null ? EMPTY_STRING : str;
    }

    public static void safeSetString(Consumer<String> setter, String str) {
        if (isNotBlank(str)) {
            setter.accept(str);
        }
    }
}
