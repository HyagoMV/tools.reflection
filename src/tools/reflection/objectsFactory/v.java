/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection.objectsFactory;

import ioBase.SerializationDataInput;
import ioBase.SerializationDataOutput;
import ioBase.SerializationException;
import org.jetbrains.annotations.NotNull;
import tools.reflection.objectsFactory.j;

public final class v
extends j.a_ {
    @Override
    public boolean a(@NotNull Class<?> clazz) {
        return String.class.equals(clazz);
    }

    @NotNull
    public String b(@NotNull SerializationDataInput serializationDataInput, @NotNull Class<?> clazz) throws SerializationException {
        return serializationDataInput.readUTF();
    }

    @Override
    public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
        try {
            serializationDataOutput.writeUTF((String)object);
        }
        catch (ClassCastException classCastException) {
            throw new SerializationException(classCastException);
        }
    }

	@Override
	public Object a(SerializationDataInput var1, Class<?> var2) throws SerializationException {
		// TODO Auto-generated method stub
		System.err.println("OPS..............!!");
		return null;
	}
}

