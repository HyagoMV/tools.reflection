/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection;

import org.jetbrains.annotations.NotNull;

public final class y {
    public static boolean a(@NotNull Class<?> clazz) {
        if (clazz.equals(Boolean.class)) {
            return true;
        }
        if (clazz.equals(Boolean.TYPE)) {
            return true;
        }
        if (clazz.equals(Character.class)) {
            return true;
        }
        if (clazz.equals(Character.TYPE)) {
            return true;
        }
        if (clazz.equals(Byte.class)) {
            return true;
        }
        if (clazz.equals(Byte.TYPE)) {
            return true;
        }
        if (clazz.equals(Short.class)) {
            return true;
        }
        if (clazz.equals(Short.TYPE)) {
            return true;
        }
        if (clazz.equals(Integer.class)) {
            return true;
        }
        if (clazz.equals(Integer.TYPE)) {
            return true;
        }
        if (clazz.equals(Long.class)) {
            return true;
        }
        if (clazz.equals(Long.TYPE)) {
            return true;
        }
        if (clazz.equals(Float.class)) {
            return true;
        }
        if (clazz.equals(Float.TYPE)) {
            return true;
        }
        if (clazz.equals(Double.class)) {
            return true;
        }
        if (clazz.equals(Double.TYPE)) {
            return true;
        }
        if (clazz.equals(String.class)) {
            return true;
        }
        return clazz.isEnum();
    }

    private y() {
    }
}

