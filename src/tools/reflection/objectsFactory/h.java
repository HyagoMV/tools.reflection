/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection.objectsFactory;

import java.lang.annotation.Annotation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tools.reflection.objectsFactory.ObjectsConstructor;
import tools.reflection.objectsFactory.g;

public final class h<T, E extends Annotation>
extends g<T> {
    @NotNull
    public static <T, E extends Annotation> h<T, E> b(@NotNull Class<T> clazz, @Nullable Class<E> clazz2) {
        return new h<T, E>(clazz, clazz2);
    }

    private h(@NotNull Class<T> clazz, @Nullable Class<E> clazz2, @NotNull a_<T, E> a_2, @NotNull ObjectsConstructor.d_<T> d_2) {
        super(clazz, clazz2, a_2, d_2);
    }

    private h(@NotNull Class<T> clazz, @Nullable Class<E> clazz2, @NotNull a_<T, E> a_2) {
        this(clazz, clazz2, a_2, (ObjectsConstructor.d_<T>)new b_<T>(a_2));
    }

    private h(@NotNull Class<T> clazz, @Nullable Class<E> clazz2) {
        this(clazz, clazz2, new a_());
    }

    public static final class c_<T>
    extends g.d_<T> {
        public c_(@NotNull Class<? extends T> clazz) {
            super(clazz);
        }
    }

    public static final class a_<T, E extends Annotation>
    extends g.b_<T, E> {
        @NotNull
        public c_<T> b(@NotNull Class<? extends T> clazz) {
            return new c_<T>(clazz);
        }
    }

    public static final class b_<T>
    extends g.c_<T> {
        public b_(@NotNull g.b_<T, ?> b_2) {
            super(b_2);
        }
    }
}

