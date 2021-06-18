/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection.objectsFactory;

import org.jetbrains.annotations.NotNull;

public class ab
extends RuntimeException {
    public ab(@NotNull String string) {
        super(string);
    }

    public ab(@NotNull String string, @NotNull Throwable throwable) {
        super(string, throwable);
    }

    public ab(@NotNull Throwable throwable) {
        super(throwable);
    }
}

