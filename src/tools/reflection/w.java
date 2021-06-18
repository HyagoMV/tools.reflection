/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection;

import java.lang.reflect.Field;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class w {
    @NotNull
    private final Object a;
    @Nullable
    private final w b;
    @Nullable
    private final Field c;
    private final int d;

    public w(@NotNull Object object, @Nullable w w2, @Nullable Field field, int n2) {
        this.a = object;
        this.b = w2;
        this.c = field;
        this.d = n2;
    }

    public int a() {
        return this.d;
    }

    @Nullable
    public Field b() {
        return this.c;
    }

    @NotNull
    public Object c() {
        return this.a;
    }

    @Nullable
    public w d() {
        return this.b;
    }
}

