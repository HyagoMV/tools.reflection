/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection.objectsFactory;

import ioBase.SerializationDataInput;
import ioBase.SerializationException;
import java.util.Arrays;
import java.util.Comparator;
import org.jetbrains.annotations.NotNull;
import tools.reflection.objectsFactory.j;
import tools.reflection.objectsFactory.k;
import tools.reflection.objectsFactory.q;
import tools.reflection.objectsFactory.s;
import tools.reflection.objectsFactory.t;
import tools.wb;

public final class y
implements j {
    @NotNull
    private static final j.a_ c = new s();
    @NotNull
    private wb<Integer, j.a_>[] d;
    @NotNull
    private j.a_[] e;
    @NotNull
    private q f;

    @SafeVarargs
    y(wb<Integer, j.a_> ... wbArray) {
        this.d = Arrays.copyOf(wbArray, wbArray.length);
        this.f = new q();
        this.a(150, this.f);
        this.a(160, new k(this));
        this.a(170, new t());
    }

    @Override
    public void a(int n2, @NotNull j.a_ a_2) {
        this.d = Arrays.copyOf(this.d, this.d.length + 1);
        this.d[this.d.length - 1] = wb.b(n2, a_2);
        Arrays.sort(this.d, new Comparator<wb<Integer, j.a_>>(){

            public int compare(@NotNull wb<Integer, j.a_> wb2, @NotNull wb<Integer, j.a_> wb3) {
                return wb2.a() - wb3.a();
            }
        });
        this.e = new j.a_[this.d.length];
        for (int i2 = 0; i2 < this.d.length; ++i2) {
            this.e[i2] = this.d[i2].b();
        }
    }

    @Override
    public void a() {
    }

    @Override
    @NotNull
    public j.a_ a(@NotNull Class<?> clazz) {
        for (j.a_ a_2 : this.e) {
            if (!a_2.b(clazz)) continue;
            return a_2;
        }
        return c;
    }

    @Override
    @NotNull
    public j.a_ a(@NotNull Object object) {
        for (j.a_ a_2 : this.e) {
            if (!a_2.b(object.getClass())) continue;
            return a_2;
        }
        return c;
    }

    @Override
    @NotNull
    public j.a_ b() {
        return this.f;
    }

    @Override
    @NotNull
    public Object a(@NotNull SerializationDataInput serializationDataInput, @NotNull Class<?> clazz) throws SerializationException {
        return this.a(clazz).a(serializationDataInput, clazz);
    }
}

