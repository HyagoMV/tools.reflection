/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection;

import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import tools.reflection.j;

public final class m {
    @NotNull
    public static final m a = new m();
    @NotNull
    private List<j> b = new ArrayList<j>();
    private boolean c;

    @NotNull
    public m a(@NotNull j j2) {
        this.b.add(j2);
        return this;
    }

    @NotNull
    public m a() {
        this.c = true;
        return this;
    }

    public boolean b() {
        return this.c;
    }

    @NotNull
    public List<j> c() {
        return this.b;
    }
}

