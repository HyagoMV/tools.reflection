/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection.objectsFactory;

import ioBase.SerializationDataInput;
import ioBase.SerializationDataOutput;
import ioBase.SerializationException;
import org.jetbrains.annotations.NotNull;
import tools.reflection.objectsFactory.j;

public final class u
extends j.a_ {
    @Override
    public boolean a(@NotNull Class<?> clazz) {
        return Number.class.isAssignableFrom(clazz);
    }

    @Override
    @NotNull
    public Object a(@NotNull SerializationDataInput serializationDataInput, @NotNull Class<?> clazz) throws SerializationException {
        if (clazz.equals(Float.class)) {
            return Float.valueOf(serializationDataInput.readFloat(-1));
        }
        if (clazz.equals(Short.class)) {
            return serializationDataInput.readShort();
        }
        if (clazz.equals(Byte.class)) {
            return serializationDataInput.readByte();
        }
        if (clazz.equals(Integer.class)) {
            return serializationDataInput.readInt();
        }
        if (clazz.equals(Long.class)) {
            return serializationDataInput.readLong();
        }
        if (clazz.equals(Double.class)) {
            return serializationDataInput.readDouble();
        }
        throw new SerializationException("unknown number type " + clazz);
    }

    @Override
    public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
        Number number = (Number)object;
        if (object instanceof Float) {
            serializationDataOutput.writeFloat(number.floatValue(), -1);
        } else if (object instanceof Short) {
            serializationDataOutput.writeShort(number.shortValue());
        } else if (object instanceof Byte) {
            serializationDataOutput.writeByte(number.byteValue());
        } else if (object instanceof Integer) {
            serializationDataOutput.writeInt(number.intValue());
        } else if (object instanceof Long) {
            serializationDataOutput.writeLong(number.longValue());
        } else if (object instanceof Double) {
            serializationDataOutput.writeDouble(number.doubleValue());
        } else {
            throw new SerializationException(String.format("unknown number type %s[%s]", number, number.getClass()));
        }
    }
}

