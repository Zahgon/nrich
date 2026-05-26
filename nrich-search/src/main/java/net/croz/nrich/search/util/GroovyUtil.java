package net.croz.nrich.search.util;

import org.springframework.util.ClassUtils;
import java.util.regex.Pattern;

public final class GroovyUtil {

    private GroovyUtil() {
    }

    private static final Pattern GROOVY_CLOSURE_PATTERN = Pattern.compile(".*\\$_.*closure.*");

    public static boolean isGroovyPresent() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static boolean isGroovyClosure(Class<?> type) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
