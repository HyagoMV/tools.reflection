/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection.objectsFactory;

import ioBase.SerializationDataInput;
import ioBase.SerializationDataOutput;
import ioBase.SerializationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tools.reflection.classLoading.h;
import tools.reflection.objectsFactory.j;

public final class s
extends j.a_ {
    @Nullable
    private String a = null;

    public s() {
    }

    public s(@NotNull String string) {
        this.a = string;
    }

    @Override
    public boolean a(@NotNull Class<?> clazz) {
        return false;
    }

    @Override
    @NotNull
    public Class<?> c(@NotNull Class<?> clazz) {
        return h.a_.class;
    }

    @Override
    @NotNull
    public Object a(@NotNull SerializationDataInput serializationDataInput, @NotNull Class<?> clazz) throws SerializationException {
        String string = "Can't deserialize object of type " + clazz.getCanonicalName() + '.';
        throw new SerializationException(this.a != null ? string + ' ' + this.a : string);
    }

    @Override
    public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
        String string = "Can't serialize object of type " + object.getClass().getCanonicalName() + '.';
        throw new SerializationException(this.a != null ? string + ' ' + this.a : string);
    }
}

