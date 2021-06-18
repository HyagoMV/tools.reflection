/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tools.reflection.j;

public final class i
implements j {
    @NotNull
    private Class<? extends Annotation> b;

    public i(@NotNull Class<? extends Annotation> clazz) {
        this.b = clazz;
    }

    @Override
    public boolean a(@Nullable Object object) {
        if (object == null) {
            return false;
        }
        return object.getClass().getAnnotation(this.b) != null;
    }

    @Override
    public boolean a(@NotNull Field field) {
        return field.getAnnotation(this.b) != null;
    }
}

