/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection.classLoading;

import asserts.Verify;
import gnu.trove.THashSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tools.containers.hc;

public final class d {
    @NotNull
    private static final Object a = new Object();
    @NotNull
    private static Collection<a_> b = new ArrayList<a_>();
    @NotNull
    private static Set<Class<?>> c = new THashSet();
    @NotNull
    private static Set<String> d = new THashSet<String>();
    @NotNull
    private static Collection<String> e = new ConcurrentLinkedQueue<String>();
    @NotNull
    private static Queue<String> f = new hc<String>();
    private static volatile boolean g = false;

    private d() {
    }

    static void a() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static void a(Class<?> ... classArray) {
        Object object = a;
        synchronized (object) {
            for (Class<?> clazz : classArray) {
                tools.reflection.classLoading.d.a(clazz);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void a(@NotNull a_ a_2) {
        Object object = a;
        synchronized (object) {
            if (!b.contains(a_2)) {
                b.add(a_2);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NotNull
    public static Collection<Class<?>> b() {
        Object object = a;
        synchronized (object) {
            return new ArrayList(c);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void a(@NotNull String string) {
        Object object = a;
        synchronized (object) {
            f.add(string);
            if (!g) {
                g = true;
                while (!f.isEmpty()) {
                    String string2 = f.poll();
                    if (tools.reflection.classLoading.d.b(string)) continue;
                    if (!tools.reflection.classLoading.d.c(string2)) {
                        Verify.fail("Failed to find class " + string2);
                    }
                    ArrayList<String> arrayList = new ArrayList<String>(e);
                    for (String string3 : arrayList) {
                        if (!tools.reflection.classLoading.d.c(string3)) continue;
                        e.remove(string3);
                    }
                }
                g = false;
            }
        }
    }

    private static boolean b(@NotNull String string) {
        if (d.contains(string)) {
            return true;
        }
        d.add(string);
        return false;
    }

    private static boolean c(@NotNull String string) {
        try {
            Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass(tools.reflection.classLoading.d.d(string));
            return tools.reflection.classLoading.d.a(clazz);
        }
        catch (ClassNotFoundException classNotFoundException) {
            return string.toLowerCase().contains("javac") || string.startsWith("com/sun/source");
        }
    }

    private static boolean a(@Nullable Class<?> clazz) {
        if (clazz == null) {
            return false;
        }
        if (c.add(clazz)) {
            for (a_ a_2 : b) {
                tools.reflection.classLoading.d.a(clazz, a_2);
            }
        }
        if (clazz.getEnclosingClass() != null && clazz.getEnclosingClass().isInterface()) {
            f.add(clazz.getEnclosingClass().getName());
        }
        return true;
    }

    @NotNull
    private static String d(@NotNull String string) {
        return string.replace('/', '.');
    }

    public static void e(@NotNull String string) {
        e.add(string);
    }

    private static void a(@NotNull Class<?> clazz, @NotNull a_ a_2) {
        try {
            a_2.a(clazz);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    static {
        try {
            tools.reflection.classLoading.d.a(d.class.getCanonicalName());
            tools.reflection.classLoading.d.a(Verify.class.getCanonicalName());
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public static interface a_ {
        public void a(@NotNull Class<?> var1);
    }
}

