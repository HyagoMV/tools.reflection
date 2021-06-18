/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection.classLoading;

import gnu.trove.THashSet;
import gnu.trove.TObjectIntHashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import tools.reflection.classLoading.h;
import tools.reflection.classLoading.k;
import tools.reflection.classLoading.o;
import tools.reflection.classLoading.q;

public final class j
extends h {
    @NotNull
    private final List<Class<?>> f = new ArrayList();
    @NotNull
    private List<Class<?>> g = new ArrayList();
    @NotNull
    private Set<Integer> h = new THashSet<Integer>();
    private int i = 1;
    private int j;
    @NotNull
    private final TObjectIntHashMap<Class<?>> k = new TObjectIntHashMap();
    @NotNull
    private final TObjectIntHashMap<Class<?>> l = new TObjectIntHashMap();

    public j() {
    }

    j(@NotNull Iterable<Class<?>> iterable, o ... oArray) {
        this.a(iterable);
        tools.reflection.classLoading.k.a(this, oArray);
    }

    @Override
    @NotNull
    public Class<?> a(int n2) {
        if (!this.b(n2)) {
            return h.a_.class;
        }
        return this.f.get(n2);
    }

    @Override
    public int a(@NotNull Class<?> clazz) {
        int n2 = this.k.get(clazz);
        if (n2 == 0) {
            return this.d(clazz);
        }
        return n2;
    }

    @Override
    @NotNull
    public synchronized Iterable<Class<?>> f() {
        if (this.j != this.i) {
            this.j = this.i;
            this.g = new ArrayList(this.f.size());
            this.g.add(h.a_.class);
            for (Class<?> clazz : this.f) {
                if (clazz.equals(h.a_.class)) continue;
                this.g.add(clazz);
            }
        }
        return Collections.unmodifiableCollection(this.g);
    }

    @Override
    public synchronized int g() {
        return this.f.size();
    }

    @Override
    public synchronized boolean h() {
        return this.j != this.i;
    }

    @Override
    public boolean b(int n2) {
        return 0 < n2 && n2 < this.f.size() && !this.h.contains(n2);
    }

    @Override
    protected synchronized boolean b(@NotNull Class<?> clazz) {
        boolean bl;
        boolean bl2 = bl = !this.k.containsKey(clazz);
        if (bl) {
            int n2;
            ++this.i;
            if (!this.h.isEmpty()) {
                n2 = this.h.iterator().next();
                this.f.set(n2, clazz);
                this.h.remove(n2);
            } else {
                n2 = this.f.size();
                this.f.add(clazz);
            }
            this.k.put(clazz, n2);
        }
        return bl;
    }

    @Override
    protected synchronized boolean c(@NotNull Class<?> clazz) {
        Integer n2 = this.k.get(clazz);
        if (n2 != null) {
            ++this.i;
            this.k.remove(clazz);
            this.f.set(n2, h.a_.class);
            this.h.add(n2);
            return true;
        }
        return false;
    }

    private int d(@NotNull Class<?> clazz) {
        if (this.l.contains(clazz)) {
            return this.l.get(clazz);
        }
        Class<?> clazz2 = clazz;
        do {
            if (!clazz2.isAnnotationPresent(q.class)) continue;
            int n2 = this.k.get(clazz2);
            this.l.put(clazz, n2);
            return n2;
        } while ((clazz2 = clazz2.getSuperclass()) != null && !clazz2.equals(Object.class));
        this.l.put(clazz, 0);
        return 0;
    }
}

