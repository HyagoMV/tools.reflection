/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection.objectsFactory;

import gnu.trove.IdentityObjectHashingStrategy;
import gnu.trove.TObjectIntHashMap;
import ioBase.SerializationDataInput;
import ioBase.SerializationDataOutput;
import ioBase.SerializationException;
import org.jetbrains.annotations.NotNull;
import tools.reflection.objectsFactory.b;
import tools.reflection.objectsFactory.c;
import tools.reflection.objectsFactory.j;

public final class n
extends j.a_ {
    @NotNull
    private static final TObjectIntHashMap<Class<?>> a = new TObjectIntHashMap(IdentityObjectHashingStrategy.instance());

    @Override
    public boolean a(@NotNull Class<?> clazz) {
        return a.containsKey(clazz);
    }

    @Override
    @NotNull
    public Object a(@NotNull SerializationDataInput serializationDataInput, @NotNull Class<?> clazz) throws SerializationException {
        c c2 = b.b.get(clazz);
        if (c2 == null) {
            throw new SerializationException("Failed to deserialize collection of type: " + clazz);
        }
        return c2.a(serializationDataInput);
    }

    @Override
    public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
        c c2 = b.b.get(object.getClass());
        if (c2 == null) {
            throw new SerializationException("Failed to deserialize collection of type: " + object.getClass());
        }
        c2.a(serializationDataOutput, object);
    }

    static {
        for (int i2 = 0; i2 < b.a.length; ++i2) {
            a.put(b.a[i2], i2);
        }
    }
}

