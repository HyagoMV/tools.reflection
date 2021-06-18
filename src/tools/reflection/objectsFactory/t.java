/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.Logger
 */
package tools.reflection.objectsFactory;

import gnu.trove.THashSet;
import ioBase.SerializationDataInput;
import ioBase.SerializationDataOutput;
import ioBase.SerializationException;
import java.io.Serializable;
import java.util.Set;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import tools.reflection.objectsFactory.j;

public final class t
extends j.a_ {
    @NotNull
    private static final Logger a = Logger.getLogger((String)"JavaSerialization");
    private boolean b;
    @NotNull
    private final Set<Class<?>> c = new THashSet();

    public t() {
        this.b = a.isInfoEnabled();
    }

    @Override
    public boolean a(@NotNull Class<?> clazz) {
        return Serializable.class.isAssignableFrom(clazz);
    }

    @NotNull
    public Serializable b(@NotNull SerializationDataInput serializationDataInput, @NotNull Class<?> clazz) throws SerializationException {
        try {
            return serializationDataInput.readByJavaSerialization();
        }
        catch (ClassCastException classCastException) {
            throw new SerializationException(classCastException);
        }
    }

    @Override
    public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
        Class<?> clazz;
        if (this.b && this.c.add(clazz = object.getClass())) {
            a.info(clazz);
        }
        try {
            serializationDataOutput.writeJava((Serializable)object);
        }
        catch (ClassCastException classCastException) {
            throw new SerializationException(classCastException);
        }
    }

	@Override
	public Object a(SerializationDataInput var1, Class<?> var2) throws SerializationException {
		System.err.println("OPS..............!!");
		return null;
	}
}

