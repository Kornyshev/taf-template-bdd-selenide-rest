package org.example.core;

import org.assertj.core.api.SoftAssertions;

import java.util.*;

public final class TestContext {

    private static final ThreadLocal<Map<ContextKeys, Object>> context = new ThreadLocal<>();

    private TestContext() {
    }

    public static void resetContext() {
        context.remove();
        context.set(new EnumMap<>(ContextKeys.class));
        setContext(ContextKeys.SOFT_ASSERT, new SoftAssertions());
    }

    public static void setContext(ContextKeys key, Object value) {
        context.get().put(key, value);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getContext(ContextKeys key) {
        return (T) context.get().get(key);
    }

    public static boolean hasContext(ContextKeys key) {
        return context.get().containsKey(key);
    }

    public static void removeContext(ContextKeys key) {
        context.get().remove(key);
    }

    public static Object parseContext(String alias) {
        if (alias.contains("[") && alias.contains("]")) {
            List<Object> listOfObjects = TestContext.getContext(
                    ContextKeys.valueOf(alias.substring(0, alias.indexOf("["))));
            return listOfObjects.get(Integer.parseInt(
                    alias.substring(alias.indexOf("[") + 1, alias.indexOf("]"))));
        } else if (!alias.contains("[") && !alias.contains("]")) {
            return TestContext.getContext(ContextKeys.valueOf(alias));
        }
        return alias;

    }

    public enum ContextKeys {
        SOFT_ASSERT;

        ContextKeys() {

        }

    }

}
