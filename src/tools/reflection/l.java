/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection;

import asserts.Verify;
import gnu.trove.THashMap;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tools.reflection.cb;
import tools.reflection.j;
import tools.reflection.m;

public final class l {
    private l() {
    }

    public static boolean a(@Nullable Object object, @Nullable Object object2, @NotNull m m2) {
        return l.a(object, object2, false, new a_(), null, m2);
    }

    @NotNull
    public static String b(@Nullable Object object, @Nullable Object object2, @NotNull m m2) {
        StringBuilder stringBuilder = new StringBuilder();
        if (l.a(object, object2, false, new a_(), stringBuilder, m2)) {
            return "";
        }
        return stringBuilder.insert(0, object == null ? "Null" : object.getClass().getSimpleName()).toString();
    }

    private static boolean a(@Nullable Object object, @Nullable Object object2, boolean bl, @NotNull a_ a_2, @Nullable StringBuilder stringBuilder, @NotNull m m2) {
        if (object == object2) {
            return true;
        }
        if (object == null || object2 == null) {
            return false;
        }
        if (bl) {
            return object.equals(object2);
        }
        if (object.equals(object2)) {
            return true;
        }
        b_ b_2 = new b_(object, object2);
        if (a_2.a(b_2)) {
            return true;
        }
        Boolean bl2 = a_2.b(b_2);
        if (bl2 != null) {
            return bl2;
        }
        boolean bl3 = l.a(object, object2, new a_(a_2, b_2), stringBuilder, m2);
        a_2.a(b_2, bl3);
        return bl3;
    }

    private static boolean a(@NotNull Object object, @NotNull Object object2, @NotNull a_ a_2, @Nullable StringBuilder stringBuilder, @NotNull m m2) {
        for (j j2 : m2.c()) {
            if (!j2.a(object) && !j2.a(object2)) continue;
            return true;
        }
        if (!object2.getClass().equals(object.getClass())) {
            return false;
        }
        if (object.getClass().isArray()) {
            return l.c(object, object2, a_2, stringBuilder, m2);
        }
        if (object instanceof Collection && object2 instanceof Collection) {
            if (m2.b()) {
                return l.b((Collection)object, (Collection)object2, a_2, stringBuilder, m2);
            }
            return l.a((Collection)object, (Collection)object2, a_2, stringBuilder, m2);
        }
        if (object instanceof Map && object2 instanceof Map) {
            return l.a((Map)object, (Map)object2, a_2, stringBuilder, m2);
        }
        return l.b(object, object2, a_2, stringBuilder, m2);
    }

    private static boolean a(@NotNull Collection<?> collection, @NotNull Collection<?> collection2, @NotNull a_ a_2, @Nullable StringBuilder stringBuilder, @NotNull m m2) {
        Iterator<?> iterator = collection.iterator();
        Iterator<?> iterator2 = collection2.iterator();
        int n2 = 0;
        while (iterator.hasNext() && iterator2.hasNext()) {
            if (!l.a(iterator.next(), iterator2.next(), false, a_2, stringBuilder, m2)) {
                if (stringBuilder != null) {
                    stringBuilder.insert(0, MessageFormat.format(".item[{0}]", n2));
                }
                return false;
            }
            ++n2;
        }
        return !iterator.hasNext() && !iterator2.hasNext();
    }

    private static boolean a(@NotNull Map<?, ?> map, @NotNull Map<?, ?> map2, @NotNull a_ a_2, @Nullable StringBuilder stringBuilder, @NotNull m m2) {
        if (map.size() != map2.size()) {
            if (stringBuilder != null) {
                stringBuilder.insert(0, MessageFormat.format(".size. Expected {0}, but got: {1}", map.size(), map2.size()));
            }
            return false;
        }
        THashMap tHashMap = new THashMap();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            tHashMap.put(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<?, ?> entry : map2.entrySet()) {
            boolean bl = false;
            boolean bl2 = false;
            Object var10_10 = null;
            for (Object o : tHashMap.entrySet()) {
            	Map.Entry entry2 = (Map.Entry) o; 
                if (!l.a(entry2.getKey(), entry.getKey(), false, a_2, new StringBuilder(), m2)) continue;
                bl = true;
                var10_10 = entry2.getValue();
                if (!l.a(entry2.getValue(), entry.getValue(), false, a_2, new StringBuilder(), m2)) continue;
                bl2 = true;
                tHashMap.remove(entry2.getKey());
                break;
            }
            if (!bl) {
                if (stringBuilder != null) {
                    stringBuilder.insert(0, MessageFormat.format(".item[{0}] = {1} expected, but not found", entry.getKey(), entry.getValue()));
                }
                return false;
            }
            if (bl2) continue;
            if (stringBuilder != null) {
                stringBuilder.insert(0, MessageFormat.format(".item[{0}] = {1} expected, but found {2}", entry.getKey(), entry.getValue(), var10_10));
            }
            return false;
        }
        return true;
    }

