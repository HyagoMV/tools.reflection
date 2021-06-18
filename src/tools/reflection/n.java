/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class n {
    @NotNull
    public static <T extends Enum<T>> T a(@Nullable String string, @NotNull T t2) {
        if (string == null) {
            return t2;
        }
        try {
            return Enum.valueOf(t2.getDeclaringClass(), string);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return t2;
        }
    }

    private n() {
    }
}

