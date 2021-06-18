/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection;

import asserts.Verify;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class eb {
    @Nullable
    private static final Method a = eb.a("privateGetDeclaredFields", Boolean.TYPE);
    @Nullable
    private static final Method b = eb.a("privateGetDeclaredMethods", Boolean.TYPE);
    @NotNull
    private static final Field[] c = new Field[0];
    @NotNull
    private static final Method[] d = new Method[0];

    private eb() {
    }

    @NotNull
    public static Field[] a(@NotNull Class<?> clazz) {
        try {
            Field[] fieldArray = (Field[])eb.a(a, clazz, false);
            return fieldArray == null ? clazz.getDeclaredFields() : fieldArray;
        }
        catch (Throwable throwable) {
            Verify.fail(throwable);
            return c;
        }
    }

    @NotNull
    public static Method[] b(@NotNull Class<?> clazz) {
        try {
            Method[] methodArray = (Method[])eb.a(b, clazz, false);
            methodArray = methodArray == null ? clazz.getDeclaredMethods() : methodArray;
            ArrayList<Method> arrayList = new ArrayList<Method>(methodArray.length);
            for (Method method : methodArray) {
                if (method.isSynthetic()) continue;
                arrayList.add(method);
            }
            return arrayList.toArray(new Method[arrayList.size()]);
        }
        catch (Throwable throwable) {
            Verify.fail(throwable);
            return d;
        }
    }

    @Nullable
    private static Method a(@NotNull String string, Class<?> ... classArray) {
        Method method = null;
        try {
            method = Class.class.getDeclaredMethod(string, classArray);
            if (method != null) {
                method.setAccessible(true);
            }
        }
        catch (NoSuchMethodException noSuchMethodException) {
            Verify.fail(noSuchMethodException);
        }
        return method;
    }

    @Nullable
    private static Object a(@Nullable Method method, @NotNull Class<?> clazz, Object ... objectArray) throws Throwable {
        try {
            return method == null ? null : method.invoke(clazz, objectArray);
        }
        catch (IllegalAccessException illegalAccessException) {
            Verify.fail("Failed to invoke method " + method + " for " + clazz + ": " + illegalAccessException.getMessage(), illegalAccessException.getCause());
            return null;
        }
        catch (InvocationTargetException invocationTargetException) {
            throw invocationTargetException.getTargetException();
        }
    }
}

