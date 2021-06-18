/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection.objectsFactory;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class a
extends ClassLoader {
    public a(@Nullable ClassLoader classLoader) {
        super(classLoader);
    }

    @NotNull
    public Class<?> a(@NotNull String string, @NotNull byte[] byArray) {
        return this.defineClass(string, byArray, 0, byArray.length);
    }

    @NotNull
    public static Class<?> a(@NotNull ClassLoader classLoader, @NotNull String string, @NotNull byte[] byArray) {
        return new a(classLoader).a(string, byArray);
    }
}

