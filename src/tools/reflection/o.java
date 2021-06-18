/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection;

import java.lang.reflect.Field;
import org.jetbrains.annotations.NotNull;
import tools.reflection.cb;
import tools.reflection.t;

public final class o
implements t.d_ {
    @NotNull
    private final t.d_ a;

    @NotNull
    public static o a(@NotNull t.d_ d_2) {
        return o.c(o.b(d_2));
    }

    @NotNull
    public static o a(@NotNull o o2) {
        return o.c(o.b(o2.a));
    }

    @NotNull
    private static t.d_ a(final @NotNull t.d_ d_2, final @NotNull t.d_ d_3) {
        return new t.d_(){

            @Override
            public boolean a(@NotNull Object object, @NotNull Field field) {
                return d_2.a(object, field) && d_3.a(object, field);
            }

            @Override
            public boolean a(@NotNull Object object, @NotNull Object object2) {
                return d_2.a(object, object2) && d_3.a(object, object2);
            }
        };
    }

    @NotNull
    public static o a(final @NotNull Class<?> clazz, final @NotNull Class<?> clazz2) {
        t.d_ d_2 = new t.d_(){

            @Override
            public boolean a(@NotNull Object object, @NotNull Field field) {
                return !clazz.isAssignableFrom(object.getClass()) || clazz2.isAssignableFrom(field.getType());
            }

            @Override
            public boolean a(@NotNull Object object, @NotNull Object object2) {
                return !clazz.isAssignableFrom(object.getClass()) || clazz2.isAssignableFrom(object2.getClass());
            }
        };
        return o.c(d_2);
    }

    @NotNull
    public static o a(@NotNull Class<?> clazz) {
        g_ g_2 = new g_(clazz);
        return o.c(g_2);
    }

    @NotNull
    public static o a(final @NotNull Class<?> clazz, final @NotNull String string) {
        t.d_ d_2 = new t.d_(){

            @Override
            public boolean a(@NotNull Object object, @NotNull Field field) {
                return !clazz.isAssignableFrom(object.getClass()) || field.getName().equals(string);
            }

            @Override
            public boolean a(@NotNull Object object, @NotNull Object object2) {
                return !clazz.isAssignableFrom(object.getClass());
            }
        };
        return o.c(d_2);
    }

    @NotNull
    private static t.d_ b(final @NotNull t.d_ d_2) {
        return new t.d_(){

            @Override
            public boolean a(@NotNull Object object, @NotNull Field field) {
                return !d_2.a(object, field);
            }

            @Override
            public boolean a(@NotNull Object object, @NotNull Object object2) {
                return !d_2.a(object, object2);
            }
        };
    }

    @NotNull
    private static t.d_ b(final @NotNull t.d_ d_2, final @NotNull t.d_ d_3) {
        return new t.d_(){

            @Override
            public boolean a(@NotNull Object object, @NotNull Field field) {
                return d_2.a(object, field) || d_3.a(object, field);
            }

            @Override
            public boolean a(@NotNull Object object, @NotNull Object object2) {
                return d_2.a(object, object2) || d_3.a(object, object2);
            }
        };
    }

    @NotNull
    private static t.d_ c(final @NotNull t.d_ d_2, final @NotNull t.d_ d_3) {
        return new t.d_(){

            @Override
            public boolean a(@NotNull Object object, @NotNull Field field) {
                return d_2.a(object, field) ^ d_3.a(object, field);
            }

            @Override
            public boolean a(@NotNull Object object, @NotNull Object object2) {
                return d_2.a(object, object2) ^ d_3.a(object, object2);
            }
        };
    }

    @NotNull
    public static o c(@NotNull t.d_ d_2) {
        return new o(d_2);
    }

    private o(@NotNull t.d_ d_2) {
        this.a = d_2;
    }

    @Override
    public boolean a(@NotNull Object object, @NotNull Field field) {
        return this.a.a(object, field);
    }

    @Override
    public boolean a(@NotNull Object object, @NotNull Object object2) {
        return this.a.a(object, object2);
    }

    @NotNull
    public o d(@NotNull t.d_ d_2) {
        return o.c(o.a(this.a, d_2));
    }

    @NotNull
    public o b(@NotNull o o2) {
        return o.c(o.a(this.a, o2.a));
    }

    @NotNull
    public o e(@NotNull t.d_ d_2) {
        return o.c(o.b(this.a, d_2));
    }

    @NotNull
    public o c(@NotNull o o2) {
        return o.c(o.b(this.a, o2.a));
    }

    @NotNull
    public o f(@NotNull t.d_ d_2) {
        return o.c(o.c(this.a, d_2));
    }

    @NotNull
    public o d(@NotNull o o2) {
        return o.c(o.c(this.a, o2.a));
    }

    private static final class g_
    implements t.d_ {
        @NotNull
        private final Class<?> a;

        public g_(@NotNull Class<?> clazz) {
            this.a = clazz;
        }

        @Override
        public boolean a(@NotNull Object object, @NotNull Field field) {
            return !this.b(object, field);
        }

        @Override
        public boolean a(@NotNull Object object, @NotNull Object object2) {
            return !this.a.isAssignableFrom(object2.getClass());
        }

        private boolean b(@NotNull Object object, @NotNull Field field) {
            try {
                Object object2 = cb.a(object, field);
                return this.a.isAssignableFrom(object2 == null ? field.getType() : object2.getClass());
            }
            catch (cb.b_ b_2) {
                return this.a.isAssignableFrom(field.getType());
            }
        }
    }
}

