/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection;

import java.lang.reflect.Field;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tools.reflection.j;

public final class k<T>
implements j {
    @NotNull
    private Class<T> b;

    public k(@NotNull Class<T> clazz) {
        this.b = clazz;
    }

    @Override
    public boolean a(@Nullable Object object) {
        if (object == null) {
            return false;
        }
        return object.getClass().equals(this.b);
    }

    @Override
    public boolean a(@NotNull Field field) {
        return false;
    }
}

