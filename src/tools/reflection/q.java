/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.apache.commons.lang.ArrayUtils
 */
package tools.reflection;

import asserts.Verify;
import gnu.trove.IdentityObjectHashingStrategy;
import gnu.trove.THashSet;
import gnu.trove.TObjectIntHashMap;
import gnu.trove.TObjectProcedure;
import java.lang.ref.SoftReference;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import org.apache.commons.lang.ArrayUtils;
import org.jetbrains.annotations.NotNull;
import tools.containers.hc;
import tools.reflection.cb;
import tools.reflection.w;
import tools.reflection.y;

public final class q {
    @NotNull
    private static final THashSet<Class<?>> a = new THashSet();
    @NotNull
    private final TObjectIntHashMap<Object> b = new TObjectIntHashMap(IdentityObjectHashingStrategy.instance());
    @NotNull
    private final String[] c;
    @NotNull
    private final b_ d;
    @NotNull
    private final List<w> e = hc.g();

    public static void a(@NotNull Class<?> clazz) {
        a.add(clazz);
    }

    public static boolean a(@NotNull Field field) {
        int n2 = field.getModifiers();
        Class<?> clazz = field.getType();
        if (Modifier.isStatic(n2) || Modifier.isTransient(n2) && !clazz.getCanonicalName().startsWith("java.")) {
            return false;
        }
        if (SoftReference.class.isAssignableFrom(clazz)) {
            return false;
        }
        return !clazz.equals(Class.class);
    }

    private static boolean b(final @NotNull Class<?> clazz) {
        if (clazz == Class.class) {
            return true;
        }
        if (clazz.isPrimitive()) {
            return true;
        }
        return !a.forEach(new TObjectProcedure<Class<?>>(){

            public boolean execute(@NotNull Class<?> clazz2) {
                return !clazz2.isAssignableFrom(clazz);
            }

        });
    }

    public q(@NotNull Object object, @NotNull b_ b_2) {
        this(object, ArrayUtils.EMPTY_STRING_ARRAY, b_2);
    }

    public q(@NotNull Object object, @NotNull String[] stringArray, @NotNull b_ b_2) {
        this.c = stringArray;
        this.d = b_2;
        this.e.add(new w(object, null, null, -1));
        this.a();
    }

    private void a() {
        while (!this.e.isEmpty()) {
            w w2 = this.e.get(0);
            this.e.remove(0);
            if (y.a(w2.c().getClass()) || this.b.containsKey(w2.c())) continue;
            this.d.a(w2);
            if (!this.d.b(w2)) continue;
            this.b.put(w2.c(), this.b.size());
            Class<?> clazz = w2.c().getClass().getComponentType();
            if (clazz != null) {
                if (q.b(clazz)) continue;
                this.a(w2);
                continue;
            }
            this.b(w2);
        }
    }

    private void a(@NotNull w w2) {
        int n2 = Array.getLength(w2.c());
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object = Array.get(w2.c(), i2);
            if (object == null || q.b(object.getClass())) continue;
            this.e.add(new w(object, w2, w2.b(), i2));
        }
    }

    private void b(@NotNull w w2) {
        for (Class<?> clazz : cb.b(w2.c())) {
            for (Field field : clazz.getDeclaredFields()) {
                Class<?> clazz2 = field.getType();
                if (q.b(clazz2) || !this.d.a(field)) continue;
                String string = field.getName();
                boolean bl = w2.d() != null || !this.a(string);
                this.a(w2, field, bl);
            }
        }
    }

    private void a(@NotNull w w2, @NotNull Field field, boolean bl) {
        if (bl) {
            try {
                Object object = cb.a(w2.c(), field);
                if (object != null) {
                    this.e.add(new w(object, w2, field, -1));
                }
            }
            catch (cb.b_ b_2) {
                Verify.fail("exception getting field " + field + " of obj " + w2.c(), b_2);
            }
        }
    }

    private boolean a(@NotNull String string) {
        for (String string2 : this.c) {
            if (!string2.equals(string)) continue;
            return true;
        }
        return false;
    }

    public static interface b_ {
        public void a(@NotNull w var1);

        public boolean a(@NotNull Field var1);

        public boolean b(@NotNull w var1);
    }
}

