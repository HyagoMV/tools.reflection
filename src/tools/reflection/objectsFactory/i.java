/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection.objectsFactory;

import org.jetbrains.annotations.NotNull;

public abstract class i {
    @NotNull
    public static String a(@NotNull Class<?> clazz) {
        return clazz.getName().replaceAll("\\.", "/");
    }

    @NotNull
    public static String b(@NotNull Class<?> clazz) {
        return 'L' + i.a(clazz) + ';';
    }

    public static final class a_
    extends RuntimeException {
        public a_() {
        }

        public a_(@NotNull String string) {
            super(string);
        }

        public a_(@NotNull String string, @NotNull Throwable throwable) {
            super(string, throwable);
        }

        public a_(@NotNull Throwable throwable) {
            super(throwable);
        }
    }
}

