/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection;

import org.jetbrains.annotations.NotNull;

public class b
extends Exception {
    public b() {
    }

    public b(@NotNull String string) {
        super(string);
    }

    public b(@NotNull String string, @NotNull Throwable throwable) {
        super(string, throwable);
    }

    public b(@NotNull Throwable throwable) {
        super(throwable);
    }
}

