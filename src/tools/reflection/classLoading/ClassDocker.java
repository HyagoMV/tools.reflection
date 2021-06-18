/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  javassist.CannotCompileException
 *  javassist.ClassPool
 *  javassist.Loader
 *  javassist.NotFoundException
 */
package tools.reflection.classLoading;

import java.lang.reflect.Method;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.Loader;
import javassist.NotFoundException;
import org.jetbrains.annotations.NotNull;
import tools.reflection.classLoading.r;

public class ClassDocker
extends Loader {
    @NotNull
    private static final String[] a = new String[]{"javassist", "org.jboss"};

    public ClassDocker(@NotNull ClassLoader classLoader) {
        super(classLoader, null);
        for (String string : a) {
            this.delegateLoadingOf(string + '.');
        }
        this.delegateLoadingOf(ClassDocker.class.getCanonicalName());
        ClassPool classPool = ClassPool.getDefault();
        this.a(classPool);
    }

    private void a(@NotNull ClassPool classPool) {
        try {
            this.addTranslator(classPool, new r());
        }
        catch (CannotCompileException | NotFoundException throwable) {
            throw new ExceptionInInitializerError(throwable);
        }
    }

    static {
        try {
            Class<?> clazz = Class.forName("java.lang.ClassLoader$ParallelLoaders");
            Method method = clazz.getDeclaredMethod("register", Class.class);
            boolean bl = method.isAccessible();
            method.setAccessible(true);
            method.invoke(null, Loader.class);
            method.setAccessible(bl);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        ClassLoader.registerAsParallelCapable();
    }
}

