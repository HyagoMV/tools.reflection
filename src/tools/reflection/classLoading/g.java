/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.Logger
 */
package tools.reflection.classLoading;

import java.lang.annotation.Annotation;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import tools.containers.y;

public final class g {
    public static <T, A extends Annotation> void a(
    		@NotNull Class<? extends T> clazz, 
    		@Nullable Class<A> clazz2, 
    		boolean bl, 
    		@NotNull a_<T, A> a_2) {
        h h2 = g.a();
        f f2 = g.a(clazz, clazz2, bl, h2);
        for (Map.Entry entry : f2.a().entrySet()) {
            a_2.found((Class) entry.getKey(), (A) entry.getValue());
        }
    }

    public static <T, A extends Annotation> void b(@NotNull Class<? extends T> clazz, @Nullable Class<A> clazz2, boolean bl, @NotNull a_<T, A> a_2) {
        h h2 = h.c();
        if (h2 instanceof i && !i.j()) {
            Logger.getLogger(g.class).info((Object)"Can't lazy search for classes without ClassesFinderAgent");
            h2 = g.a();
        }
        f f2 = g.a(clazz, clazz2, bl, h2);
        for (Map.Entry entry : f2.a().entrySet()) {
            a_2.found((Class)entry.getKey(), (A) entry.getValue());
        }
        f2.a(a_2);
    }

    @NotNull
    private static h a() {
        h h2 = h.c();
        if (!(h2 instanceof j)) {
            Logger.getLogger(g.class).info((Object)("Can't search for classes with not release classes loader (found " + h2 + ')'));
            h.e();
            h2 = h.c();
        }
        return h2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NotNull
    private static <T, A extends Annotation> f a(@NotNull Class<? extends T> clazz, @Nullable Class<A> clazz2, boolean bl, @NotNull h h2) {
        f f2;
        Map<e, f> map = h2.i();
        e e2 = new e(clazz, clazz2, bl);
        Map<e, f> map2 = map;
        synchronized (map2) {
            f2 = map.get(e2);
            if (f2 == null) {
                Map<Class<?>, Annotation> map3 = y.b();
                Iterable<Class<?>> iterable = h2.f();
                for (Class<?> clazz3 : iterable) {
                    if (!e2.a(clazz3)) continue;
                    map3.put(clazz3, (Annotation)(clazz2 == null ? null : (Object)clazz3.getAnnotation(clazz2)));
                }
                f2 = new f(e2, map3);
                map.put(e2, f2);
            }
        }
        return f2;
    }

    private g() {
    }

    public static interface a_<E, V extends Annotation> {
        public void found(@NotNull Class<? extends E> var1, @Nullable V var2);
    }
}

