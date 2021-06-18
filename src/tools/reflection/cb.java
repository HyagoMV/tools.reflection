/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.apache.commons.lang.ArrayUtils
 *  org.apache.commons.lang.StringUtils
 */
package tools.reflection;

import asserts.Verify;
import gnu.trove.THashMap;
import gnu.trove.THashSet;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.TestOnly;
import sun.reflect.ReflectionFactory;
import tools.containers.hc;
import tools.containers.x;
import tools.wb;

public final class cb {
    @NotNull
    private static final Object a = new Object();
    @NotNull
    private static final ReflectionFactory b = ReflectionFactory.getReflectionFactory();
    @NotNull
    public static final Type[] c = new Type[0];

    @Nullable
    public static Field a(@NotNull Object object, @NotNull String string) throws b_ {
        return cb.a(object.getClass(), string);
    }

    @Nullable
    public static Field a(@NotNull Class<?> clazz, @NotNull String string) throws b_ {
        try {
            List<Class<?>> list = cb.a(clazz);
            Collections.reverse(list);
            for (Class<?> clazz2 : list) {
                for (Field field : clazz2.getDeclaredFields()) {
                    if (!field.getName().equals(string)) continue;
                    return field;
                }
            }
        }
        catch (SecurityException securityException) {
            throw new b_(securityException);
        }
        return null;
    }

    @Nullable
    public static Class<?> a(@Nullable Object object) {
        if (object == null) {
            return null;
        }
        return object.getClass();
    }

    @NotNull
    public static Constructor<?> a(@NotNull Class<?> clazz, Class<?> ... classArray) throws b_ {
        try {
            return clazz.getDeclaredConstructor(classArray);
        }
        catch (NoSuchMethodException | SecurityException exception) {
            throw new b_(exception);
        }
    }

    @NotNull
    public static List<Class<?>> b(@NotNull Object object) {
        return cb.a(object.getClass());
    }

    @NotNull
    public static List<Class<?>> a(@NotNull Class<?> clazz) {
        ArrayList arrayList = new ArrayList();
        Class<?> clazz2 = clazz;
        do {
            arrayList.add(clazz2);
        } while ((clazz2 = clazz2.getSuperclass()) != null);
        Collections.reverse(arrayList);
        return arrayList;
    }

    @NotNull
    public static Set<Class<?>> a(@NotNull Class<?> clazz, @NotNull Class<?> clazz2) {
        THashSet tHashSet = new THashSet();
        hc hc2 = hc.l(10);
        hc2.add(clazz);
        while (!hc2.isEmpty()) {
            Class clazz3 = (Class)hc2.remove(0);
            Collection<Class<?>> collection = cb.h(clazz3, clazz2);
            hc2.addAll(collection);
            tHashSet.addAll(collection);
        }
        return tHashSet;
    }

    @NotNull
    public static List<Class<?>> c(@NotNull Object object) {
        return cb.b(object.getClass());
    }

