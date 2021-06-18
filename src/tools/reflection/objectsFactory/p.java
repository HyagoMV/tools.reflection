/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection.objectsFactory;

import gnu.trove.TIntObjectHashMap;
import gnu.trove.TIntObjectProcedure;
import ioBase.CppInSerializable;
import ioBase.CppOutSerializable;
import ioBase.SerializationDataInput;
import ioBase.SerializationDataOutput;
import ioBase.SerializationException;
import org.jetbrains.annotations.NotNull;
import tools.reflection.classLoading.h;
import tools.reflection.objectsFactory.ObjectsConstructor;
import tools.reflection.objectsFactory.o;

public final class p
extends o {
    @NotNull
    private ObjectsConstructor<?, SerializationException> a;
    @NotNull
    private final TIntObjectHashMap<Class<?>> b = new TIntObjectHashMap();

    @NotNull
    public CppInSerializable b(@NotNull SerializationDataInput serializationDataInput, @NotNull Class<?> clazz) throws SerializationException {
        int n2 = h.c().a(clazz);
        Object obj = this.a.a(n2, serializationDataInput);
        if (obj == null) {
            throw new SerializationException("can't read obj of with class id \"" + n2 + "\", not found");
        }
        return (CppInSerializable)obj;
    }

    @Override
    public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
        ((CppOutSerializable)object).writeCpp(serializationDataOutput);
    }

    @Override
    public boolean b(@NotNull Class<?> clazz) {
        boolean bl = super.b(clazz);
        if (bl) {
            int n2 = h.c().a(clazz);
            this.b.put(n2, clazz);
        }
        return bl;
    }

    public void a() {
        this.a = new ObjectsConstructor<Object, SerializationException>(new ObjectsConstructor.d_<Object>(){

            @Override
            public void a(@NotNull TIntObjectProcedure<Class<?>> tIntObjectProcedure) {
                p.this.b.forEachEntry(tIntObjectProcedure);
            }
        }, SerializationException.class, ObjectsConstructor.a_.Serializable);
    }

	@Override
	public Object a(SerializationDataInput var1, Class<?> var2) throws SerializationException {
		System.err.println("OPS..............!!!");
		return null;
	}
}

