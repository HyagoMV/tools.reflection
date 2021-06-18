/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.Logger
 */
package tools.reflection;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import tools.reflection.bb;
import tools.reflection.z;

public final class ab
implements z.a_ {
    @NotNull
    private static final Logger a = Logger.getLogger(ab.class);
    private int b;
    @NotNull
    private final b_[] c;
    private int d;

    public ab(int n2) {
        this.b = n2;
        this.c = new b_[n2 * 2];
    }

    @Override
    public boolean a(@NotNull bb bb2, @NotNull List<String> list) {
        Object object = bb2.b();
        if (object instanceof Map || object instanceof Set) {
            int n2 = object instanceof Map ? ((Map)object).size() : ((Collection)object).size();
            this.c[this.d++] = new b_(object.getClass(), bb2, n2);
            if (this.d >= this.c.length) {
                Collections.sort(Arrays.asList(this.c), new Comparator<b_>(){

                    public int compare(@NotNull b_ b_2, @NotNull b_ b_3) {
                        if (b_2.a() == b_3.a()) {
                            return 0;
                        }
                        return b_2.a() < b_3.a() ? 1 : -1;
                    }
                });
                this.d = this.b;
            }
        }
        return true;
    }

    @Override
    public boolean a(@NotNull Field field) {
        return true;
    }

    @Override
    public boolean a(@NotNull Class<?> clazz) {
        return true;
    }

    @Override
    public boolean a(@NotNull Object object) {
        return true;
    }

    public void a() {
        StringBuilder stringBuilder = new StringBuilder("\n");
        for (b_ b_2 : this.c) {
            b_2.a(stringBuilder).append('\n');
        }
        a.info((Object)stringBuilder.toString());
    }

    private static final class b_ {
        @NotNull
        private final bb a;
        private final int b;
        @NotNull
        private final Class<?> c;

        public b_(@NotNull Class<?> clazz, @NotNull bb bb2, int n2) {
            this.c = clazz;
            this.a = bb2;
            this.b = n2;
        }

        public int a() {
            return this.b;
        }

        @NotNull
        public StringBuilder a(@NotNull StringBuilder stringBuilder) {
            return stringBuilder.append(this.b).append(';').append(this.c).append(';').append(this.a.a());
        }
    }
}

