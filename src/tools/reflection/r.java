/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection;

import gnu.trove.TShortObjectHashMap;
import gnu.trove.TShortObjectProcedure;
import java.lang.annotation.Annotation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import system.c;
import tools.reflection.classLoading.g;
import tools.reflection.objectsFactory.e;

@c
public final class r<T, E extends Annotation> {
    @NotNull
    private final TShortObjectHashMap<Class<? extends T>> a = new TShortObjectHashMap();

    public r(@NotNull Class<T> clazz, @Nullable Class<E> clazz2, boolean bl) {
        final StringBuilder stringBuilder = new StringBuilder();
        g.a(clazz, clazz2, bl, new g.a_<T, E>(){

            @Override
            public void found(@NotNull Class<? extends T> clazz, @Nullable E e2) {
                r.this.a(clazz, stringBuilder);
            }
        });
        if (stringBuilder.length() != 0) {
            throw new RuntimeException(stringBuilder.toString());
        }
    }

    public void a(@NotNull TShortObjectProcedure<Class<? extends T>> tShortObjectProcedure) {
        this.a.forEachEntry(tShortObjectProcedure);
    }

    @Nullable
    public Class<? extends T> a(short s2) {
        return this.a.get(s2);
    }

    public void a(@NotNull Class<? extends T> clazz, @NotNull StringBuilder stringBuilder) {
        short s2 = e.a(clazz, stringBuilder);
        if (s2 != -1) {
            Class<? extends T> clazz2 = this.a.get(s2);
            if (clazz2 != null) {
                stringBuilder.append("equal guids (").append(s2).append("): ").append(clazz2).append(", ").append(clazz).append('\n');
            } else {
                this.a.put(s2, clazz);
            }
        }
    }

    public boolean b(@NotNull Class<? extends T> clazz, @NotNull StringBuilder stringBuilder) {
        short s2 = e.a(clazz, stringBuilder);
        if (s2 != -1 && this.a(s2) == null) {
            this.a(clazz, stringBuilder);
            return this.a(s2) != null;
        }
        return false;
    }

    public boolean a() {
        return this.a.isEmpty();
    }
}

