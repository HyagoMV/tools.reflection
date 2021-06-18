/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.apache.commons.vfs2.FileObject
 */
package tools.reflection.classLoading;

import asserts.Verify;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Map;
import org.apache.commons.vfs2.FileObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tools.reflection.classLoading.s;

public final class a
extends ClassLoader {
    @NotNull
    private static final String a = "WEB-INF.classes.";
    @NotNull
    private Method b;
    @NotNull
    private Method c;
    @NotNull
    private final Method d;
    @NotNull
    private final Map<String, String> e;
    @NotNull
    private final s f;

    public a(@NotNull s s2, @NotNull Map<String, String> map) {
        super(Thread.currentThread().getContextClassLoader());
        this.e = map;
        this.f = s2;
        try {
            this.b = ClassLoader.class.getDeclaredMethod("defineClass", String.class, byte[].class, Integer.TYPE, Integer.TYPE);
            this.b.setAccessible(true);
            this.c = ClassLoader.class.getDeclaredMethod("definePackage", String.class, String.class, String.class, String.class, String.class, String.class, String.class, URL.class);
            this.c.setAccessible(true);
            this.d = ClassLoader.class.getDeclaredMethod("findLoadedClass", String.class);
            this.d.setAccessible(true);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            Verify.fail(noSuchMethodException);
            throw new ExceptionInInitializerError(noSuchMethodException);
        }
    }

    @NotNull
    public Class<?> a(@NotNull String string, @NotNull byte[] byArray) throws ClassFormatError {
        try {
            String s;
            int n2 = string.lastIndexOf(46);
            if (n2 > 0) {
                s = string.substring(0, string.lastIndexOf(46));
                this.d(s);
            }
            Class c = (Class)this.b.invoke(this.getParent(), string, byArray, 0, byArray.length);
            this.defineClass(string, byArray, 0, byArray.length);
            return c;
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new ClassFormatError(illegalAccessException.getMessage());
        }
        catch (InvocationTargetException invocationTargetException) {
            if (invocationTargetException.getTargetException() instanceof LinkageError) {
                return this.e(string);
            }
            throw new ClassFormatError(invocationTargetException.getMessage());
        }
        catch (LinkageError linkageError) {
            return this.e(string);
        }
    }

    @Nullable
    private Class<?> a(@NotNull String string) {
        try {
            return (Class)this.d.invoke(this.getParent(), string);
        }
        catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException exception) {
            return null;
        }
    }

    @Override
    @NotNull
    public Class<?> loadClass(@NotNull String string, boolean bl) throws ClassNotFoundException {
        Class<?> clazz = this.a(string);
        if (clazz != null) {
            return clazz;
        }
        clazz = this.b(string);
        if (clazz != null) {
            return clazz;
        }
        clazz = this.f(string);
        return clazz;
    }

    @Nullable
    private Class<?> b(@NotNull String string) throws ClassNotFoundException {
        Class<?> clazz = null;
        if (string.startsWith("java.") || string.startsWith("javax.") || string.startsWith("sun.") || string.startsWith("com.sun.") || string.startsWith("org.w3c.") || string.startsWith("org.xml.")) {
            clazz = this.c(string);
        }
        return clazz;
    }

    @NotNull
    private Class<?> c(@NotNull String string) throws ClassNotFoundException {
        ClassLoader classLoader = this.getParent();
        if (classLoader != null) {
            return classLoader.loadClass(string);
        }
        return this.findSystemClass(string);
    }

    private void d(@NotNull String string) throws IllegalAccessException {
        try {
            this.c.invoke(this.getParent(), string, null, null, null, null, null, null, null);
        }
        catch (IllegalArgumentException | InvocationTargetException exception) {
            // empty catch block
        }
    }

    @NotNull
    private Class<?> e(@NotNull String string) throws ClassFormatError {
        try {
            return this.loadClass(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new ClassFormatError(classNotFoundException.getMessage());
        }
    }

    @NotNull
    private Class<?> f(@NotNull String string) throws ClassNotFoundException {
        try {
            byte[] byArray = this.g(string);
            if (byArray != null) {
                return this.a(string, byArray);
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
        return this.c(string);
    }

    @Nullable
    private byte[] g(@NotNull String string) throws IOException {
        String string2 = this.e.get(string.replace(a, ""));
        if (string2 == null) {
            return null;
        }
        FileObject fileObject = this.f.a(string2);
        return this.f.a(fileObject);
    }

    static {
        ClassLoader.registerAsParallelCapable();
    }
}

