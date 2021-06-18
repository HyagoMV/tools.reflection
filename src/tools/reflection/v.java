/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection;

import gnu.trove.TObjectLongHashMap;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import tools.reflection.cb;
import tools.reflection.u;

public final class v
implements u {
    @NotNull
    private static final TObjectLongHashMap<Class<?>> a = new TObjectLongHashMap();
    private final long b;
    private final long c;

    @NotNull
    public static u a() {
        return new v(8L, 4L);
    }

    @NotNull
    public static u b() {
        return new v(16L, 8L);
    }

    public v(long l2, long l3) {
        this.b = l2;
        this.c = l3;
    }

    @Override
    public long a(@NotNull Object object) {
        List<Field> list = cb.d(object);
        long l2 = this.b;
        if (object.getClass().isArray()) {
            Class<?> clazz = object.getClass().getComponentType();
            l2 += a.get(Integer.TYPE) + (long)Array.getLength(object) * (clazz.isPrimitive() ? a.get(clazz) : this.c);
        }
        for (Field field : list) {
            if (Modifier.isStatic(field.getModifiers())) continue;
            if (field.getType().isPrimitive()) {
                l2 += a.get(field.getType());
                continue;
            }
            l2 += this.c;
        }
        return l2;
    }

    static {
        a.put(Integer.TYPE, 4L);
        a.put(Long.TYPE, 8L);
        a.put(Short.TYPE, 2L);
        a.put(Byte.TYPE, 1L);
        a.put(Character.TYPE, 2L);
        a.put(Float.TYPE, 4L);
        a.put(Double.TYPE, 8L);
        a.put(Boolean.TYPE, 1L);
    }
}

