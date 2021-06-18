/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection.objectsFactory;

import ioBase.CppInSerializable;
import ioBase.CppOutSerializable;
import ioBase.SerializationDataInput;
import ioBase.SerializationDataOutput;
import ioBase.SerializationException;
import org.jetbrains.annotations.NotNull;
import tools.reflection.cb;
import tools.reflection.objectsFactory.o;

public final class q extends o {
	@NotNull
	public CppInSerializable b(@NotNull SerializationDataInput serializationDataInput, @NotNull Class<?> clazz)
			throws SerializationException {
		try {
			Object[] arr = {serializationDataInput};
			return (CppInSerializable) cb.a(clazz, arr);
		} catch (cb.b_ b_2) {
			throw new SerializationException(b_2);
		}
	}

	@Override
	public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object)
			throws SerializationException {
		((CppOutSerializable) object).writeCpp(serializationDataOutput);
	}

	@Override
	public Object a(SerializationDataInput var1, Class<?> var2) throws SerializationException {
		System.err.println("OPS.............!");
		return null;
	}
}
