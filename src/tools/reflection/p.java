/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class p {
    private p() {
    }

    @NotNull
    public static a_ a(@NotNull Type type) {
        if (type instanceof ParameterizedType) {
            return a_.Parameterized;
        }
        if (type instanceof WildcardType) {
            return a_.Wildcard;
        }
        if (type instanceof TypeVariable) {
            return a_.TypeVariable;
        }
        if (type instanceof GenericArrayType) {
            return a_.GenericArray;
        }
        if (type instanceof Class) {
            return a_.Plain;
        }
        throw new IllegalArgumentException("Unknown type " + type);
    }

    @Nullable
    public static ParameterizedType a(@NotNull Class<?> clazz) {
        Type type = clazz.getGenericSuperclass();
        if (type != null && p.a(type) == a_.Parameterized) {
            return (ParameterizedType)type;
        }
        return null;
    }

    @NotNull
    public static List<ParameterizedType> b(@NotNull Class<?> clazz) {
        Type[] typeArray;
        ArrayList<ParameterizedType> arrayList = new ArrayList<ParameterizedType>();
        for (Type type : typeArray = clazz.getGenericInterfaces()) {
            if (p.a(type) != a_.Parameterized) continue;
            arrayList.add((ParameterizedType)type);
        }
        return arrayList;
    }

    @NotNull
    public static List<ParameterizedType> c(@NotNull Class<?> clazz) {
        List<ParameterizedType> list = p.b(clazz);
        ParameterizedType parameterizedType = p.a(clazz);
        if (parameterizedType != null) {
            list.add(parameterizedType);
        }
        return list;
    }

    @Nullable
    public static ParameterizedType b(@NotNull Type type) {
        if (p.a(type) == a_.Parameterized) {
            return (ParameterizedType)type;
        }
        return null;
    }

    public static enum a_ {
        Plain,
        Parameterized,
        TypeVariable,
        Wildcard,
        GenericArray;

    }
}

