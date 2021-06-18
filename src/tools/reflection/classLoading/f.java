/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection.classLoading;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import tools.containers.y;
import tools.reflection.classLoading.e;
import tools.reflection.classLoading.g;

public final class f {
    @NotNull
    private e a;
    @NotNull
    private Map<Class<?>, Annotation> b = y.b();
    @NotNull
    private Collection<g.a_> c = new ArrayList<g.a_>();

    public f(@NotNull e e2, @NotNull Map<Class<?>, Annotation> map) {
        this.a = e2;
        this.b = map;
    }

    public void a(@NotNull Class<?> clazz) {
        Annotation annotation = this.a.b() == null ? null : clazz.getAnnotation(this.a.b());
        this.b.put(clazz, annotation);
        for (g.a_ a_2 : this.c) {
            a_2.found(clazz, annotation);
        }
    }

    public boolean a(@NotNull g.a_ a_2) {
        if (!this.c.contains(a_2)) {
            this.c.add(a_2);
            return true;
        }
        return false;
    }

    @NotNull
    public Map<Class<?>, Annotation> a() {
        return y.a(this.b);
    }
}

