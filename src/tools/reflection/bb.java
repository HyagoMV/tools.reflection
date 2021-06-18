/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection;

import asserts.Verify;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tools.reflection.cb;

public final class bb {
    @NotNull
    private final Object a;
    @Nullable
    private final bb b;

    @Nullable
    private static Field a(@NotNull Object object, @NotNull Object object2) {
        List<Class<?>> list = cb.b(object);
        for (Class<?> clazz : list) {
            for (Field field : clazz.getDeclaredFields()) {
                try {
                    if (object2 != cb.a(object, field)) continue;
                    return field;
                }
                catch (cb.b_ b_2) {
                    Verify.fail("exception getting value of field " + field + " for obj " + object, b_2);
                }
            }
        }
        return null;
    }

    public bb(@NotNull Object object, @Nullable bb bb2) {
        this.a = object;
        this.b = bb2;
    }

    @NotNull
    public String a() {
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        bb bb2 = this.b;
        bb bb3 = this;
        while (bb2 != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("\n\t").append('.').append(bb.b(bb2.a, bb3.a)).append('(').append(bb3.a.getClass().getName()).append(')');
            stringBuilder2 = stringBuilder.append((CharSequence)stringBuilder2);
            bb3 = bb2;
            bb2 = bb2.b;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("<locale>(").append(bb3.b().getClass().getName()).append(')');
        return stringBuilder.append((CharSequence)stringBuilder2).toString();
    }

    @NotNull
    public Object b() {
        return this.a;
    }

    @Nullable
    public bb c() {
        return this.b;
    }

    @NotNull
    static String b(@NotNull Object object, @NotNull Object object2) {
        Field field;
        if (object.getClass().getComponentType() != null) {
            int n2 = Array.getLength(object);
            for (int i2 = 0; i2 < n2; ++i2) {
                Object object3 = Array.get(object, i2);
                if (object2 != object3) continue;
                return "[" + i2 + ']';
            }
        }
        if ((field = bb.a(object, object2)) == null) {
            return "nofield";
        }
        return field.getName();
    }
}

