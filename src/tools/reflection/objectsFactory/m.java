/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection.objectsFactory;

import ioBase.SerializationDataInput;
import ioBase.SerializationDataOutput;
import ioBase.SerializationException;
import org.jetbrains.annotations.NotNull;
import tools.reflection.objectsFactory.j;

public final class m
extends j.a_ {
    @Override
    public boolean a(@NotNull Class<?> clazz) {
        return clazz.equals(Class.class);
    }

    @Override
    @NotNull
    public Object a(@NotNull SerializationDataInput serializationDataInput, @NotNull Class<?> clazz) throws SerializationException {
        if (!clazz.equals(Class.class)) {
            throw new SerializationException("Failed to deserialize class: " + clazz);
        }
        return serializationDataInput.getObjectInput().readClass(serializationDataInput);
    }

    @Override
    public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
        if (!object.getClass().equals(Class.class)) {
            throw new SerializationException("Failed to serialize class: " + object);
        }
        serializationDataOutput.getObjectOutput().writeClass(serializationDataOutput, (Class)object);
    }
}

