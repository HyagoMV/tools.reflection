/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection.objectsFactory;

import ioBase.SerializationDataInput;
import ioBase.SerializationDataOutput;
import ioBase.SerializationException;
import org.jetbrains.annotations.NotNull;
import tools.reflection.objectsFactory.j;

public final class l
extends j.a_ {
    @Override
    public boolean a(@NotNull Class<?> clazz) {
        return clazz.equals(Boolean.class);
    }

    @Override
    @NotNull
    public Object a(@NotNull SerializationDataInput serializationDataInput, @NotNull Class<?> clazz) throws SerializationException {
        return serializationDataInput.readBoolean();
    }

    @Override
    public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
        serializationDataOutput.writeBoolean((Boolean)object);
    }
}

