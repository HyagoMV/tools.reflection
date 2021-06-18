/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection.objectsFactory;

import ioBase.SerializationDataInput;
import ioBase.SerializationDataOutput;
import ioBase.SerializationException;
import org.jetbrains.annotations.NotNull;

public interface c {
    public void a(@NotNull SerializationDataOutput var1, @NotNull Object var2) throws SerializationException;

    @NotNull
    public Object a(@NotNull SerializationDataInput var1) throws SerializationException;
}

