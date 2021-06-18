/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.Logger
 */
package tools.reflection;

import gnu.trove.IdentityObjectHashingStrategy;
import gnu.trove.THashMap;
import gnu.trove.THashSet;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tools.containers.hc;
import tools.reflection.cb;
import tools.reflection.s;
import tools.reflection.u;
import tools.reflection.v;

public final class t {
    @NotNull
    private static final Logger a = Logger.getLogger(t.class);
    @NotNull
    private final Map<Object, s> b = new IdentityHashMap<Object, s>();
    @NotNull
    private final u c;
    @NotNull
    private final d_ d;
    private final boolean e;
    @NotNull
    private s f;

    @NotNull
    public static t a(@NotNull Object object) {
        return t.a(object, new c_());
    }

    @NotNull
    public static t a(@NotNull Object object, @NotNull d_ d_2) {
        return new t(object, v.a(), d_2, true);
    }

    @NotNull
    public static t b(@NotNull Object object) {
        return t.b(object, new c_());
    }

    @NotNull
    public static t b(@NotNull Object object, @NotNull d_ d_2) {
        return new t(object, v.b(), d_2, true);
    }

    @NotNull
    public static Object[] a(@NotNull s s2) {
        ArrayList<s> arrayList = new ArrayList<s>();
        for (s objectArray2 : s2.f()) {
            arrayList.add(objectArray2);
        }
        Collections.sort(arrayList, new Comparator<s>(){

            public int compare(@NotNull s s2, @NotNull s s3) {
                if (s2.c() < s3.c()) {
                    return 1;
                }
                if (s2.c() > s3.c()) {
                    return -1;
                }
                if (s2.b() < s3.b()) {
                    return 1;
                }
                if (s2.b() > s3.b()) {
                    return -1;
                }
                return 0;
            }

        });
        Object[] objectArray3 = arrayList.toArray();
        Object[] objectArray = new Object[objectArray3.length + 1];
        objectArray[0] = s2.a();
        System.arraycopy(objectArray3, 0, objectArray, 1, objectArray3.length);
        return objectArray;
    }

    public static long a(@NotNull Object object, @NotNull u u2, @NotNull d_ d_2) {
        hc<Object> hc2 = hc.g();
        THashSet<Object> tHashSet = new THashSet<Object>(IdentityObjectHashingStrategy.instance());
        t.a(hc2, tHashSet, object);
        long l2 = 0L;
        while (!hc2.isEmpty()) {
            Object e2 = hc2.poll();
            l2 += u2.a(e2);
            if (e2.getClass().isArray()) {
                Object[] objectArray;
                Class<?> clazz = e2.getClass().getComponentType();
                if (clazz.isPrimitive()) continue;
                for (Object object2 : objectArray = (Object[])e2) {
                    if (object2 == null || !d_2.a((Object)objectArray, object2)) continue;
                    t.a(hc2, tHashSet, object2);
                }
                continue;
            }
            for (Field field : cb.d(e2)) {
                if (field.getType().isPrimitive() || !d_2.a(e2, field)) continue;
                try {
                    Object object3 = cb.a(e2, field);
                    t.a(hc2, tHashSet, object3);
                }
                catch (cb.b_ b_2) {
                    a.error((Object)("Can not get value for field " + field + " of object " + e2 + ". Reason: " + b_2.getMessage()));
                }
            }
        }
        return l2;
    }

    private static void a(@NotNull Queue<Object> queue, @NotNull Set<Object> set, @Nullable Object object) {
        if (object != null && set.add(object)) {
            queue.add(object);
        }
    }

    public t(@NotNull Object object, @NotNull u u2, @NotNull d_ d_2, boolean bl) {
        this.c = u2;
        this.d = d_2;
        this.e = bl;
        hc<s> hc2 = hc.g();
        this.f = this.a(hc2, object, "");
        while (!hc2.isEmpty()) {
            ((s)hc2.poll()).a(hc2);
        }
        this.f.e();
    }

    @NotNull
    public s a() {
        return this.f;
    }

    @NotNull
    private s a(@NotNull Collection<s> collection, @Nullable Object object, @NotNull String string) {
        if (object == null) {
            return new e_(string);
        }
        s s2 = object.getClass().isArray() ? new b_(object, string) : new f_(object, string);
        this.b.put(object, s2);
        collection.add(s2);
        return s2;
    }

    public static class c_
    implements d_ {
        @Override
        public boolean a(@NotNull Object object, @NotNull Field field) {
            int n2 = field.getModifiers();
            return !Modifier.isStatic(n2);
        }

        @Override
        public boolean a(@NotNull Object object, @NotNull Object object2) {
            return true;
        }
    }

