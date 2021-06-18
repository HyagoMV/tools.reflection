/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection.objectsFactory;

import asserts.Verify;
import gnu.trove.THashMap;
import ioBase.SerializationDataInput;
import ioBase.SerializationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.TestOnly;
import tools.reflection.classLoading.h;
import tools.reflection.objectsFactory.ab;
import tools.reflection.objectsFactory.j;
import tools.reflection.objectsFactory.k;
import tools.reflection.objectsFactory.l;
import tools.reflection.objectsFactory.m;
import tools.reflection.objectsFactory.n;
import tools.reflection.objectsFactory.o;
import tools.reflection.objectsFactory.p;
import tools.reflection.objectsFactory.r;
import tools.reflection.objectsFactory.s;
import tools.reflection.objectsFactory.t;
import tools.reflection.objectsFactory.u;
import tools.reflection.objectsFactory.v;
import tools.wb;

public final class w
implements j {
    @NotNull
    private static final j.a_ c = new u();
    @NotNull
    private static final j.a_ d = new l();
    @NotNull
    private static final j.a_ e = new m();
    @NotNull
    private static final j.a_ f = new n();
    @NotNull
    private static final j.a_ g = new v();
    @NotNull
    private static final j.a_ h = new t();
    @NotNull
    private static final r i = new r();
    @NotNull
    private static final p j = new p();
    @NotNull
    private static final j.a_ k = new s();
    @NotNull
    private final THashMap<Class<?>, j.a_> l = new THashMap();
    @NotNull
    private final THashMap<Class<?>, j.a_> m = new THashMap();
    @NotNull
    private List<wb<Integer, j.a_>> n = new ArrayList<wb<Integer, j.a_>>();
    @NotNull
    private j.a_[] o;

    @SafeVarargs
    w(wb<Integer, j.a_> ... wbArray) {
        this.n = new ArrayList<wb<Integer, j.a_>>(Arrays.asList(wbArray));
        this.a(50, g);
        this.a(150, c);
        this.a(151, d);
        this.a(160, i);
        this.a(161, e);
        this.a(170, j);
        this.a(180, new k(this));
        this.a(181, f);
        this.a(190, h);
        this.a();
    }

    @Override
    public void a() {
        this.l.clear();
        this.m.clear();
        Collections.sort(this.n, new Comparator<wb<Integer, j.a_>>(){

            public int compare(@NotNull wb<Integer, j.a_> wb2, @NotNull wb<Integer, j.a_> wb3) {
                return wb2.a() - wb3.a();
            }
        });
        this.o = new j.a_[this.n.size()];
        for (int i2 = 0; i2 < this.n.size(); ++i2) {
            this.o[i2] = this.n.get(i2).b();
        }
        ArrayList arrayList = new ArrayList();
        for (Class<?> clazz : tools.reflection.classLoading.h.c().f()) {
            try {
                this.b(clazz);
            }
            catch (o.a_ a_2) {
                Verify.fail(a_2);
                arrayList.add(clazz);
            }
        }
        if (!arrayList.isEmpty()) {
            throw new ab("Some classes have a broken serialization: \n" + ((Object)arrayList).toString());
        }
        j.a();
        i.a();
    }

    @Override
    public void a(int n2, @NotNull j.a_ a_2) {
        this.n.add(wb.b(n2, a_2));
    }

    @Override
    @NotNull
    public j.a_ b() {
        return j;
    }

    @NotNull
    private j.a_ b(@NotNull Class<?> clazz) {
        for (j.a_ a_2 : this.o) {
            boolean bl = false;
            if (a_2.b(clazz)) {
                this.m.put(a_2.c(clazz), a_2);
                bl = true;
            }
            if (a_2.a(clazz)) {
                this.l.put(clazz, a_2);
                bl = true;
            }
            if (!bl) continue;
            return a_2;
        }
        return k;
    }

    @NotNull
    private j.a_ c(@NotNull Class<?> clazz) {
        for (j.a_ a_2 : this.o) {
            if (!a_2.b(clazz)) continue;
            this.m.put(clazz, a_2);
            return a_2;
        }
        return k;
    }

    @NotNull
    private j.a_ d(@NotNull Class<?> clazz) {
        j.a_ a_2 = this.l.get(clazz);
        if (a_2 == null) {
            return this.b(clazz);
        }
        return a_2;
    }

    @NotNull
    private j.a_ e(@NotNull Class<?> clazz) {
        j.a_ a_2 = this.m.get(clazz);
        if (a_2 == null && (a_2 = this.l.get(clazz)) == null) {
            return this.c(clazz);
        }
        return a_2;
    }

    @Override
    @NotNull
    public j.a_ a(@NotNull Object object) {
        return this.d(object.getClass());
    }

    @Override
    @NotNull
    public Object a(@NotNull SerializationDataInput serializationDataInput, @NotNull Class<?> clazz) throws SerializationException {
        return this.e(clazz).a(serializationDataInput, clazz);
    }

    @Override
    @TestOnly
    @NotNull
    public j.a_ a(@NotNull Class<?> clazz) {
        return this.e(clazz);
    }
}

