/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection;

import asserts.Verify;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tools.reflection.cb;
import tools.reflection.y;

public final class db
implements Serializable {
    @NotNull
    private final List<b_> a = new ArrayList<b_>();
    @NotNull
    private final Set<Class<?>> b = new LinkedHashSet();
    @NotNull
    private final Set<Class<?>> c = new LinkedHashSet();
    @NotNull
    private final Map<Class<?>, Set<String>> d = new LinkedHashMap();

    public boolean a() {
        return this.a.isEmpty();
    }

    public void a(@NotNull Object object, @NotNull Object object2) {
        this.a.clear();
        new c_().b("", object, object2);
    }

    @NotNull
    public List<b_> b() {
        return this.a;
    }

    @NotNull
    public String c() {
        StringBuilder stringBuilder = new StringBuilder("ReflexComparator: ");
        stringBuilder.append(this.a() ? "equals" : "different").append('\n');
        for (b_ b_2 : this.a) {
            stringBuilder.append(b_2.a).append(" = ").append(b_2.b).append(" != ").append(b_2.c).append('\n');
        }
        return stringBuilder.toString();
    }

    public void a(@NotNull Class<?> clazz) {
        this.b.add(clazz);
    }

    public void a(@NotNull Class<?> clazz, @NotNull String string) {
        try {
            clazz.getDeclaredField(string);
            Set<String> set = this.d.get(clazz);
            if (set == null) {
                set = new LinkedHashSet<String>();
                this.d.put(clazz, set);
            }
            set.add(string);
        }
        catch (NoSuchFieldException noSuchFieldException) {
            Verify.warning("Cant ignore field " + string + " Field not found in class " + clazz.getName());
        }
    }

    public void b(@NotNull Class<?> clazz) {
        this.c.add(clazz);
    }

    private final class c_ {
        @NotNull
        private final Map<Object, String> a = new IdentityHashMap<Object, String>();
        @NotNull
        private final Map<Object, String> b = new IdentityHashMap<Object, String>();

        private c_() {
        }

        private boolean a(@NotNull String string, @NotNull Object object, @NotNull Object object2) {
            Class<?> clazz;
            Class<?> clazz2 = object.getClass();
            if (this.a(clazz2, clazz = object2.getClass())) {
                return false;
            }
            if (!clazz2.equals(object2.getClass())) {
                db.this.a.add(new b_(string, clazz2.toString(), clazz.toString()));
                return false;
            }
            return !db.this.b.contains(clazz2);
        }

        private void b(@NotNull String string, @Nullable Object object, @Nullable Object object2) {
            String string2 = this.a.get(object);
            if (string2 != null) {
                if (!string2.equals(this.b.get(object2))) {
                    db.this.a.add(new b_(string, String.valueOf(object), String.valueOf(object2)));
                }
                return;
            }
            if (this.b.get(object2) != null) {
                db.this.a.add(new b_(string, String.valueOf(object), String.valueOf(object2)));
                return;
            }
            this.a.put(object, string);
            this.b.put(object2, string);
            if (object == object2) {
                return;
            }
            if (object == null || object2 == null) {
                db.this.a.add(new b_(string, String.valueOf(object), String.valueOf(object2)));
                return;
            }
            if (!this.a(string, object, object2)) {
                return;
            }
            if (y.a(object.getClass())) {
                if (!object.equals(object2)) {
                    db.this.a.add(new b_(string, object.toString(), object2.toString()));
                }
                return;
            }
            this.c(string, object, object2);
        }

        private void c(@NotNull String string, @NotNull Object object, @NotNull Object object2) {
            for (Class<?> clazz : cb.b(object)) {
                Set set = (Set)db.this.d.get(clazz);
                for (Field field : clazz.getDeclaredFields()) {
                    if (Modifier.isStatic(field.getModifiers()) || Modifier.isTransient(field.getModifiers()) || set != null && set.contains(field.getName())) continue;
                    try {
                        Object object3 = cb.a(object, field);
                        Object object4 = cb.a(object2, field);
                        this.b(string + '.' + field.getName(), object3, object4);
                    }
                    catch (cb.b_ b_2) {
                        Verify.fail("exception getting field values", b_2);
                    }
                }
            }
        }

        @Nullable
        private Class<?> a(@NotNull Class<?> clazz) {
            for (Class<?> clazz2 = clazz; clazz2 != null; clazz2 = clazz2.getSuperclass()) {
                if (!db.this.c.contains(clazz2)) continue;
                return clazz2;
            }
            return null;
        }

        private boolean a(@NotNull Class<?> clazz, @NotNull Class<?> clazz2) {
            Class<?> clazz3 = this.a(clazz);
            if (clazz3 == null) {
                return false;
            }
            Class<?> clazz4 = this.a(clazz2);
            if (clazz4 == null) {
                return false;
            }
            return clazz3.equals(clazz4);
        }
    }

    public static final class b_
    implements Serializable {
        @NotNull
        private final String a;
        @NotNull
        private final String b;
        @NotNull
        private final String c;

        public b_(@NotNull String string, @NotNull String string2, @NotNull String string3) {
            this.a = string;
            this.b = string2;
            this.c = string3;
        }
    }
}