    private final class f_
    implements s {
        @NotNull
        private final String a;
        @NotNull
        private final Object b;
        private final long c;
        private long d = -1L;
        @NotNull
        private final Map<Field, s> e = new THashMap<Field, s>();

        public f_(@NotNull Object object, String string) {
            this.b = object;
            this.a = string;
            this.c = t.this.c.a(object);
            t.this.b.put(object, this);
        }

        public String toString() {
            return this.b.getClass().getSimpleName() + ' ' + this.a + " : " + this.d + '(' + this.c + ')';
        }

        @Override
        @NotNull
        public Object a() {
            return this.b;
        }

        @Override
        public long b() {
            return this.c;
        }

        @Override
        public long c() {
            return this.d;
        }

        @Override
        public long d() {
            return 0L;
        }

        @Override
        public void e() {
            if (this.d >= 0L) {
                return;
            }
            this.d = this.c;
            for (s s2 : this.e.values()) {
                s2.e();
                this.d += s2.c();
            }
        }

        @Override
        @NotNull
        public Iterable<s> f() {
            return this.e.values();
        }

        @Override
        public void a(@NotNull Collection<s> collection) {
            for (Field field : cb.d(this.b)) {
                if (field.getType().isPrimitive() || !t.this.d.a(this.b, field)) continue;
                Object object = this.a(field);
                s s2 = (s)t.this.b.get(object);
                if (s2 != null) continue;
                this.e.put(field, t.this.a(collection, object, field.getName()));
            }
        }

        @Nullable
        private Object a(@NotNull Field field) {
            try {
                return cb.a(this.b, field);
            }
            catch (cb.b_ b_2) {
                t.this.a.error(("Can not get value for field " + field + " of object " + this.b + ". Reason: " + b_2.getMessage()));
                return null;
            }
        }
    }

    private static final class e_
    implements s {
        @NotNull
        private final String a;

        private e_(@NotNull String string) {
            this.a = string;
        }

        @NotNull
        public String toString() {
            return this.a + " : null";
        }

        @Override
        @Nullable
        public Object a() {
            return null;
        }

        @Override
        public long b() {
            return 0L;
        }

        @Override
        public long c() {
            return 0L;
        }

        @Override
        public long d() {
            return 0L;
        }

        @Override
        public void e() {
        }

        @Override
        @NotNull
        public Iterable<s> f() {
            return Collections.emptyList();
        }

        @Override
        public void a(@NotNull Collection<s> collection) {
        }
    }

    private final class b_
    implements s {
        @NotNull
        private final Object a;
        @NotNull
        private final String b;
        private final long c;
        private long d = -1L;
        @NotNull
        private final List<s> e = new ArrayList<s>();
        @NotNull
        private final Class<?> f;

        private b_(@NotNull Object object, String string) {
            this.a = object;
            this.b = string;
            this.c = t.this.c.a(object);
            t.this.b.put(object, this);
            this.f = object.getClass().getComponentType();
            if (this.f.isPrimitive()) {
                this.d = this.c;
            }
        }

        public String toString() {
            return this.a.getClass().getComponentType().getSimpleName() + "[]" + this.b + " : " + this.d + '(' + this.c + ')';
        }

        @Override
        @NotNull
        public Object a() {
            return this.a;
        }

        @Override
        public long b() {
            return this.c;
        }

        @Override
        public long c() {
            return this.d;
        }

        @Override
        public long d() {
            return 0L;
        }

        @Override
        public void e() {
            if (this.d >= 0L) {
                return;
            }
            this.d = this.c;
            for (s s2 : this.e) {
                s2.e();
                this.d += s2.c();
            }
        }

        @Override
        @NotNull
        public Iterable<s> f() {
            return this.e;
        }

        @Override
        public void a(@NotNull Collection<s> collection) {
            if (!this.f.isPrimitive() && t.this.e) {
                for (int i2 = 0; i2 < Array.getLength(this.a); ++i2) {
                    s s2;
                    Object object = Array.get(this.a, i2);
                    if (object == null || !t.this.d.a(this.a, object) || (s2 = (s)t.this.b.get(object)) != null) continue;
                    this.e.add(t.this.a(collection, object, "item " + i2));
                }
            }
        }
    }

    public static interface d_ {
        public boolean a(@NotNull Object var1, @NotNull Field var2);

        public boolean a(@NotNull Object var1, @NotNull Object var2);
    }
}

