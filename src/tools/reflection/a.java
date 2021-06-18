/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection;

import asserts.Verify;
import gnu.trove.THashMap;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public final class a
extends ClassLoader {
    @NotNull
    private Map<String, Class<?>> a = new THashMap();
    @NotNull
    private Method b;
    @NotNull
    private final List<String> c = new ArrayList<String>();

    public a() {
        super(Thread.currentThread().getContextClassLoader());
        try {
            this.b = ClassLoader.class.getDeclaredMethod("defineClass", String.class, byte[].class, Integer.TYPE, Integer.TYPE);
            this.b.setAccessible(true);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            Verify.fail(noSuchMethodException);
            throw new AssertionError((Object)noSuchMethodException);
        }
        ClassLoader classLoader = this.getParent();
        if (classLoader instanceof URLClassLoader) {
            URLClassLoader uRLClassLoader = (URLClassLoader)classLoader;
            for (URL uRL : uRLClassLoader.getURLs()) {
                this.c.add(uRL.getFile());
            }
        }
    }

    @NotNull
    public Class<?> a(@NotNull String string, @NotNull byte[] byArray) throws ClassFormatError {
        try {
            Class clazz = (Class)this.b.invoke(this.getParent(), string, byArray, 0, byArray.length);
            this.a.put(clazz.getName(), clazz);
            return clazz;
        }
        catch (IllegalAccessException | InvocationTargetException reflectiveOperationException) {
            ClassFormatError classFormatError = new ClassFormatError(reflectiveOperationException.getMessage());
            classFormatError.initCause(reflectiveOperationException);
            throw classFormatError;
        }
    }

    @Override
    @NotNull
    protected Class<?> findClass(@NotNull String string) throws ClassNotFoundException {
        Class<?> clazz = this.a.get(string);
        if (clazz != null) {
            return clazz;
        }
        return super.findClass(string);
    }

    @NotNull
    public String[] a() {
        return this.c.toArray(new String[this.c.size()]);
    }
}