    private static boolean b(@NotNull Collection<?> collection, @NotNull Collection<?> collection2, @NotNull a_ a_2, @Nullable StringBuilder stringBuilder, @NotNull m m2) {
        if (collection.size() != collection2.size()) {
            if (stringBuilder != null) {
                stringBuilder.insert(0, MessageFormat.format(".size. Expected {0}, but got: {1}", collection.size(), collection2.size()));
            }
            return false;
        }
        if (collection.size() == 1) {
            return l.a(collection, collection2, a_2, stringBuilder, m2);
        }
        ArrayList arrayList = new ArrayList();
        for (Object object : collection) {
            arrayList.add(object);
        }
        int n2 = 0;
        for (Object e2 : collection2) {
            boolean bl = false;
            for (Object e3 : arrayList) {
                if (!l.a(e3, e2, false, a_2, new StringBuilder(), m2)) continue;
                bl = true;
                arrayList.remove(e3);
                break;
            }
            if (!bl) {
                if (stringBuilder != null) {
                    stringBuilder.insert(0, MessageFormat.format(".item[{0}] Expected: {1} but not found", n2, e2));
                }
                return false;
            }
            ++n2;
        }
        return true;
    }

    private static boolean b(@NotNull Object object, @NotNull Object object2, @NotNull a_ a_2, @Nullable StringBuilder stringBuilder, @NotNull m m2) {
        for (Field field : cb.d(object)) {
            int n2 = field.getModifiers();
            if (Modifier.isStatic(n2)) continue;
            try {
                Object object3 = cb.a(object, field);
                Object object4 = cb.a(object2, field);
                if (l.a(m2, field) || l.a(object3, object4, field.getType().isPrimitive(), a_2, stringBuilder, m2)) continue;
                if (stringBuilder != null) {
                    stringBuilder.insert(0, MessageFormat.format(".{0}", field.getName()));
                }
                return false;
            }
            catch (cb.b_ b_2) {
                Verify.fail(MessageFormat.format("Can not compare {0} and {1}. Assume different", object, object2), b_2);
                if (stringBuilder != null) {
                    stringBuilder.insert(0, "...Interrupted by exception ").append(b_2);
                }
                return false;
            }
        }
        return true;
    }

    private static boolean a(@NotNull m m2, @NotNull Field field) {
        for (j j2 : m2.c()) {
            if (!j2.a(field)) continue;
            return true;
        }
        return false;
    }

    private static boolean c(@NotNull Object object, @NotNull Object object2, @NotNull a_ a_2, @Nullable StringBuilder stringBuilder, @NotNull m m2) {
        Class<?> clazz;
        int n2;
        int n3 = Array.getLength(object);
        if (n3 != (n2 = Array.getLength(object2))) {
            return false;
        }
        Class<?> clazz2 = object.getClass().getComponentType();
        if (!clazz2.equals(clazz = object2.getClass().getComponentType())) {
            if (stringBuilder != null) {
                stringBuilder.insert(0, MessageFormat.format("[{1}<->{2}]", clazz2, clazz));
            }
            return false;
        }
        boolean bl = clazz2.isPrimitive();
        for (int i2 = 0; i2 < n3; ++i2) {
            if (l.a(Array.get(object, i2), Array.get(object2, i2), bl, a_2, stringBuilder, m2)) continue;
            if (stringBuilder != null) {
                stringBuilder.insert(0, MessageFormat.format("[{0}]", i2));
            }
            return false;
        }
        return true;
    }

    private static final class a_ {
        @NotNull
        private final Map<b_, Boolean> a;
        @Nullable
        private final b_ b;
        @Nullable
        private final a_ c;

        public a_() {
            this.a = new THashMap<b_, Boolean>();
            this.b = null;
            this.c = null;
        }

        public a_(@NotNull a_ a_2, @Nullable b_ b_2) {
            this.c = a_2;
            this.a = a_2.a;
            this.b = b_2;
        }

        public boolean a(@NotNull b_ b_2) {
            a_ a_2 = this;
            while (true) {
                if (b_2.equals(a_2.b)) {
                    return true;
                }
                if (a_2.c == null) break;
                a_2 = a_2.c;
            }
            return false;
        }

        @Nullable
        public Boolean b(@NotNull b_ b_2) {
            return this.a.get(b_2);
        }

        public void a(@NotNull b_ b_2, boolean bl) {
            this.a.put(b_2, bl);
        }
    }

    private static final class b_ {
        @NotNull
        private final Object a;
        @NotNull
        private final Object b;

        public b_(@NotNull Object object, @NotNull Object object2) {
            this.a = object;
            this.b = object2;
        }

        public boolean equals(@Nullable Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || this.getClass() != object.getClass()) {
                return false;
            }
            b_ b_2 = (b_)object;
            return this.a == b_2.a && this.b == b_2.b || this.a == b_2.b && this.b == b_2.a;
        }

        public int hashCode() {
            return this.a.hashCode() + this.b.hashCode();
        }
    }
}

