/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection.classLoading;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.NotNull;
import tools.reflection.classLoading.c;
import tools.reflection.classLoading.d;
import tools.reflection.classLoading.e;
import tools.reflection.classLoading.f;
import tools.reflection.classLoading.h;
import tools.reflection.classLoading.k;
import tools.reflection.classLoading.n;

public final class i
extends h {
    @NotNull
    private final ConcurrentHashMap<Class<?>, Integer> f = new ConcurrentHashMap();
    @NotNull
    private final ConcurrentHashMap<Integer, Class<?>> g = new ConcurrentHashMap();
    @NotNull
    private AtomicInteger h = new AtomicInteger(0);
    @NotNull
    private b_ i = new b_();
    private int j = 1;
    private int k;

    i() {
        tools.reflection.classLoading.k.a(this, n.b());
        d.a(this.i);
        this.a(d.b());
    }

    public static boolean j() {
        return c.a();
    }

    @Override
    @NotNull
    public Class<?> a(int n2) {
        Class<?> clazz = this.g.get(n2);
        return clazz == null ? h.a_.class : clazz;
    }

    @Override
    public int a(@NotNull Class<?> clazz) {
        Integer n2 = this.f.get(clazz);
        if (n2 == null) {
            this.b(clazz);
            n2 = this.f.get(clazz);
        }
        return n2;
    }

    @Override
    @NotNull
    public Iterable<Class<?>> f() {
        this.k = this.j;
        TreeMap treeMap = new TreeMap(this.g);
        ArrayList arrayList = new ArrayList(treeMap.size());
        for (Object o: treeMap.values()) {
            arrayList.add( o );
        }
        return new ArrayList(arrayList);
    }

    @Override
    public synchronized int g() {
        return this.g.size();
    }

    @Override
    public boolean h() {
        return this.k != this.j;
    }

    @Override
    public boolean b(int n2) {
        return this.g.containsKey(n2);
    }

    @Override
    protected boolean b(@NotNull Class<?> clazz) {
        int n2;
        ++this.j;
        int n3 = this.h.incrementAndGet();
        Integer n4 = this.f.putIfAbsent(clazz, n3);
        int n5 = n2 = n4 == null ? n3 : n4;
        if (n4 == null) {
            this.g.put(n2, clazz);
        }
        if (n4 == null) {
            this.d(clazz);
            return true;
        }
        return false;
    }

    @Override
    protected boolean c(@NotNull Class<?> clazz) {
        Integer n2 = this.f.get(clazz);
        if (n2 != null) {
            ++this.j;
            this.f.remove(clazz);
            this.g.remove(n2);
            return true;
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void d(@NotNull Class<?> clazz) {
        Map<e, f> map;
        Map<e, f> map2 = map = this.i();
        synchronized (map2) {
            for (Map.Entry<e, f> entry : map.entrySet()) {
                if (!entry.getKey().a(clazz)) continue;
                entry.getValue().a(clazz);
            }
        }
    }

    private final class b_
    implements d.a_ {
        private b_() {
        }

        @Override
        public void a(@NotNull Class<?> clazz) {
            i.this.b(clazz);
        }
    }
}

