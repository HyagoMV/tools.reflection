/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Preconditions
 */
package tools.reflection.objectsFactory;

import com.google.common.base.Preconditions;
import gnu.trove.THashSet;
import gnu.trove.TIntObjectProcedure;
import gnu.trove.TNullableObjectProcedure;
import ioBase.SerializationDataInput;
import ioBase.SerializationDataOutput;
import ioBase.SerializationException;
import java.lang.reflect.Modifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tools.reflection.objectsFactory.EnumConstructor;
import tools.reflection.objectsFactory.j;

public final class r
extends j.a_ {
    @NotNull
    private EnumConstructor a;
    @NotNull
    private final THashSet<Class<?>> b = new THashSet();

    public void a() {
        final int[] nArray = new int[]{0};
        this.a = new EnumConstructor(new EnumConstructor.Iterable(){

            @Override
            public void forEach(final @NotNull TIntObjectProcedure<Class<?>> tIntObjectProcedure) {
                r.this.b.forEach(new TNullableObjectProcedure<Class<?>>(){

                    public boolean execute(@Nullable Class<?> clazz) {
                        if (clazz == null) return true;
                        int n2 = nArray[0];
                        nArray[0] = n2 + 1;
                        if (!tIntObjectProcedure.execute(n2, clazz)) return false;
                        return true;
                    }
                });
            }
        }, SerializationException.class);
    }

    @Nullable
    public static Class<?> d(@NotNull Class<?> clazz) {
        if (clazz.isEnum()) {
            return clazz;
        }
        Class<?> clazz2 = clazz.getSuperclass();
        return clazz2 != null && clazz2.isEnum() ? clazz2 : null;
    }

    public static boolean e(@NotNull Class<?> clazz) {
        return r.d(clazz) != null;
    }

    @Override
    public boolean a(@NotNull Class<?> clazz) {
        Class<?> clazz2 = r.d(clazz);
        if (clazz2 == null) {
            return false;
        }
        if (!Modifier.isPublic(clazz2.getModifiers())) {
            return false;
        }
        if (clazz.isEnum()) {
            this.b.add(clazz);
        }
        return true;
    }

    @Override
    @NotNull
    public Class<?> c(@NotNull Class<?> clazz) {
        return (Class)Preconditions.checkNotNull(r.d(clazz));
    }

    @NotNull
    public Enum<?> b(@NotNull SerializationDataInput serializationDataInput, @NotNull Class<?> clazz) throws SerializationException {
        return this.a.readEnum(serializationDataInput, clazz.asSubclass(Enum.class));
    }

    @Override
    public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
        this.a(serializationDataOutput, (Enum)object);
    }

    private <T extends Enum<T>> void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull T t2) throws SerializationException {
        Class clazz = (Class)Preconditions.checkNotNull(r.d(t2.getClass()));
        this.a.writeEnum(serializationDataOutput, clazz, t2);
    }

	@Override
	public Object a(SerializationDataInput var1, Class<?> var2) throws SerializationException {
		// TODO Auto-generated method stub
		System.err.println("OPS..........!!");
		return null;
	}
}

