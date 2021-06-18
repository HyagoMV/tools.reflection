/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection.objectsFactory;

import ioBase.SerializationDataInput;
import ioBase.SerializationException;
import org.jetbrains.annotations.NotNull;

public interface f<T> {
    @NotNull
    public T a(@NotNull SerializationDataInput var1) throws SerializationException;
}

