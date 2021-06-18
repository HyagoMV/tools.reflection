/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection;

import asserts.Verify;
import gnu.trove.TIntHashSet;
import java.lang.ref.SoftReference;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import tools.containers.hc;
import tools.reflection.bb;
import tools.reflection.cb;
import tools.reflection.y;

public final class z {
    @NotNull
    private static final Map<Class<?>, Object> a = new ConcurrentHashMap();
    @NotNull
    private static final Map<b_, Object> b = new ConcurrentHashMap<b_, Object>();
    @NotNull
    private final TIntHashSet c = new TIntHashSet();
    @NotNull
    private final List<String> d = new ArrayList<String>();
    @NotNull
    private final String[] e;
    private boolean f = true;
    @NotNull
    private final a_ g;
    @NotNull
    private final List<bb> h = hc.g();

    public static void a(@NotNull Class<?> clazz) {
        a.put(clazz, 1);
    }

    public static boolean a(@NotNull Field field) {
        int n2 = field.getModifiers();
        Class<?> clazz = field.getType();
        if (Modifier.isStatic(n2) || Modifier.isTransient(n2) && !clazz.getCanonicalName().startsWith("java.")) {
            return false;
        }
        return z.b(field.getType());
    }

    public static boolean b(@NotNull Class<?> clazz) {
        if (SoftReference.class.isAssignableFrom(clazz)) {
            return false;
        }
        return !clazz.equals(Class.class);
    }

    private static boolean c(@NotNull Class<?> clazz) {
        if (clazz == Class.class) {
            return true;
        }
        if (clazz.isPrimitive()) {
            return true;
        }
        for (Class<?> clazz2 : a.keySet()) {
            if (!clazz2.isAssignableFrom(clazz)) continue;
            return true;
        }
        return false;
    }

    public static boolean a(@NotNull Object object) {
        for (b_ b_2 : b.keySet()) {
            if (b_2.a(object)) continue;
            return false;
        }
        return true;
    }

    public static void a(@NotNull b_ b_2) {
        b.put(b_2, 1);
    }

    @NotNull
    public static z a(@NotNull Object object, @NotNull a_ a_2) {
        return new z(object, a_2);
    }

    public z(@NotNull Object object, @NotNull a_ a_2) {
        this(object, new String[]{"currentCollection"}, a_2);
    }

    public z(@NotNull Object object, @NotNull String[] stringArray, @NotNull a_ a_2) {
        this.e = stringArray;
        this.g = a_2;
        this.h.add(new bb(object, null));
        this.c();
    }

    @NotNull
    public String a() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : this.d) {
            stringBuilder.append(string);
            stringBuilder.append("\n\n");
        }
        return stringBuilder.toString();
    }

    public boolean b() {
        return this.f;
    }

    private void c() {
        while (!this.h.isEmpty()) {
            int n2;
            bb bb2 = this.h.remove(0);
            if (y.a(bb2.b().getClass()) || this.c.contains(n2 = System.identityHashCode(bb2.b()))) continue;
            if (!this.g.a(bb2, this.d)) {
                this.f = false;
            }
            this.c.add(n2);
            Class<?> clazz = bb2.b().getClass().getComponentType();
            if (clazz != null) {
                if (z.c(clazz)) continue;
                this.a(bb2);
                continue;
            }
            this.b(bb2);
        }
    }

    private void a(@NotNull bb bb2) {
        int n2 = Array.getLength(bb2.b());
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object = Array.get(bb2.b(), i2);
            if (object == null || z.c(object.getClass()) || !this.g.a(object.getClass())) continue;
            this.h.add(new bb(object, bb2));
        }
    }

    private void b(@NotNull bb bb2) {
        for (Class<?> clazz : cb.b(bb2.b())) {
            for (Field field : clazz.getDeclaredFields()) {
                String string;
                if (!this.g.a(field) || this.a(string = field.getName())) continue;
                try {
                    Object object = cb.a(bb2.b(), field);
                    if (object == null || z.c(object.getClass()) || !this.g.a(object)) continue;
                    this.h.add(new bb(object, bb2));
                }
                catch (cb.b_ b_2) {
                    Verify.fail("exception getting field " + field + " of obj " + bb2.b(), b_2);
                }
            }
        }
    }

    private boolean a(@NotNull String string) {
        for (String string2 : this.e) {
            if (!string2.equals(string)) continue;
            return true;
        }
        return false;
    }

    public static interface a_ {
        public boolean a(@NotNull bb var1, @NotNull List<String> var2);

        public boolean a(@NotNull Field var1);

        public boolean a(@NotNull Class<?> var1);

        public boolean a(@NotNull Object var1);
    }

    public static interface b_ {
        public boolean a(@NotNull Object var1);
    }
}

