/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection.objectsFactory;

import java.lang.reflect.Field;
import org.jetbrains.annotations.NotNull;
import system.c;

@c
public final class e {
    public static short a(@NotNull Class<?> clazz, @NotNull StringBuilder stringBuilder) {
        try {
            Field[] fieldArray;
            for (Field field : fieldArray = clazz.getDeclaredFields()) {
                if (!field.getName().equals("SERIALIZATION_ID")) continue;
                boolean bl = field.isAccessible();
                if (!bl) {
                    field.setAccessible(true);
                }
                short s2 = field.getShort(null);
                if (!bl) {
                    field.setAccessible(false);
                }
                return s2;
            }
        }
        catch (ExceptionInInitializerError | IllegalAccessException | IllegalArgumentException | SecurityException throwable) {
            stringBuilder.append(clazz).append(' ').append(throwable.toString()).append('\n');
        }
        return -1;
    }

    private e() {
    }
}

