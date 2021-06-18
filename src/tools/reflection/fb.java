/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class fb {
    @NotNull
    private final Class<?> a;
    @Nullable
    private final Class<?> b;

    public fb(@Nullable Class<?> clazz, @NotNull Class<?> clazz2) {
        this.a = clazz2;
        this.b = clazz;
    }

    public fb(@NotNull fb fb2) {
        this.a = fb2.a;
        this.b = fb2.b;
    }

    @NotNull
    public String toString() {
        String string = this.b == null ? "unbounded" : this.b.getName();
        return '[' + string + ',' + this.a.getName() + ']';
    }

    @NotNull
    public fb a(@NotNull Class<?> clazz) {
        if (clazz.isAssignableFrom(this.a)) {
            return new fb(this);
        }
        return new fb(this.b, clazz);
    }

    @Nullable
    public Class<?> a() {
        return this.b;
    }

    @NotNull
    public Class<?> b() {
        return this.a;
    }

    @NotNull
    public fb b(@NotNull Class<?> clazz) {
        if (this.b == null) {
            return new fb(clazz, this.a);
        }
        if (this.b.isAssignableFrom(clazz)) {
            return new fb(this);
        }
        return new fb(clazz, this.a);
    }

    public boolean c(@NotNull Class<?> clazz) {
        boolean bl = this.b == null || clazz.isAssignableFrom(this.b);
        return this.a.isAssignableFrom(clazz) && bl;
    }

    public boolean c() {
        return this.b == null || this.a.isAssignableFrom(this.b);
    }
}

