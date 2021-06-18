/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection.classLoading;

import gnu.trove.THashMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tools.containers.y;
import tools.reflection.classLoading.e;
import tools.reflection.classLoading.f;
import tools.reflection.classLoading.i;
import tools.reflection.classLoading.j;
import tools.reflection.classLoading.n;
import tools.reflection.classLoading.o;

public abstract class h {
    @NotNull
    private static final THashMap<String, h> a = new THashMap();
    @Nullable
    private static h b;
    private static boolean c;
    @NotNull
    private static final Object d;
    @NotNull
    private final Map<e, f> e = y.c();

    public static boolean a() {
        return b != null;
    }

    public static void b() {
        if (!c) {
            b = new i();
        }
    }

    @NotNull
    public static h c() {
        if (b == null) {
            throw new RuntimeException("can't get ClassesLoader instance, not initialized");
        }
        return b;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void d() {
        Object object = d;
        synchronized (object) {
            if (c) {
                return;
            }
            if (b == null) {
                if (i.j()) {
                    b = new i();
                } else {
                    h.e();
                }
            }
        }
    }

    public static void e() {
        h.a(n.a());
    }

    public static void a(@NotNull String[] stringArray) {
        ArrayList<o> arrayList = new ArrayList<o>(stringArray.length);
        for (String string : stringArray) {
            arrayList.add(new o(string));
        }
        h.a(arrayList.toArray(new o[arrayList.size()]));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    public static void a(@NotNull o[] _0) {
        Object _1 = d;
        synchronized (_1) {
            c = true;
            StringBuilder _2 = new StringBuilder();
            for (int i = 0; i < _0.length; i++) {
            	_2.append(_0[i]).append("#$");
            }
            
            h _3 = a.get(_2.toString());
            if (_3 == null) {
            	j __3 = new j(Collections.<Class<?>>emptyList(), _0);
            	a.put(_2.toString(), __3);
            	b = _3;
            }
        }
    }

    @NotNull
    public abstract Class<?> a(int var1);

    public abstract int a(@NotNull Class<?> var1);

    @NotNull
    public abstract Iterable<Class<?>> f();

    public abstract int g();

    public abstract boolean h();

    public abstract boolean b(int var1);

    protected abstract boolean b(@NotNull Class<?> var1);

    protected abstract boolean c(@NotNull Class<?> var1);

    protected void a(@NotNull Iterable<Class<?>> iterable) {
        this.b(a_.class);
        this.a(Class.class, Boolean.class, Byte.class, Character.class, Short.class, Integer.class, Long.class, Float.class, Double.class, String.class, List.class, ArrayList.class, LinkedHashMap.class, ArrayDeque.class, LinkedList.class, HashSet.class, LinkedHashSet.class, TreeSet.class, HashMap.class, IdentityHashMap.class, TreeMap.class, Boolean.TYPE, Byte.TYPE, Character.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE);
        this.c(iterable);
    }

    public void b(@NotNull Iterable<Class<?>> iterable) {
        for (Class<?> clazz : iterable) {
            this.c(clazz);
        }
    }

    public void c(@NotNull Iterable<Class<?>> iterable) {
        for (Class<?> clazz : iterable) {
            this.b(clazz);
        }
    }

    protected void a(Class<?> ... classArray) {
        for (Class<?> clazz : classArray) {
            this.b(clazz);
        }
    }

    @NotNull
    final Map<e, f> i() {
        return this.e;
    }

    static {
        c = false;
        d = new Object();
    }

    public static interface a_ {
    }
}

