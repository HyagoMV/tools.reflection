/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection.objectsFactory;

import asserts.Verify;
import gnu.trove.THashMap;
import gnu.trove.TIntObjectProcedure;
import ioBase.CppOutSerializable;
import ioBase.DebugSerializationTags;
import ioBase.IDObject;
import ioBase.SerializationDataInput;
import ioBase.SerializationDataOutput;
import ioBase.SerializationException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tools.reflection.objectsFactory.ObjectsConstructor;
import tools.reflection.objectsFactory.f;

public class g<T>
implements f<T> {
    @NotNull
    private static final String a = "s_serializationId";
    @NotNull
    private ObjectsConstructor<T, SerializationException> b;

    @NotNull
    public static <T, E extends Annotation> g<T> a(@NotNull Class<T> clazz, @Nullable Class<E> clazz2) {
        return new g<T>(clazz, clazz2);
    }

    @NotNull
    protected static String a(@NotNull String string) {
        int n2;
        StringBuilder stringBuilder = new StringBuilder();
        int n3 = 0;
        do {
            n2 = string.indexOf(46, n3);
            if (!Character.isUpperCase(string.charAt(n3))) continue;
            stringBuilder.append(string.substring(n3, n2 == -1 ? string.length() : n2));
        } while ((n3 = n2 + 1) != 0);
        return stringBuilder.toString();
    }

    protected <E extends Annotation> g(@NotNull Class<T> clazz, @Nullable Class<E> clazz2, @NotNull b_<T, E> b_2, @NotNull ObjectsConstructor.d_<T> d_2) {
        tools.reflection.classLoading.g.a(clazz, clazz2, true, b_2);
        this.a(d_2);
    }

    protected <E extends Annotation> g(@NotNull Class<T> clazz, @Nullable Class<E> clazz2, @NotNull b_<T, E> b_2) {
        this(clazz, clazz2, b_2, new c_<T>(b_2));
    }

    protected <E extends Annotation> g(@NotNull Class<T> clazz, @Nullable Class<E> clazz2) {
        this(clazz, clazz2, new b_());
    }

    public <T extends CppOutSerializable & IDObject> void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull T t2) throws SerializationException {
        serializationDataOutput.writeTag(DebugSerializationTags.Object, t2.getClass().getName());
        serializationDataOutput.writeInt(((IDObject)t2).getID());
        t2.writeCpp(serializationDataOutput);
    }

    @Override
    @NotNull
    public T a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        serializationDataInput.readTag(DebugSerializationTags.Object);
        T t2 = this.b.a(n2, serializationDataInput);
        if (t2 == null) {
            throw new SerializationException("unknown cmd, id = " + n2);
        }
        return t2;
    }

    private void a(@NotNull ObjectsConstructor.d_<T> d_2) {
        d_2.a(new TIntObjectProcedure<Class<? extends T>>(){

            private void a(@NotNull Class<?> clazz, int n2) {
                try {
                    Field field = clazz.getDeclaredField(g.a);
                    field.setAccessible(true);
                    if ("ConnectionData".equals(clazz.getSimpleName()) && n2 == 4) {
                        boolean bl = false;
                    }
                    field.setInt(null, n2);
                }
                catch (NoSuchFieldException noSuchFieldException) {
                    Verify.fail("Cant find field s_serializationId for class " + clazz, noSuchFieldException);
                }
                catch (IllegalAccessException illegalAccessException) {
                    Verify.fail("Cant set value to field s_serializationId for class " + clazz, illegalAccessException);
                }
            }

            public boolean execute(int n2, @NotNull Class<? extends T> clazz) {
                this.a(clazz, n2);
                return true;
            }
        });
        this.b = new ObjectsConstructor<T, SerializationException>(d_2, SerializationException.class, ObjectsConstructor.a_.Serializable);
    }

    public static class d_<T>
    implements Comparable<d_<T>> {
        @NotNull
        private final Class<? extends T> a;
        @NotNull
        private final String b;

        @NotNull
        private static String a(@NotNull String string) {
            int n2;
            StringBuilder stringBuilder = new StringBuilder();
            int n3 = 0;
            do {
                n2 = string.indexOf(46, n3);
                if (!Character.isUpperCase(string.charAt(n3))) continue;
                stringBuilder.append(string.substring(n3, n2 == -1 ? string.length() : n2));
            } while ((n3 = n2 + 1) != 0);
            return stringBuilder.toString();
        }

        public d_(@NotNull Class<? extends T> clazz) {
            this.a = clazz;
            this.b = d_.a(clazz.getCanonicalName());
        }

        public boolean equals(@Nullable Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || this.getClass() != object.getClass()) {
                return false;
            }
            d_ d_2 = (d_)object;
            return this.b.equals(d_2.b);
        }

        public int hashCode() {
            return this.b.hashCode();
        }

        public int compareTo(@NotNull d_<T> d_2) {
            return this.b.compareTo(d_2.b);
        }

        @NotNull
        public Class<? extends T> b() {
            return this.a;
        }

        @NotNull
        public String a() {
            return this.b;
        }

        public String toString() {
            return this.a.toString();
        }

    }

    public static class b_<T, E extends Annotation>
    implements tools.reflection.classLoading.g.a_<T, E> {
        @NotNull
        private final THashMap<String, d_<T>> a = new THashMap();

        @Override
        public final void found(@NotNull Class<? extends T> clazz, @Nullable E e2) {
            String string = clazz.getCanonicalName();
            if ((e2 == null || this.a(e2, clazz)) && string != null) {
                d_<T> d_2 = this.a(clazz);
                d_<T> d_3 = this.a.get(d_2.a());
                if (d_3 != null && !this.a(d_3.b(), d_2.b())) {
                    return;
                }
                this.a.put(d_2.a(), d_2);
            }
        }

        public boolean a(@NotNull E e2, @NotNull Class<? extends T> clazz) {
            return true;
        }

        @NotNull
        public d_<T> a(@NotNull Class<? extends T> clazz) {
            return new d_<T>(clazz);
        }

        @NotNull
        public final Set<d_<T>> a() {
            TreeSet<d_<T>> treeSet = new TreeSet<d_<T>>();
            treeSet.addAll(this.a.values());
            return treeSet;
        }

        protected boolean a(@NotNull Class<? extends T> clazz, @NotNull Class<? extends T> clazz2) {
            return false;
        }
    }

    public static class c_<T>
    implements ObjectsConstructor.d_<T> {
        @NotNull
        private final b_<T, ?> a;

        public c_(@NotNull b_<T, ?> b_2) {
            this.a = b_2;
        }

        @Override
        public final void a(@NotNull TIntObjectProcedure<Class<? extends T>> tIntObjectProcedure) {
            int n2 = 1;
            Set<d_<T>> set = this.a.a();
            for (d_<T> d_2 : set) {
                Class<? extends T> clazz = d_2.b();
                tIntObjectProcedure.execute(this.a(n2++, clazz), clazz);
            }
        }

        protected int a(int n2, @NotNull Class<? extends T> clazz) {
            return n2;
        }
    }
}

