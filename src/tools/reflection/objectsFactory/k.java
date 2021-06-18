/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection.objectsFactory;

import ioBase.SerializationDataInput;
import ioBase.SerializationDataOutput;
import ioBase.SerializationException;
import java.lang.reflect.Array;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tools.reflection.objectsFactory.j;

public final class k
extends j.a_ {
    private static final int a = 200000;
    @NotNull
    private static final ConcurrentHashMap<Class<?>, Class<?>> b = new ConcurrentHashMap();
    @NotNull
    private final j c;

    public k(@NotNull j j2) {
        this.c = j2;
    }

    @Override
    public boolean a(@NotNull Class<?> clazz) {
        return clazz.isArray();
    }

    @Override
    public boolean b(@NotNull Class<?> clazz) {
        return a_.class.equals(clazz);
    }

    @Override
    @NotNull
    public Class<?> c(@NotNull Class<?> clazz) {
        return a_.class;
    }

    @Override
    @NotNull
    public Object a(@NotNull SerializationDataInput serializationDataInput, @NotNull Class<?> clazz) throws SerializationException {
        short s2;
        Class clazz2 = serializationDataInput.readClass();
        Object object = this.a(serializationDataInput, clazz2, s2 = serializationDataInput.readShort());
        if (object == null) {
            return Array.newInstance(clazz2, 0);
        }
        return object;
    }

    @Nullable
    private Object a(@NotNull SerializationDataInput serializationDataInput, @NotNull Class<?> clazz, int n2) throws SerializationException {
        int n3 = serializationDataInput.readInt();
        if (n3 > 200000) {
            throw new SerializationException("invalid array size (" + n3 + ", should be [0.." + 200000 + ']');
        }
        if (n3 == -1) {
            return null;
        }
        try {
            if (n2 > 1) {
                int[] nArray = new int[n2];
                nArray[0] = n3;
                Object object = Array.newInstance(clazz, nArray);
                for (int i2 = 0; i2 < n3; ++i2) {
                    Array.set(object, i2, this.a(serializationDataInput, clazz, n2 - 1));
                }
                return object;
            }
            if (clazz.equals(Byte.class) || clazz.equals(Byte.TYPE)) {
                serializationDataInput.readInt();
                return serializationDataInput.readByteArray(n3);
            }
            if (clazz.equals(Short.class) || clazz.equals(Short.TYPE)) {
                short[] sArray = new short[n3];
                for (int i3 = 0; i3 < n3; ++i3) {
                    sArray[i3] = serializationDataInput.readShort();
                }
                return sArray;
            }
            if (clazz.equals(Integer.class) || clazz.equals(Integer.TYPE)) {
                int[] nArray = new int[n3];
                for (int i4 = 0; i4 < n3; ++i4) {
                    nArray[i4] = serializationDataInput.readInt();
                }
                return nArray;
            }
            if (clazz.equals(Long.class) || clazz.equals(Long.TYPE)) {
                long[] lArray = new long[n3];
                for (int i5 = 0; i5 < n3; ++i5) {
                    lArray[i5] = serializationDataInput.readLong();
                }
                return lArray;
            }
            if (clazz.equals(Double.class) || clazz.equals(Double.TYPE)) {
                double[] dArray = new double[n3];
                for (int i6 = 0; i6 < n3; ++i6) {
                    dArray[i6] = serializationDataInput.readDouble();
                }
                return dArray;
            }
            if (clazz.equals(Float.class) || clazz.equals(Float.TYPE)) {
                float[] fArray = new float[n3];
                for (int i7 = 0; i7 < n3; ++i7) {
                    fArray[i7] = serializationDataInput.readFloat(-1);
                }
                return fArray;
            }
            Object object = Array.newInstance(clazz, n3);
            for (int i8 = 0; i8 < n3; ++i8) {
                Class<?> clazz2 = serializationDataInput.readClassNullable();
                if (clazz2 == null) continue;
                Object object2 = this.c.a(serializationDataInput, clazz2);
                Array.set(object, i8, object2);
            }
            return object;
        }
        catch (ArrayIndexOutOfBoundsException | IllegalArgumentException | NegativeArraySizeException runtimeException) {
            throw new SerializationException("exception during reading of array of " + clazz, runtimeException);
        }
    }

    @Override
    public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
        Class<?> clazz = object.getClass();
        if (!clazz.isArray()) {
            throw new SerializationException("exception serializing " + object + " as array: not an array");
        }
        Class<?> clazz2 = k.d(clazz);
        short s2 = tools.containers.j.c(clazz);
        serializationDataOutput.writeClass(clazz2);
        serializationDataOutput.writeShort(s2);
        k.a(object, serializationDataOutput, clazz.getComponentType());
    }

    private static void a(@Nullable Object object, @NotNull SerializationDataOutput serializationDataOutput, @NotNull Class<?> clazz) throws SerializationException {
        try {
            if (object == null) {
                serializationDataOutput.writeInt(-1);
                return;
            }
            int n2 = Array.getLength(object);
            if (n2 > 200000) {
                throw new SerializationException("arrays length is to big (" + n2 + ", maximum length is " + 200000 + ')');
            }
            serializationDataOutput.writeInt(n2);
            if (clazz.isArray()) {
                Class<?> clazz2 = clazz.getComponentType();
                for (int i2 = 0; i2 < n2; ++i2) {
                    k.a(Array.get(object, i2), serializationDataOutput, clazz2);
                }
            } else if (clazz.equals(Byte.class) || clazz.equals(Byte.TYPE)) {
                serializationDataOutput.writeByteArray((byte[])object, 200000);
            } else if (clazz.equals(Short.class) || clazz.equals(Short.TYPE)) {
                for (short s2 : (short[])object) {
                    serializationDataOutput.writeShort(s2);
                }
            } else if (clazz.equals(Integer.class) || clazz.equals(Integer.TYPE)) {
                for (int n3 : (int[])object) {
                    serializationDataOutput.writeInt(n3);
                }
            } else if (clazz.equals(Long.class) || clazz.equals(Long.TYPE)) {
                for (long l2 : (long[])object) {
                    serializationDataOutput.writeLong(l2);
                }
            } else if (clazz.equals(Double.class) || clazz.equals(Double.TYPE)) {
                for (double d2 : (double[])object) {
                    serializationDataOutput.writeDouble(d2);
                }
            } else if (clazz.equals(Float.class) || clazz.equals(Float.TYPE)) {
                for (float f2 : (float[])object) {
                    serializationDataOutput.writeFloat(f2, -1);
                }
            } else {
                for (int i3 = 0; i3 < n2; ++i3) {
                    Object object2 = Array.get(object, i3);
                    if (object2 != null) {
                        serializationDataOutput.writeObject(object2);
                        continue;
                    }
                    serializationDataOutput.writeClassNullable(null);
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException | IllegalArgumentException runtimeException) {
            throw new SerializationException("exception serializing " + object + " as array", runtimeException);
        }
    }

    @NotNull
    private static Class<?> d(@NotNull Class<?> clazz) {
        Class<?> clazz2 = b.get(clazz);
        if (clazz2 == null) {
            clazz2 = tools.containers.j.d(clazz);
            b.put(clazz, clazz2);
        }
        return clazz2;
    }

    public static interface a_ {
    }
}

