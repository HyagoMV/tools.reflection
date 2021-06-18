/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection;

import gnu.trove.THashSet;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tools.wb;

public final class x {
    private x() {
    }

    @NotNull
    public static wb<Boolean, String> a(@Nullable Object object, @Nullable Object object2) {
        return x.a(object, object2, new THashSet<String>());
    }

    @NotNull
    public static wb<Boolean, String> a(@Nullable Object object, @Nullable Object object2, @NotNull Set<String> set) {
        return x.a(object, object2, "this", "", set);
    }

    @NotNull
    private static wb<Boolean, String> a(@Nullable Object object, @Nullable Object object2, @NotNull String string, @NotNull String string2, @NotNull Set<String> set) {
        if (object == object2) {
            return new wb<Boolean, String>(true, string);
        }
        if (object == null || object2 == null) {
            return new wb<Boolean, String>(false, string);
        }
        Class<?> clazz = object.getClass();
        if (!clazz.equals(object2.getClass())) {
            return new wb<Boolean, String>(false, string);
        }
        if (object.equals(object2)) {
            return new wb<Boolean, String>(true, string);
        }
        if (x.a(clazz)) {
            return new wb<Boolean, String>(object.equals(object2), string);
        }
        if (clazz.isArray()) {
            return x.c(object, object2, string, string2, set);
        }
        if (object instanceof Collection) {
            return x.a((Collection)object, (Collection)object2, string, string2, set);
        }
        try {
            return x.b(object, object2, string, string2, set);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException(illegalAccessException);
        }
    }

    private static boolean a(@NotNull Class<?> clazz) {
        return Number.class.isAssignableFrom(clazz) || String.class.isAssignableFrom(clazz) || Boolean.class.isAssignableFrom(clazz) || Character.class.isAssignableFrom(clazz);
    }

    @NotNull
    private static wb<Boolean, String> b(@NotNull Object object, @NotNull Object object2, @NotNull String string, @NotNull String string2, @NotNull Set<String> set) throws IllegalAccessException {
        Class<?> clazz = object.getClass();
        String string3 = string2;
        if (!string3.isEmpty()) {
            string3 = string3 + '.';
        }
        while (clazz != null && !Object.class.equals(clazz)) {
            Field[] fieldArray;
            for (Field field : fieldArray = clazz.getDeclaredFields()) {
                String string4 = string3 + field.getName();
                if (set.contains(string4) || Modifier.isStatic(field.getModifiers())) continue;
                field.setAccessible(true);
                Object object3 = field.get(object);
                Object object4 = field.get(object2);
                wb<Boolean, String> wb2 = x.a(object3, object4, string + '.' + field.getName(), string4, set);
                if (wb2.a().booleanValue()) continue;
                return wb2;
            }
            clazz = clazz.getSuperclass();
        }
        return new wb<Boolean, String>(true, string);
    }

    @NotNull
    private static wb<Boolean, String> c(@Nullable Object object, @Nullable Object object2, @NotNull String string, @NotNull String string2, @NotNull Set<String> set) {
        if (object == object2) {
            return new wb<Boolean, String>(true, string);
        }
        if (object == null || object2 == null) {
            return new wb<Boolean, String>(false, string);
        }
        if (Array.getLength(object) != Array.getLength(object2)) {
            return new wb<Boolean, String>(false, string);
        }
        for (int i2 = 0; i2 < Array.getLength(object); ++i2) {
            wb<Boolean, String> wb2 = x.a(Array.get(object, i2), Array.get(object2, i2), string + '[' + i2 + ']', string2, set);
            if (wb2.a().booleanValue()) continue;
            return wb2;
        }
        return new wb<Boolean, String>(true, string);
    }

    @NotNull
    private static wb<Boolean, String> a(@Nullable Collection<?> collection, @Nullable Collection<?> collection2, @NotNull String string, @NotNull String string2, @NotNull Set<String> set) {
        if (collection == collection2) {
            return new wb<Boolean, String>(true, string);
        }
        if (collection == null || collection2 == null) {
            return new wb<Boolean, String>(false, string);
        }
        if (collection.size() != collection2.size()) {
            return new wb<Boolean, String>(false, string);
        }
        Iterator<?> iterator = collection.iterator();
        Iterator<?> iterator2 = collection2.iterator();
        while (iterator.hasNext()) {
            if (!iterator2.hasNext()) {
                return new wb<Boolean, String>(false, string);
            }
            wb<Boolean, String> wb2 = x.a(iterator.next(), iterator2.next(), string + "(?)", string2, set);
            if (wb2.a().booleanValue()) continue;
            return wb2;
        }
        return new wb<Boolean, String>(!iterator2.hasNext(), string);
    }

    public static String a(@Nullable Object object) throws IllegalAccessException {
        if (object == null) {
            return "null";
        }
        Class<?> clazz = object.getClass();
        if (x.a(clazz)) {
            return object.toString();
        }
        if (Collection.class.isAssignableFrom(clazz)) {
            return x.a((Collection)object);
        }
        if (object instanceof Object[]) {
            return x.a((Object[])object);
        }
        return x.b(object);
    }

    @NotNull
    private static String a(@NotNull Collection<?> collection) throws IllegalAccessException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('<');
        for (Object obj : collection) {
            if (stringBuffer.length() > 1) {
                stringBuffer.append(',');
            }
            stringBuffer.append(x.a(obj));
        }
        stringBuffer.append('>');
        return stringBuffer.toString();
    }

    @NotNull
    private static String a(@NotNull Object[] objectArray) throws IllegalAccessException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('[');
        for (Object object : objectArray) {
            if (stringBuffer.length() > 1) {
                stringBuffer.append(',');
            }
            stringBuffer.append(x.a(object));
        }
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    @NotNull
    private static String b(@NotNull Object object) throws IllegalAccessException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('{');
        for (Class<?> clazz = object.getClass(); clazz != null && !Object.class.equals(clazz); clazz = clazz.getSuperclass()) {
            Field[] fieldArray;
            for (Field field : fieldArray = clazz.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers())) continue;
                field.setAccessible(true);
                Object object2 = field.get(object);
                stringBuffer.append(field.getName()).append('=').append(x.a(object2)).append(';');
            }
        }
        stringBuffer.append("}\n");
        return stringBuffer.toString();
    }
}

