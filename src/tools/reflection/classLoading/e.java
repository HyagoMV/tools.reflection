/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.apache.commons.lang.ObjectUtils
 */
package tools.reflection.classLoading;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import org.apache.commons.lang.ObjectUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class e {
    @NotNull
    private final Class<?> a;
    @Nullable
    private final Class<? extends Annotation> b;
    private final boolean c;
    private final int d;

    e(@NotNull Class<?> clazz, @Nullable Class<? extends Annotation> clazz2, boolean bl) {
        this.b = clazz2;
        this.a = clazz;
        this.c = bl;
        int n2 = clazz.hashCode();
        n2 = 31 * n2 + (clazz2 != null ? clazz2.hashCode() : 0);
        this.d = n2 = 31 * n2 + (bl ? 1 : 0);
    }

    public boolean equals(@Nullable Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        e e2 = (e)object;
        return this.c == e2.c && ObjectUtils.equals(this.b, e2.b) && this.a.equals(e2.a);
    }

    public boolean a(@NotNull Class<?> clazz) {
        if (this.c && (Modifier.isAbstract(clazz.getModifiers()) || Modifier.isInterface(clazz.getModifiers()))) {
            return false;
        }
        boolean bl = this.b != null && clazz.isAnnotationPresent(this.b);
        boolean bl2 = this.b == null || bl;
        return bl2 && this.a.isAssignableFrom(clazz);
    }

    @NotNull
    public Class<?> a() {
        return this.a;
    }

    @Nullable
    public Class<? extends Annotation> b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }

    public int hashCode() {
        return this.d;
    }

    public String toString() {
        return "CacheKey{baseClass=" + this.a + ", annotation=" + this.b + ", onlyInstances=" + this.c + '}';
    }
}