    @NotNull
    public static List<Class<?>> b(@NotNull Class<?> clazz) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(clazz);
        int n2 = 0;
        while (n2 < arrayList.size()) {
            Class clazz2 = (Class)arrayList.get(n2++);
            List<Class> list = Arrays.asList(clazz2.getInterfaces());
            for (Class<?> clazz3 : list) {
                if (arrayList.contains(clazz3)) continue;
                arrayList.add(clazz3);
            }
            Class clazz4 = clazz2.getSuperclass();
            if (clazz4 == null || arrayList.contains(clazz4)) continue;
            arrayList.add(clazz4);
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    @Nullable
    public static <T extends Annotation> wb<T, Class<?>> b(@NotNull Class<?> clazz, @NotNull Class<T> clazz2) {
        T t2 = clazz.getAnnotation(clazz2);
        if (t2 != null) {
            return new wb(t2, clazz);
        }
        List<Class<?>> list = cb.b(clazz);
        for (Class<?> clazz3 : list) {
            T t3 = clazz3.getAnnotation(clazz2);
            if (t3 == null) continue;
            return new wb(t3, clazz3);
        }
        return null;
    }

    @Nullable
    public static Method b(@NotNull Class<?> clazz, @NotNull String string) throws b_ {
        try {
            for (Method method : clazz.getMethods()) {
                if (!method.getName().equals(string)) continue;
                int n2 = method.getModifiers();
                if (!Modifier.isPublic(n2)) {
                    return null;
                }
                if (!Modifier.isStatic(n2)) {
                    return null;
                }
                if (!method.getReturnType().equals(clazz)) {
                    return null;
                }
                if (method.getParameterTypes().length != 0) {
                    return null;
                }
                return method;
            }
        }
        catch (SecurityException securityException) {
            throw new b_(securityException);
        }
        return null;
    }

    @Nullable
    public static Method a(@NotNull Class<?> clazz, @NotNull String string, Class<?> ... classArray) throws b_ {
        try {
            for (Method method : clazz.getMethods()) {
                int n2;
                if (!method.getName().equals(string) || !Modifier.isPublic(n2 = method.getModifiers()) || !Modifier.isStatic(n2) || !method.getReturnType().equals(clazz) || method.getParameterTypes().length != classArray.length) continue;
                boolean bl = true;
                for (int i2 = 0; i2 < method.getParameterTypes().length; ++i2) {
                    if (method.getParameterTypes()[i2].isAssignableFrom(classArray[i2])) continue;
                    bl = false;
                }
                if (!bl) continue;
                return method;
            }
        }
        catch (SecurityException securityException) {
            throw new b_(securityException);
        }
        return null;
    }

    @NotNull
    public static List<Field> d(@NotNull Object object) {
        return cb.c(object.getClass());
    }

    @NotNull
    public static List<Field> c(@NotNull Class<?> clazz) {
        ArrayList<Field> arrayList = new ArrayList<Field>();
        for (Class<?> clazz2 : cb.a(clazz)) {
            arrayList.addAll(Arrays.asList(clazz2.getDeclaredFields()));
        }
        return arrayList;
    }

    @Nullable
    public static Method c(@NotNull Class<?> clazz, @NotNull String string) throws b_ {
        try {
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isSynthetic() || !string.equals(method.getName()) || !clazz.equals(method.getDeclaringClass())) continue;
                return method;
            }
        }
        catch (SecurityException securityException) {
            throw new b_(securityException);
        }
        return null;
    }

    @Nullable
    public static Method d(@NotNull Class<?> clazz, @NotNull String string) throws b_ {
        try {
            for (Method method : clazz.getMethods()) {
                if (!string.equals(method.getName())) continue;
                return method;
            }
        }
        catch (SecurityException securityException) {
            throw new b_(securityException);
        }
        return null;
    }

    @Nullable
    public static Method e(@NotNull Class<?> clazz, @NotNull String string) throws b_ {
        try {
            List<Class<?>> list = cb.a(clazz);
            Collections.reverse(list);
            for (Class<?> clazz2 : list) {
                for (Method method : clazz2.getDeclaredMethods()) {
                    if (method.isSynthetic() || !string.equals(method.getName())) continue;
                    return method;
                }
            }
        }
        catch (SecurityException securityException) {
            throw new b_(securityException);
        }
        return null;
    }

    @Nullable
    public static Method a(@NotNull Class<?> clazz, @NotNull a_ a_2) throws b_ {
        try {
            List<Class<?>> list = cb.a(clazz);
            Collections.reverse(list);
            for (Class<?> clazz2 : list) {
                for (Method method : clazz2.getDeclaredMethods()) {
                    if (method.isSynthetic() || !a_2.a(method)) continue;
                    return method;
                }
            }
        }
        catch (SecurityException securityException) {
            throw new b_(securityException);
        }
        return null;
    }

    @Nullable
    public static Method b(@NotNull Class<?> clazz, @NotNull String string, @NotNull Class<?>[] classArray) throws b_ {
        try {
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isSynthetic() || !string.equals(method.getName()) || !clazz.equals(method.getDeclaringClass()) || !cb.a(method.getParameterTypes(), classArray)) continue;
                return method;
            }
        }
        catch (SecurityException securityException) {
            throw new b_(securityException);
        }
        return null;
    }

    @Nullable
    public static Method c(@NotNull Class<?> clazz, @NotNull String string, Class<?> ... classArray) throws b_ {
        try {
            for (Method method : clazz.getDeclaredMethods()) {
                Class<?>[] classArray2;
                if (method.isSynthetic() || !string.equals(method.getName()) || !clazz.equals(method.getDeclaringClass()) || (classArray2 = method.getParameterTypes()).length != classArray.length) continue;
                if (classArray2.length == 0) {
                    return method;
                }
                boolean bl = true;
                for (int i2 = 0; i2 < classArray2.length; ++i2) {
                    Class<?> clazz2 = classArray[i2];
                    if (clazz2.isAssignableFrom(classArray2[i2])) continue;
                    bl = false;
                    break;
                }
                if (!bl) continue;
                return method;
            }
        }
        catch (SecurityException securityException) {
            throw new b_(securityException);
        }
        return null;
    }

    @Nullable
    public static List<Method> d(@NotNull Class<?> clazz, @NotNull String string, Class<?> ... classArray) throws b_ {
        ArrayList<Method> arrayList = new ArrayList<Method>();
        try {
            for (Method method : clazz.getDeclaredMethods()) {
                Class<?>[] classArray2;
                if (method.isSynthetic() || !string.equals(method.getName()) || !clazz.equals(method.getDeclaringClass()) || (classArray2 = method.getParameterTypes()).length != classArray.length) continue;
                if (classArray2.length == 0) {
                    arrayList.add(method);
                    continue;
                }
                boolean bl = true;
                for (int i2 = 0; i2 < classArray2.length; ++i2) {
                    Class<?> clazz2 = classArray[i2];
                    if (clazz2.isAssignableFrom(classArray2[i2])) continue;
                    bl = false;
                    break;
                }
                if (!bl) continue;
                arrayList.add(method);
            }
        }
        catch (SecurityException securityException) {
            throw new b_(securityException);
        }
        return arrayList;
    }

    @Nullable
    public static Object a(@NotNull String string, @NotNull Object object) throws b_ {
        return cb.a(string, object, ArrayUtils.EMPTY_OBJECT_ARRAY);
    }

    @Nullable
    public static Object a(@NotNull String string, @NotNull Class<?> clazz) throws b_ {
        return cb.a(string, clazz, ArrayUtils.EMPTY_OBJECT_ARRAY);
    }

    @Nullable
    public static Object a(@NotNull String string, @NotNull Object object, @NotNull Object[] objectArray) throws b_ {
        Class<?> clazz = object.getClass();
        Class[] classArray = new Class[objectArray.length];
        int n2 = objectArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            classArray[i2] = objectArray[i2].getClass();
        }
        while (clazz != null && !clazz.equals(Object.class)) {
            Method method = cb.b(clazz, string, classArray);
            if (method != null) {
                return cb.a(method, object, objectArray);
            }
            clazz = clazz.getSuperclass();
        }
        throw new b_("Method \"" + string + "\" not found in " + object.getClass().getName());
    }

    @Nullable
    public static Object a(@NotNull Method method, @Nullable Object object, @NotNull Object[] objectArray) throws b_ {
        try {
            boolean bl = method.isAccessible();
            method.setAccessible(true);
            Object object2 = method.invoke(object, objectArray);
            if (!bl) {
                method.setAccessible(false);
            }
            return object2;
        }
        catch (ExceptionInInitializerError | IllegalAccessException | IllegalArgumentException | NullPointerException | SecurityException | InvocationTargetException throwable) {
            throw new b_(throwable);
        }
    }

    @Nullable
    public static Object a(@NotNull String string, @NotNull Class<?> clazz, @NotNull Object[] objectArray) throws b_ {
        Class[] classArray = new Class[objectArray.length];
        int n2 = objectArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            classArray[i2] = objectArray[i2] != null ? objectArray[i2].getClass() : null;
        }
        for (Class<?> clazz2 = clazz; clazz2 != null && !clazz2.equals(Object.class); clazz2 = clazz2.getSuperclass()) {
            Method method = cb.b(clazz2, string, classArray);
            if (method == null) continue;
            return cb.a(method, objectArray);
        }
        throw new b_("Method \"" + string + "\" not found in " + clazz.getName());
    }

    @Nullable
    public static Object a(@NotNull Method method, @NotNull Object[] objectArray) throws b_ {
        try {
            boolean bl = method.isAccessible();
            method.setAccessible(true);
            Object object = method.invoke(null, objectArray);
            if (!bl) {
                method.setAccessible(false);
            }
            return object;
        }
        catch (ExceptionInInitializerError | IllegalAccessException | IllegalArgumentException | NullPointerException | SecurityException | InvocationTargetException throwable) {
            throw new b_(throwable);
        }
    }

    @Nullable
    public static Object a(@Nullable Object object, @NotNull Field field) throws b_ {
        try {
            boolean bl = field.isAccessible();
            if (!bl) {
                field.setAccessible(true);
            }
            Object object2 = field.get(object);
            if (!bl) {
                field.setAccessible(false);
            }
            return object2;
        }
        catch (ExceptionInInitializerError | IllegalAccessException | IllegalArgumentException | NullPointerException | SecurityException throwable) {
            throw new b_(throwable);
        }
    }

    @Nullable
    public static Object b(@NotNull Object object, @NotNull String string) throws b_ {
        Object[] objectArray = StringUtils.split((String)string, (char)'.');
        if (ArrayUtils.isEmpty((Object[])objectArray)) {
            throw new b_("Unknown field names path: \"" + string + "\".");
        }
        Object object2 = object;
        for (Object object3 : objectArray) {
            Field field = cb.a(object2, (String)object3);
            if (field == null) {
                throw new b_("field \"" + (String)object3 + "\" not found in obj" + object2);
            }
            if ((object2 = cb.a(object2, field)) != null) continue;
            return null;
        }
        return object2;
    }

    @NotNull
    public static <T> T a(@NotNull Class<T> clazz, Object ... objectArray) throws b_ {
        if (clazz.isEnum()) {
            return clazz.getEnumConstants()[0];
        }
        try {
            Constructor<T> constructor = cb.b(clazz, objectArray);
            if (constructor != null) {
                if (!constructor.isAccessible()) {
                    constructor.setAccessible(true);
                }
                return constructor.newInstance(objectArray);
            }
            throw new b_(String.format("%s doesn't have constructor accepting %s", clazz, Arrays.toString(objectArray)));
        }
        catch (InstantiationException instantiationException) {
            throw new b_("exception while instantiating " + clazz, instantiationException);
        }
        catch (ExceptionInInitializerError | IllegalAccessException | IllegalArgumentException | SecurityException | InvocationTargetException throwable) {
            throw new b_(throwable);
        }
    }

    @NotNull
    public static Class<?> d(@NotNull Class<?> clazz) {
        ArrayDeque arrayDeque = new ArrayDeque(cb.a(clazz));
        while (!arrayDeque.isEmpty()) {
            Class clazz2 = (Class)arrayDeque.removeLast();
            try {
                Constructor constructor = clazz2.getDeclaredConstructor(new Class[0]);
                if (constructor == null) continue;
                return clazz2;
            }
            catch (NoSuchMethodException noSuchMethodException) {
            }
        }
        return Object.class;
    }

    @Nullable
    public static <T> Constructor<T> b(@NotNull Class<T> clazz, Object ... objectArray) throws b_ {
        try {
            Constructor<T> constructor = null;
            if (objectArray == null || objectArray.length == 0) {
                constructor = clazz.getDeclaredConstructor(new Class[0]);
            } else {
                Class[] classArray = cb.a(objectArray);
                for (Constructor constructor2 : clazz.getDeclaredConstructors()) {
                    Class<?>[] classArray2 = constructor2.getParameterTypes();
                    if (!cb.c(classArray2, classArray)) continue;
                    if (constructor == null) {
                        constructor = constructor2;
                        continue;
                    }
                    if (!cb.b(classArray2, constructor.getParameterTypes())) continue;
                    constructor = constructor2;
                }
            }
            return constructor;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new b_(noSuchMethodException);
        }
    }

    @Nullable
    public static <T> Constructor<T> b(@NotNull Class<T> clazz, Class<?> ... classArray) throws b_ {
        try {
            Constructor<T> constructor = null;
            if (classArray == null || classArray.length == 0) {
                constructor = clazz.getDeclaredConstructor(new Class[0]);
            } else {
                for (Constructor constructor2 : clazz.getDeclaredConstructors()) {
                    Class<?>[] classArray2 = constructor2.getParameterTypes();
                    if (!cb.c(classArray2, classArray)) continue;
                    if (constructor == null) {
                        constructor = constructor2;
                        continue;
                    }
                    if (!cb.b(classArray2, constructor.getParameterTypes())) continue;
                    constructor = constructor2;
                }
            }
            return constructor;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new b_(noSuchMethodException);
        }
    }

    @NotNull
    public static Class<?>[] a(@NotNull Object[] objectArray) {
        Class[] classArray = new Class[objectArray.length];
        for (int i2 = 0; i2 < classArray.length; ++i2) {
            classArray[i2] = objectArray[i2].getClass();
        }
        return classArray;
    }

    public static void a(@NotNull Object object, @NotNull Field field, @Nullable Object object2) throws b_ {
        try {
            boolean bl = field.isAccessible();
            if (!bl) {
                field.setAccessible(true);
            }
            field.set(object, object2);
            if (!bl) {
                field.setAccessible(false);
            }
        }
        catch (ExceptionInInitializerError | IllegalAccessException | IllegalArgumentException | NullPointerException | SecurityException throwable) {
            throw new b_(throwable);
        }
    }

    public static void a(@NotNull Class<?> clazz, @NotNull Object object, @NotNull String string, @Nullable Object object2) throws b_ {
        try {
            Field field = clazz.getDeclaredField(string);
            cb.a(object, field, object2);
        }
        catch (NoSuchFieldException | NullPointerException | SecurityException exception) {
            throw new b_(exception);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void a(@NotNull Class<?> clazz, @NotNull String string, @NotNull Object object) throws b_ {
        Object object2 = a;
        synchronized (object2) {
            try {
                Field field = clazz.getDeclaredField(string);
                boolean bl = field.isAccessible();
                if (!bl) {
                    field.setAccessible(true);
                }
                Field field2 = Field.class.getDeclaredField("modifiers");
                field2.setAccessible(true);
                field2.setInt(field, field.getModifiers() & 0xFFFFFFEF);
                field.set(null, object);
                field2.setInt(field, field.getModifiers() & 0x10);
                field2.setAccessible(false);
                if (!bl) {
                    field.setAccessible(false);
                }
            }
            catch (IllegalAccessException | NoSuchFieldException reflectiveOperationException) {
                throw new b_(reflectiveOperationException);
            }
        }
    }

    public static void a(@NotNull Object object, @NotNull String string, @Nullable Object object2) throws b_ {
        cb.a(object.getClass(), object, string, object2);
    }

    @NotNull
    public static <T> T e(@NotNull Class<T> clazz) throws b_ {
        return (T)cb.c(clazz, Object.class);
    }

    @NotNull
    public static <T> T c(@NotNull Class<T> clazz, @NotNull Class<? super T> clazz2) throws b_ {
        try {
            Constructor<? super T> constructor = clazz2.getDeclaredConstructor(new Class[0]);
            Constructor<?> constructor2 = b.newConstructorForSerialization(clazz, constructor);
            if (!constructor2.isAccessible()) {
                constructor2.setAccessible(true);
            }
            return clazz.cast(constructor2.newInstance(new Object[0]));
        }
        catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException reflectiveOperationException) {
            throw new b_("Cannot create object", reflectiveOperationException);
        }
    }

    @NotNull
    public static <T> T a(@NotNull Class<T> clazz, @NotNull Class<? super T> clazz2, Object ... objectArray) throws b_ {
        Constructor<? super T> constructor = cb.b(clazz2, objectArray);
        Constructor<?> constructor2 = b.newConstructorForSerialization(clazz, constructor);
        if (!constructor2.isAccessible()) {
            constructor2.setAccessible(true);
        }
        return clazz.cast(cb.a(constructor2, objectArray));
    }

    @NotNull
    public static <T> T f(@NotNull Class<T> clazz) throws b_ {
        Class clazz2 = cb.d(clazz);
        return (T) cb.c(clazz, clazz2);
    }

    @NotNull
    public static <T> T a(@NotNull Constructor<T> constructor, Object ... objectArray) throws b_ {
        try {
            return constructor.newInstance(objectArray);
        }
        catch (ExceptionInInitializerError | IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException throwable) {
            throw new b_(throwable);
        }
    }

    @NotNull
    public static String g(@NotNull Class<?> clazz) {
        String string = clazz.getName();
        int n2 = string.lastIndexOf(46);
        return n2 < 0 ? string : string.substring(n2 + 1);
    }

    public static boolean d(@NotNull Class<?> clazz, @NotNull Class<?> clazz2) {
        Class<?>[] classArray;
        for (Class<?> clazz3 : classArray = clazz.getInterfaces()) {
            if (!clazz2.equals(clazz3)) continue;
            return true;
        }
        return false;
    }

    public static boolean e(@NotNull Class<?> clazz, @NotNull Class<?> clazz2) {
        List<Class<?>> list = cb.b(clazz);
        for (Class<?> clazz3 : list) {
            if (!clazz2.equals(clazz3)) continue;
            return true;
        }
        return false;
    }

    public static boolean f(@NotNull Class<?> clazz, @NotNull Class<?> clazz2) {
        List<Class<?>> list = cb.a(clazz);
        for (Class<?> clazz3 : list) {
            if (!clazz2.equals(clazz3)) continue;
            return true;
        }
        return false;
    }

    @Nullable
    @TestOnly
    public static <T> T c(@NotNull Object object, @NotNull String string) {
        try {
            return (T)cb.a(object, string.split("\\."));
        }
        catch (b_ b_2) {
            throw new Error(b_2);
        }
    }

    @NotNull
    @TestOnly
    public static <T> T d(@NotNull Object object, @NotNull String string) {
        T t2 = cb.c(object, string);
        if (t2 == null) {
            throw new NullPointerException(string + " is null in " + object);
        }
        return t2;
    }

    @Nullable
    public static <T> T a(@NotNull Class<?> clazz, @Nullable Object object, @NotNull String string) throws NoSuchFieldException, IllegalAccessException {
        Field field = clazz.getDeclaredField(string);
        boolean bl = field.isAccessible();
        field.setAccessible(true);
        Object object2 = field.get(object);
        field.setAccessible(bl);
        return (T)object2;
    }

    @Nullable
    public static Object a(@Nullable Object object, @NotNull String[] stringArray) throws b_ {
        Object object2 = object;
        for (String string : stringArray) {
            if (object2 instanceof Object[]) {
                if ((object2 = cb.e(object2, string)) != null) continue;
                return null;
            }
            if (object2 instanceof Map) {
                if ((object2 = cb.f(object2, string)) != null) continue;
                return null;
            }
            if (object2 instanceof Collection) {
                if ((object2 = cb.g(object2, string)) != null) continue;
                return null;
            }
            if (object2 == null) {
                return null;
            }
            Field field = cb.a(object2, string);
            if (field == null) {
                return null;
            }
            try {
                field.setAccessible(true);
                object2 = field.get(object2);
            }
            catch (ExceptionInInitializerError | IllegalAccessException | IllegalArgumentException | NullPointerException | SecurityException throwable) {
                throw new b_(throwable);
            }
        }
        return object2;
    }

    public static void a(@NotNull Object object, @NotNull Object object2) throws b_ {
        if (object instanceof Object[]) {
            cb.a((Object[])object, (Object[])object2);
        } else {
            if (!object.getClass().equals(object2.getClass())) {
                throw new b_("Wrong class, expected " + object.getClass().getName() + ", but actual " + object2.getClass().getName());
            }
            if (!object.equals(object2)) {
                Class<?> clazz = object.getClass();
                while (!clazz.equals(Object.class)) {
                    Field[] fieldArray;
                    for (Field field : fieldArray = clazz.getDeclaredFields()) {
                        cb.a(object, object2, field);
                    }
                    clazz = clazz.getSuperclass();
                }
            }
        }
    }

    public static void a(@NotNull Object[] objectArray, @NotNull Object[] objectArray2) throws b_ {
        if (objectArray.length != objectArray2.length) {
            throw new b_("equal lentgh expected, found " + objectArray.length + " ," + objectArray2.length);
        }
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            if (objectArray[i2] == null || objectArray2[i2] == null) {
                if (objectArray[i2] == null && objectArray2[i2] == null) continue;
                throw new b_("Wrong value in array item " + i2 + ": " + objectArray[i2] + "!=" + objectArray2[i2]);
            }
            if (objectArray[i2] instanceof Object[]) {
                cb.a((Object[])objectArray[i2], (Object[])objectArray2[i2]);
                continue;
            }
            cb.a(objectArray[i2], objectArray2[i2]);
        }
    }

    @NotNull
    public static Map<String, Object> e(@NotNull Object object) throws b_ {
        THashMap<String, Object> tHashMap = new THashMap<String, Object>();
        for (Field field : cb.d(object)) {
            Object object2 = cb.a(object, field);
            tHashMap.put(field.getName(), object2);
        }
        return tHashMap;
    }

    public static void a(@NotNull Field field, @Nullable Object object, @NotNull String string) throws b_ {
        Class<?> clazz = field.getType();
        if (!clazz.isPrimitive()) {
            throw new b_("can't set non primitive type " + clazz);
        }
        try {
            field.setAccessible(true);
            if (clazz.equals(Boolean.TYPE)) {
                field.setBoolean(object, Boolean.parseBoolean(string));
            } else if (clazz.equals(Byte.TYPE)) {
                field.setByte(object, Byte.parseByte(string));
            } else if (clazz.equals(Double.TYPE)) {
                field.setDouble(object, Double.parseDouble(string));
            } else if (clazz.equals(Float.TYPE)) {
                field.setFloat(object, Float.parseFloat(string));
            } else if (clazz.equals(Integer.TYPE)) {
                field.setInt(object, Integer.parseInt(string));
            } else if (clazz.equals(Long.TYPE)) {
                field.setLong(object, Long.parseLong(string));
            } else if (clazz.equals(Short.TYPE)) {
                field.setShort(object, Short.parseShort(string));
            }
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new b_(illegalAccessException);
        }
    }

    @NotNull
    public static <T> T a(@NotNull String string, Object ... objectArray) throws ClassNotFoundException, b_ {
        return (T)cb.a(Class.forName(string), objectArray);
    }

    @NotNull
    public static Class<?> h(@NotNull Class<?> clazz) {
        if (!clazz.isPrimitive()) {
            return clazz;
        }
        if (Integer.TYPE.equals(clazz)) {
            return Integer.class;
        }
        if (Short.TYPE.equals(clazz)) {
            return Short.class;
        }
        if (Double.TYPE.equals(clazz)) {
            return Double.class;
        }
        if (Float.TYPE.equals(clazz)) {
            return Float.class;
        }
        if (Long.TYPE.equals(clazz)) {
            return Long.class;
        }
        if (Character.TYPE.equals(clazz)) {
            return Character.class;
        }
        if (Byte.TYPE.equals(clazz)) {
            return Byte.class;
        }
        if (Boolean.TYPE.equals(clazz)) {
            return Boolean.class;
        }
        Verify.fail("can't determine primitive type");
        return clazz;
    }

    @NotNull
    public static <G> Type[] g(@NotNull Class<? extends G> clazz, @NotNull Class<G> clazz2) {
        if (!Modifier.isInterface(clazz2.getModifiers())) {
            throw new IllegalArgumentException('\'' + clazz2.getName() + "' is not interface type.");
        }
        if (clazz2.getTypeParameters().length == 0) {
            throw new IllegalArgumentException('\'' + clazz2.getName() + "' is not generic type.");
        }
        ParameterizedType parameterizedType = cb.i(clazz, clazz2);
        if (parameterizedType == null) {
            Verify.fail("Generic interface '" + clazz2.getName() + "' not found.");
            return c;
        }
        return parameterizedType.getActualTypeArguments();
    }

    private cb() {
    }

    @NotNull
    private static Collection<Class<?>> h(@NotNull Class<?> clazz, @NotNull Class<?> clazz2) {
        Class<?> clazz3 = clazz.getSuperclass();
        Class<?>[] classArray = clazz.getInterfaces();
        ArrayList arrayList = new ArrayList(classArray.length + 1);
        if (clazz3 != null && clazz2.isAssignableFrom(clazz)) {
            arrayList.add(clazz3);
        }
        for (Class<?> clazz4 : classArray) {
            if (!clazz2.isAssignableFrom(clazz4) || clazz2.equals(clazz)) continue;
            arrayList.add(clazz4);
        }
        return arrayList;
    }

    private static boolean a(@NotNull Class<?>[] classArray, @NotNull Class<?>[] classArray2) {
        if (classArray.length != classArray2.length) {
            return false;
        }
        for (int i2 = 0; i2 < classArray.length; ++i2) {
            if (classArray2[i2] == null || classArray[i2].isAssignableFrom(classArray2[i2])) continue;
            return false;
        }
        return true;
    }

    private static boolean b(@NotNull Class<?>[] classArray, @NotNull Class<?>[] classArray2) {
        if (classArray.length == classArray2.length) {
            for (int i2 = 0; i2 < classArray.length; ++i2) {
                if (classArray2[i2].isAssignableFrom(classArray[i2])) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    private static boolean c(@NotNull Class<?>[] classArray, @NotNull Class<?>[] classArray2) {
        if (classArray.length == classArray2.length) {
            for (int i2 = 0; i2 < classArray.length; ++i2) {
                Class<?> clazz;
                Class<?> clazz2 = cb.h(classArray[i2]);
                if (clazz2.isAssignableFrom(clazz = cb.h(classArray2[i2]))) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    @Nullable
    private static Object e(@NotNull Object object, @NotNull String string) throws b_ {
        if (object instanceof Object[]) {
            Object[] objectArray = (Object[])object;
            try {
                int n2 = Integer.decode(string);
                if (n2 < 0 || n2 >= objectArray.length) {
                    return null;
                }
                return objectArray[n2];
            }
            catch (NumberFormatException numberFormatException) {
                throw new b_(numberFormatException);
            }
        }
        return null;
    }

    @Nullable
    private static Object f(@NotNull Object object, @NotNull String string) {
        if (object instanceof Map) {
            Map map = (Map)object;
            try {
                int n2 = Integer.decode(string);
                if (n2 < 0 || n2 >= map.size()) {
                    return null;
                }
                Object var4_5 = null;
                for (Object k2 : map.keySet()) {
                    if (n2 == 0) {
                        var4_5 = k2;
                        break;
                    }
                    --n2;
                }
                if (var4_5 != null) {
                    return map.get(var4_5);
                }
                return null;
            }
            catch (NumberFormatException numberFormatException) {
                for (Object o : map.entrySet()) {
                	Map.Entry entry = (Map.Entry) o;
                    if (!entry.getKey().toString().contains(string)) continue;
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    @Nullable
    private static Object g(@NotNull Object object, @NotNull String string) throws b_ {
        if (object instanceof Collection) {
            Collection collection = (Collection)object;
            try {
                int n2 = Integer.decode(string);
                if (n2 < 0 || n2 >= collection.size()) {
                    return null;
                }
                return x.a(collection, n2);
            }
            catch (NumberFormatException numberFormatException) {
                throw new b_(numberFormatException);
            }
        }
        return null;
    }

    private static void a(@NotNull Object object, @NotNull Object object2, @NotNull Field field) throws b_ {
        try {
            field.setAccessible(true);
            Object object3 = field.get(object);
            Object object4 = field.get(object2);
            if (object3 == null || object4 == null) {
                if (object3 != null || object4 != null) {
                    throw new b_("Wrong value in class " + object2.getClass() + " in field " + field.getName() + ": " + object3 + "!=" + object4);
                }
                return;
            }
            if (object3 != object4) {
                if (object3 instanceof Object[]) {
                    cb.a((Object[])object3, (Object[])object4);
                } else if (object3 instanceof long[]) {
                    if (!ArrayUtils.isEquals((Object)object3, (Object)object4)) {
                        throw new b_("Wrong value in class " + object2.getClass() + " in field " + field.getName() + ": " + ArrayUtils.toString((Object)object3) + "!=" + ArrayUtils.toString((Object)object4));
                    }
                } else if (!object3.equals(object4)) {
                    throw new b_("Wrong value in class " + object2.getClass() + " in field " + field.getName() + ": " + object3 + "!=" + object4);
                }
            }
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new b_(illegalAccessException);
        }
    }

    @Nullable
    private static ParameterizedType i(@NotNull Class<?> clazz, @NotNull Class<?> clazz2) {
        Type[] typeArray;
        for (Type type : typeArray = clazz.getGenericInterfaces()) {
            ParameterizedType parameterizedType;
            if (type instanceof Class) {
                parameterizedType = cb.i((Class)type, clazz2);
                if (parameterizedType == null) continue;
                return parameterizedType;
            }
            if (type instanceof ParameterizedType) {
                parameterizedType = (ParameterizedType)type;
                if (parameterizedType.getRawType().equals(clazz2)) {
                    return parameterizedType;
                }
                ParameterizedType parameterizedType2 = cb.i((Class)parameterizedType.getRawType(), clazz2);
                if (parameterizedType2 == null) continue;
                return parameterizedType;
            }
            Verify.fail("Unexpected type class '" + type.getClass() + "'.");
        }
        return null;
    }

    public static interface a_ {
        public boolean a(@NotNull Method var1);
    }

    public static class b_
    extends Exception {
        public b_(@Nullable Throwable throwable) {
            super(throwable);
        }

        public b_(@Nullable String string) {
            super(string);
        }

        public b_(@Nullable String string, @Nullable Throwable throwable) {
            super(string, throwable);
        }
    }
}

