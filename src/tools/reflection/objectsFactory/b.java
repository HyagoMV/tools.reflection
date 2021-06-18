/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection.objectsFactory;

import gnu.trove.IdentityObjectHashingStrategy;
import gnu.trove.TByteArrayList;
import gnu.trove.TByteByteHashMap;
import gnu.trove.TByteByteIterator;
import gnu.trove.TByteDoubleHashMap;
import gnu.trove.TByteDoubleIterator;
import gnu.trove.TByteFloatHashMap;
import gnu.trove.TByteFloatIterator;
import gnu.trove.TByteHashSet;
import gnu.trove.TByteIntHashMap;
import gnu.trove.TByteIntIterator;
import gnu.trove.TByteIterator;
import gnu.trove.TByteLongHashMap;
import gnu.trove.TByteLongIterator;
import gnu.trove.TByteObjectHashMap;
import gnu.trove.TByteObjectIterator;
import gnu.trove.TByteShortHashMap;
import gnu.trove.TByteShortIterator;
import gnu.trove.TDoubleArrayList;
import gnu.trove.TDoubleByteHashMap;
import gnu.trove.TDoubleByteIterator;
import gnu.trove.TDoubleDoubleHashMap;
import gnu.trove.TDoubleDoubleIterator;
import gnu.trove.TDoubleFloatHashMap;
import gnu.trove.TDoubleFloatIterator;
import gnu.trove.TDoubleHashSet;
import gnu.trove.TDoubleIntHashMap;
import gnu.trove.TDoubleIntIterator;
import gnu.trove.TDoubleIterator;
import gnu.trove.TDoubleLongHashMap;
import gnu.trove.TDoubleLongIterator;
import gnu.trove.TDoubleObjectHashMap;
import gnu.trove.TDoubleObjectIterator;
import gnu.trove.TDoubleShortHashMap;
import gnu.trove.TDoubleShortIterator;
import gnu.trove.TFloatArrayList;
import gnu.trove.TFloatByteHashMap;
import gnu.trove.TFloatByteIterator;
import gnu.trove.TFloatDoubleHashMap;
import gnu.trove.TFloatDoubleIterator;
import gnu.trove.TFloatFloatHashMap;
import gnu.trove.TFloatFloatIterator;
import gnu.trove.TFloatHashSet;
import gnu.trove.TFloatIntHashMap;
import gnu.trove.TFloatIntIterator;
import gnu.trove.TFloatIterator;
import gnu.trove.TFloatLongHashMap;
import gnu.trove.TFloatLongIterator;
import gnu.trove.TFloatObjectHashMap;
import gnu.trove.TFloatObjectIterator;
import gnu.trove.TFloatShortHashMap;
import gnu.trove.TFloatShortIterator;
import gnu.trove.THashMap;
import gnu.trove.THashSet;
import gnu.trove.TIntArrayList;
import gnu.trove.TIntByteHashMap;
import gnu.trove.TIntByteIterator;
import gnu.trove.TIntDoubleHashMap;
import gnu.trove.TIntDoubleIterator;
import gnu.trove.TIntFloatHashMap;
import gnu.trove.TIntFloatIterator;
import gnu.trove.TIntHashSet;
import gnu.trove.TIntIntHashMap;
import gnu.trove.TIntIntIterator;
import gnu.trove.TIntIterator;
import gnu.trove.TIntLongHashMap;
import gnu.trove.TIntLongIterator;
import gnu.trove.TIntObjectHashMap;
import gnu.trove.TIntObjectIterator;
import gnu.trove.TIntShortHashMap;
import gnu.trove.TIntShortIterator;
import gnu.trove.TLongArrayList;
import gnu.trove.TLongByteHashMap;
import gnu.trove.TLongByteIterator;
import gnu.trove.TLongDoubleHashMap;
import gnu.trove.TLongDoubleIterator;
import gnu.trove.TLongFloatHashMap;
import gnu.trove.TLongFloatIterator;
import gnu.trove.TLongHashSet;
import gnu.trove.TLongIntHashMap;
import gnu.trove.TLongIntIterator;
import gnu.trove.TLongIterator;
import gnu.trove.TLongLongHashMap;
import gnu.trove.TLongLongIterator;
import gnu.trove.TLongObjectHashMap;
import gnu.trove.TLongObjectIterator;
import gnu.trove.TLongShortHashMap;
import gnu.trove.TLongShortIterator;
import gnu.trove.TObjectByteHashMap;
import gnu.trove.TObjectByteIterator;
import gnu.trove.TObjectDoubleHashMap;
import gnu.trove.TObjectDoubleIterator;
import gnu.trove.TObjectFloatHashMap;
import gnu.trove.TObjectFloatIterator;
import gnu.trove.TObjectIntHashMap;
import gnu.trove.TObjectIntIterator;
import gnu.trove.TObjectLongHashMap;
import gnu.trove.TObjectLongIterator;
import gnu.trove.TObjectShortHashMap;
import gnu.trove.TObjectShortIterator;
import gnu.trove.TShortArrayList;
import gnu.trove.TShortByteHashMap;
import gnu.trove.TShortByteIterator;
import gnu.trove.TShortDoubleHashMap;
import gnu.trove.TShortDoubleIterator;
import gnu.trove.TShortFloatHashMap;
import gnu.trove.TShortFloatIterator;
import gnu.trove.TShortHashSet;
import gnu.trove.TShortIntHashMap;
import gnu.trove.TShortIntIterator;
import gnu.trove.TShortIterator;
import gnu.trove.TShortLongHashMap;
import gnu.trove.TShortLongIterator;
import gnu.trove.TShortObjectHashMap;
import gnu.trove.TShortObjectIterator;
import gnu.trove.TShortShortHashMap;
import gnu.trove.TShortShortIterator;
import ioBase.SerializationDataInput;
import ioBase.SerializationDataOutput;
import ioBase.SerializationException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import org.jetbrains.annotations.NotNull;
import tools.reflection.objectsFactory.c;

public final class b {
    @NotNull
    public static final Class<?>[] a = new Class[]{TShortShortHashMap.class, TShortIntHashMap.class, TShortDoubleHashMap.class, TShortFloatHashMap.class, TShortLongHashMap.class, TShortObjectHashMap.class, TShortByteHashMap.class, TIntShortHashMap.class, TIntIntHashMap.class, TIntDoubleHashMap.class, TIntFloatHashMap.class, TIntLongHashMap.class, TIntObjectHashMap.class, TIntByteHashMap.class, TDoubleShortHashMap.class, TDoubleIntHashMap.class, TDoubleDoubleHashMap.class, TDoubleFloatHashMap.class, TDoubleLongHashMap.class, TDoubleObjectHashMap.class, TDoubleByteHashMap.class, TFloatShortHashMap.class, TFloatIntHashMap.class, TFloatDoubleHashMap.class, TFloatFloatHashMap.class, TFloatLongHashMap.class, TFloatObjectHashMap.class, TFloatByteHashMap.class, TLongShortHashMap.class, TLongIntHashMap.class, TLongDoubleHashMap.class, TLongFloatHashMap.class, TLongLongHashMap.class, TLongObjectHashMap.class, TLongByteHashMap.class, TObjectShortHashMap.class, TObjectIntHashMap.class, TObjectDoubleHashMap.class, TObjectFloatHashMap.class, TObjectLongHashMap.class, THashMap.class, TObjectByteHashMap.class, TByteShortHashMap.class, TByteIntHashMap.class, TByteDoubleHashMap.class, TByteFloatHashMap.class, TByteLongHashMap.class, TByteObjectHashMap.class, TByteByteHashMap.class, TShortHashSet.class, TIntHashSet.class, TDoubleHashSet.class, TFloatHashSet.class, TLongHashSet.class, THashSet.class, TByteHashSet.class, TShortArrayList.class, TIntArrayList.class, TDoubleArrayList.class, TFloatArrayList.class, TLongArrayList.class, TByteArrayList.class, ArrayList.class, ArrayDeque.class, LinkedList.class, HashSet.class, LinkedHashSet.class, TreeSet.class, HashMap.class, LinkedHashMap.class, TreeMap.class, IdentityHashMap.class};
    @NotNull
    public static final THashMap<Class<?>, c> b = new THashMap(IdentityObjectHashingStrategy.instance());

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TShortShortHashMap tShortShortHashMap) throws SerializationException {
        int n2 = tShortShortHashMap.size();
        serializationDataOutput.writeInt(n2);
        TShortShortIterator tShortShortIterator = tShortShortHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tShortShortIterator.advance();
            serializationDataOutput.writeShort(tShortShortIterator.key());
            serializationDataOutput.writeShort(tShortShortIterator.value());
        }
    }

    @NotNull
    public static TShortShortHashMap a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TShortShortHashMap tShortShortHashMap = new TShortShortHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            short s2 = serializationDataInput.readShort();
            short s3 = serializationDataInput.readShort();
            tShortShortHashMap.put(s2, s3);
        }
        return tShortShortHashMap;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TShortIntHashMap tShortIntHashMap) throws SerializationException {
        int n2 = tShortIntHashMap.size();
        serializationDataOutput.writeInt(n2);
        TShortIntIterator tShortIntIterator = tShortIntHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tShortIntIterator.advance();
            serializationDataOutput.writeShort(tShortIntIterator.key());
            serializationDataOutput.writeInt(tShortIntIterator.value());
        }
    }

    @NotNull
    public static TShortIntHashMap b(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TShortIntHashMap tShortIntHashMap = new TShortIntHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            short s2 = serializationDataInput.readShort();
            int n4 = serializationDataInput.readInt();
            tShortIntHashMap.put(s2, n4);
        }
        return tShortIntHashMap;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TShortDoubleHashMap tShortDoubleHashMap) throws SerializationException {
        int n2 = tShortDoubleHashMap.size();
        serializationDataOutput.writeInt(n2);
        TShortDoubleIterator tShortDoubleIterator = tShortDoubleHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tShortDoubleIterator.advance();
            serializationDataOutput.writeShort(tShortDoubleIterator.key());
            serializationDataOutput.writeDouble(tShortDoubleIterator.value());
        }
    }

    @NotNull
    public static TShortDoubleHashMap c(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TShortDoubleHashMap tShortDoubleHashMap = new TShortDoubleHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            short s2 = serializationDataInput.readShort();
            double d2 = serializationDataInput.readDouble();
            tShortDoubleHashMap.put(s2, d2);
        }
        return tShortDoubleHashMap;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TShortFloatHashMap tShortFloatHashMap) throws SerializationException {
        int n2 = tShortFloatHashMap.size();
        serializationDataOutput.writeInt(n2);
        TShortFloatIterator tShortFloatIterator = tShortFloatHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tShortFloatIterator.advance();
            serializationDataOutput.writeShort(tShortFloatIterator.key());
            serializationDataOutput.writeFloat(tShortFloatIterator.value(), -1);
        }
    }

    @NotNull
    public static TShortFloatHashMap d(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TShortFloatHashMap tShortFloatHashMap = new TShortFloatHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            short s2 = serializationDataInput.readShort();
            float f2 = serializationDataInput.readFloat(-1);
            tShortFloatHashMap.put(s2, f2);
        }
        return tShortFloatHashMap;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TShortLongHashMap tShortLongHashMap) throws SerializationException {
        int n2 = tShortLongHashMap.size();
        serializationDataOutput.writeInt(n2);
        TShortLongIterator tShortLongIterator = tShortLongHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tShortLongIterator.advance();
            serializationDataOutput.writeShort(tShortLongIterator.key());
            serializationDataOutput.writeLong(tShortLongIterator.value());
        }
    }

    @NotNull
    public static TShortLongHashMap e(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TShortLongHashMap tShortLongHashMap = new TShortLongHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            short s2 = serializationDataInput.readShort();
            long l2 = serializationDataInput.readLong();
            tShortLongHashMap.put(s2, l2);
        }
        return tShortLongHashMap;
    }

    public static <T2> void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TShortObjectHashMap<T2> tShortObjectHashMap) throws SerializationException {
        int n2 = tShortObjectHashMap.size();
        serializationDataOutput.writeInt(n2);
        TShortObjectIterator<T2> tShortObjectIterator = tShortObjectHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tShortObjectIterator.advance();
            serializationDataOutput.writeShort(tShortObjectIterator.key());
            serializationDataOutput.writeObjectPolymorphic(tShortObjectIterator.value());
        }
    }

    @NotNull
    public static <T2> TShortObjectHashMap<T2> f(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TShortObjectHashMap tShortObjectHashMap = new TShortObjectHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            short s2 = serializationDataInput.readShort();
            Object t2 = serializationDataInput.readObjectPolymorphic();
            tShortObjectHashMap.put(s2, t2);
        }
        return tShortObjectHashMap;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TShortByteHashMap tShortByteHashMap) throws SerializationException {
        int n2 = tShortByteHashMap.size();
        serializationDataOutput.writeInt(n2);
        TShortByteIterator tShortByteIterator = tShortByteHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tShortByteIterator.advance();
            serializationDataOutput.writeShort(tShortByteIterator.key());
            serializationDataOutput.writeByte(tShortByteIterator.value());
        }
    }

    @NotNull
    public static TShortByteHashMap g(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TShortByteHashMap tShortByteHashMap = new TShortByteHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            short s2 = serializationDataInput.readShort();
            byte by = serializationDataInput.readByte();
            tShortByteHashMap.put(s2, by);
        }
        return tShortByteHashMap;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TIntShortHashMap tIntShortHashMap) throws SerializationException {
        int n2 = tIntShortHashMap.size();
        serializationDataOutput.writeInt(n2);
        TIntShortIterator tIntShortIterator = tIntShortHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tIntShortIterator.advance();
            serializationDataOutput.writeInt(tIntShortIterator.key());
            serializationDataOutput.writeShort(tIntShortIterator.value());
        }
    }

    @NotNull
    public static TIntShortHashMap h(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TIntShortHashMap tIntShortHashMap = new TIntShortHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            int n4 = serializationDataInput.readInt();
            short s2 = serializationDataInput.readShort();
            tIntShortHashMap.put(n4, s2);
        }
        return tIntShortHashMap;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TIntIntHashMap tIntIntHashMap) throws SerializationException {
        int n2 = tIntIntHashMap.size();
        serializationDataOutput.writeInt(n2);
        TIntIntIterator tIntIntIterator = tIntIntHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tIntIntIterator.advance();
            serializationDataOutput.writeInt(tIntIntIterator.key());
            serializationDataOutput.writeInt(tIntIntIterator.value());
        }
    }

    @NotNull
    public static TIntIntHashMap i(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TIntIntHashMap tIntIntHashMap = new TIntIntHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            int n4 = serializationDataInput.readInt();
            int n5 = serializationDataInput.readInt();
            tIntIntHashMap.put(n4, n5);
        }
        return tIntIntHashMap;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TIntDoubleHashMap tIntDoubleHashMap) throws SerializationException {
        int n2 = tIntDoubleHashMap.size();
        serializationDataOutput.writeInt(n2);
        TIntDoubleIterator tIntDoubleIterator = tIntDoubleHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tIntDoubleIterator.advance();
            serializationDataOutput.writeInt(tIntDoubleIterator.key());
            serializationDataOutput.writeDouble(tIntDoubleIterator.value());
        }
    }

    @NotNull
    public static TIntDoubleHashMap j(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TIntDoubleHashMap tIntDoubleHashMap = new TIntDoubleHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            int n4 = serializationDataInput.readInt();
            double d2 = serializationDataInput.readDouble();
            tIntDoubleHashMap.put(n4, d2);
        }
        return tIntDoubleHashMap;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TIntFloatHashMap tIntFloatHashMap) throws SerializationException {
        int n2 = tIntFloatHashMap.size();
        serializationDataOutput.writeInt(n2);
        TIntFloatIterator tIntFloatIterator = tIntFloatHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tIntFloatIterator.advance();
            serializationDataOutput.writeInt(tIntFloatIterator.key());
            serializationDataOutput.writeFloat(tIntFloatIterator.value(), -1);
        }
    }

    @NotNull
    public static TIntFloatHashMap k(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TIntFloatHashMap tIntFloatHashMap = new TIntFloatHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            int n4 = serializationDataInput.readInt();
            float f2 = serializationDataInput.readFloat(-1);
            tIntFloatHashMap.put(n4, f2);
        }
        return tIntFloatHashMap;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TIntLongHashMap tIntLongHashMap) throws SerializationException {
        int n2 = tIntLongHashMap.size();
        serializationDataOutput.writeInt(n2);
        TIntLongIterator tIntLongIterator = tIntLongHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tIntLongIterator.advance();
            serializationDataOutput.writeInt(tIntLongIterator.key());
            serializationDataOutput.writeLong(tIntLongIterator.value());
        }
    }

    @NotNull
    public static TIntLongHashMap l(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TIntLongHashMap tIntLongHashMap = new TIntLongHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            int n4 = serializationDataInput.readInt();
            long l2 = serializationDataInput.readLong();
            tIntLongHashMap.put(n4, l2);
        }
        return tIntLongHashMap;
    }

    public static <T2> void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TIntObjectHashMap<T2> tIntObjectHashMap) throws SerializationException {
        int n2 = tIntObjectHashMap.size();
        serializationDataOutput.writeInt(n2);
        TIntObjectIterator<T2> tIntObjectIterator = tIntObjectHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tIntObjectIterator.advance();
            serializationDataOutput.writeInt(tIntObjectIterator.key());
            serializationDataOutput.writeObjectPolymorphic(tIntObjectIterator.value());
        }
    }

    @NotNull
    public static <T2> TIntObjectHashMap<T2> m(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TIntObjectHashMap tIntObjectHashMap = new TIntObjectHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            int n4 = serializationDataInput.readInt();
            Object t2 = serializationDataInput.readObjectPolymorphic();
            tIntObjectHashMap.put(n4, t2);
        }
        return tIntObjectHashMap;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TIntByteHashMap tIntByteHashMap) throws SerializationException {
        int n2 = tIntByteHashMap.size();
        serializationDataOutput.writeInt(n2);
        TIntByteIterator tIntByteIterator = tIntByteHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tIntByteIterator.advance();
            serializationDataOutput.writeInt(tIntByteIterator.key());
            serializationDataOutput.writeByte(tIntByteIterator.value());
        }
    }

    @NotNull
    public static TIntByteHashMap n(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TIntByteHashMap tIntByteHashMap = new TIntByteHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            int n4 = serializationDataInput.readInt();
            byte by = serializationDataInput.readByte();
            tIntByteHashMap.put(n4, by);
        }
        return tIntByteHashMap;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TDoubleShortHashMap tDoubleShortHashMap) throws SerializationException {
        int n2 = tDoubleShortHashMap.size();
        serializationDataOutput.writeInt(n2);
        TDoubleShortIterator tDoubleShortIterator = tDoubleShortHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tDoubleShortIterator.advance();
            serializationDataOutput.writeDouble(tDoubleShortIterator.key());
            serializationDataOutput.writeShort(tDoubleShortIterator.value());
        }
    }

    @NotNull
    public static TDoubleShortHashMap o(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TDoubleShortHashMap tDoubleShortHashMap = new TDoubleShortHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            double d2 = serializationDataInput.readDouble();
            short s2 = serializationDataInput.readShort();
            tDoubleShortHashMap.put(d2, s2);
        }
        return tDoubleShortHashMap;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TDoubleIntHashMap tDoubleIntHashMap) throws SerializationException {
        int n2 = tDoubleIntHashMap.size();
        serializationDataOutput.writeInt(n2);
        TDoubleIntIterator tDoubleIntIterator = tDoubleIntHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tDoubleIntIterator.advance();
            serializationDataOutput.writeDouble(tDoubleIntIterator.key());
            serializationDataOutput.writeInt(tDoubleIntIterator.value());
        }
    }

    @NotNull
    public static TDoubleIntHashMap p(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TDoubleIntHashMap tDoubleIntHashMap = new TDoubleIntHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            double d2 = serializationDataInput.readDouble();
            int n4 = serializationDataInput.readInt();
            tDoubleIntHashMap.put(d2, n4);
        }
        return tDoubleIntHashMap;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TDoubleDoubleHashMap tDoubleDoubleHashMap) throws SerializationException {
        int n2 = tDoubleDoubleHashMap.size();
        serializationDataOutput.writeInt(n2);
        TDoubleDoubleIterator tDoubleDoubleIterator = tDoubleDoubleHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tDoubleDoubleIterator.advance();
            serializationDataOutput.writeDouble(tDoubleDoubleIterator.key());
            serializationDataOutput.writeDouble(tDoubleDoubleIterator.value());
        }
    }

    @NotNull
    public static TDoubleDoubleHashMap q(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TDoubleDoubleHashMap tDoubleDoubleHashMap = new TDoubleDoubleHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            double d2 = serializationDataInput.readDouble();
            double d3 = serializationDataInput.readDouble();
            tDoubleDoubleHashMap.put(d2, d3);
        }
        return tDoubleDoubleHashMap;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TDoubleFloatHashMap tDoubleFloatHashMap) throws SerializationException {
        int n2 = tDoubleFloatHashMap.size();
        serializationDataOutput.writeInt(n2);
        TDoubleFloatIterator tDoubleFloatIterator = tDoubleFloatHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tDoubleFloatIterator.advance();
            serializationDataOutput.writeDouble(tDoubleFloatIterator.key());
            serializationDataOutput.writeFloat(tDoubleFloatIterator.value(), -1);
        }
    }

    @NotNull
    public static TDoubleFloatHashMap r(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TDoubleFloatHashMap tDoubleFloatHashMap = new TDoubleFloatHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            double d2 = serializationDataInput.readDouble();
            float f2 = serializationDataInput.readFloat(-1);
            tDoubleFloatHashMap.put(d2, f2);
        }
        return tDoubleFloatHashMap;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TDoubleLongHashMap tDoubleLongHashMap) throws SerializationException {
        int n2 = tDoubleLongHashMap.size();
        serializationDataOutput.writeInt(n2);
        TDoubleLongIterator tDoubleLongIterator = tDoubleLongHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tDoubleLongIterator.advance();
            serializationDataOutput.writeDouble(tDoubleLongIterator.key());
            serializationDataOutput.writeLong(tDoubleLongIterator.value());
        }
    }

    @NotNull
    public static TDoubleLongHashMap s(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TDoubleLongHashMap tDoubleLongHashMap = new TDoubleLongHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            double d2 = serializationDataInput.readDouble();
            long l2 = serializationDataInput.readLong();
            tDoubleLongHashMap.put(d2, l2);
        }
        return tDoubleLongHashMap;
    }

    public static <T2> void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TDoubleObjectHashMap<T2> tDoubleObjectHashMap) throws SerializationException {
        int n2 = tDoubleObjectHashMap.size();
        serializationDataOutput.writeInt(n2);
        TDoubleObjectIterator<T2> tDoubleObjectIterator = tDoubleObjectHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tDoubleObjectIterator.advance();
            serializationDataOutput.writeDouble(tDoubleObjectIterator.key());
            serializationDataOutput.writeObjectPolymorphic(tDoubleObjectIterator.value());
        }
    }

    @NotNull
    public static <T2> TDoubleObjectHashMap<T2> t(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TDoubleObjectHashMap tDoubleObjectHashMap = new TDoubleObjectHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            double d2 = serializationDataInput.readDouble();
            Object t2 = serializationDataInput.readObjectPolymorphic();
            tDoubleObjectHashMap.put(d2, t2);
        }
        return tDoubleObjectHashMap;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TDoubleByteHashMap tDoubleByteHashMap) throws SerializationException {
        int n2 = tDoubleByteHashMap.size();
        serializationDataOutput.writeInt(n2);
        TDoubleByteIterator tDoubleByteIterator = tDoubleByteHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tDoubleByteIterator.advance();
            serializationDataOutput.writeDouble(tDoubleByteIterator.key());
            serializationDataOutput.writeByte(tDoubleByteIterator.value());
        }
    }

    @NotNull
    public static TDoubleByteHashMap u(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TDoubleByteHashMap tDoubleByteHashMap = new TDoubleByteHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            double d2 = serializationDataInput.readDouble();
            byte by = serializationDataInput.readByte();
            tDoubleByteHashMap.put(d2, by);
        }
        return tDoubleByteHashMap;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TFloatShortHashMap tFloatShortHashMap) throws SerializationException {
        int n2 = tFloatShortHashMap.size();
        serializationDataOutput.writeInt(n2);
        TFloatShortIterator tFloatShortIterator = tFloatShortHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tFloatShortIterator.advance();
            serializationDataOutput.writeFloat(tFloatShortIterator.key(), -1);
            serializationDataOutput.writeShort(tFloatShortIterator.value());
        }
    }

    @NotNull
    public static TFloatShortHashMap v(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TFloatShortHashMap tFloatShortHashMap = new TFloatShortHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            float f2 = serializationDataInput.readFloat(-1);
            short s2 = serializationDataInput.readShort();
            tFloatShortHashMap.put(f2, s2);
        }
        return tFloatShortHashMap;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TFloatIntHashMap tFloatIntHashMap) throws SerializationException {
        int n2 = tFloatIntHashMap.size();
        serializationDataOutput.writeInt(n2);
        TFloatIntIterator tFloatIntIterator = tFloatIntHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tFloatIntIterator.advance();
            serializationDataOutput.writeFloat(tFloatIntIterator.key(), -1);
            serializationDataOutput.writeInt(tFloatIntIterator.value());
        }
    }

    @NotNull
    public static TFloatIntHashMap w(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TFloatIntHashMap tFloatIntHashMap = new TFloatIntHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            float f2 = serializationDataInput.readFloat(-1);
            int n4 = serializationDataInput.readInt();
            tFloatIntHashMap.put(f2, n4);
        }
        return tFloatIntHashMap;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TFloatDoubleHashMap tFloatDoubleHashMap) throws SerializationException {
        int n2 = tFloatDoubleHashMap.size();
        serializationDataOutput.writeInt(n2);
        TFloatDoubleIterator tFloatDoubleIterator = tFloatDoubleHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tFloatDoubleIterator.advance();
            serializationDataOutput.writeFloat(tFloatDoubleIterator.key(), -1);
            serializationDataOutput.writeDouble(tFloatDoubleIterator.value());
        }
    }

    @NotNull
    public static TFloatDoubleHashMap x(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TFloatDoubleHashMap tFloatDoubleHashMap = new TFloatDoubleHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            float f2 = serializationDataInput.readFloat(-1);
            double d2 = serializationDataInput.readDouble();
            tFloatDoubleHashMap.put(f2, d2);
        }
        return tFloatDoubleHashMap;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TFloatFloatHashMap tFloatFloatHashMap) throws SerializationException {
        int n2 = tFloatFloatHashMap.size();
        serializationDataOutput.writeInt(n2);
        TFloatFloatIterator tFloatFloatIterator = tFloatFloatHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tFloatFloatIterator.advance();
            serializationDataOutput.writeFloat(tFloatFloatIterator.key(), -1);
            serializationDataOutput.writeFloat(tFloatFloatIterator.value(), -1);
        }
    }

    @NotNull
    public static TFloatFloatHashMap y(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TFloatFloatHashMap tFloatFloatHashMap = new TFloatFloatHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            float f2 = serializationDataInput.readFloat(-1);
            float f3 = serializationDataInput.readFloat(-1);
            tFloatFloatHashMap.put(f2, f3);
        }
        return tFloatFloatHashMap;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TFloatLongHashMap tFloatLongHashMap) throws SerializationException {
        int n2 = tFloatLongHashMap.size();
        serializationDataOutput.writeInt(n2);
        TFloatLongIterator tFloatLongIterator = tFloatLongHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tFloatLongIterator.advance();
            serializationDataOutput.writeFloat(tFloatLongIterator.key(), -1);
            serializationDataOutput.writeLong(tFloatLongIterator.value());
        }
    }

    @NotNull
    public static TFloatLongHashMap z(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TFloatLongHashMap tFloatLongHashMap = new TFloatLongHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            float f2 = serializationDataInput.readFloat(-1);
            long l2 = serializationDataInput.readLong();
            tFloatLongHashMap.put(f2, l2);
        }
        return tFloatLongHashMap;
    }

    public static <T2> void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TFloatObjectHashMap<T2> tFloatObjectHashMap) throws SerializationException {
        int n2 = tFloatObjectHashMap.size();
        serializationDataOutput.writeInt(n2);
        TFloatObjectIterator<T2> tFloatObjectIterator = tFloatObjectHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tFloatObjectIterator.advance();
            serializationDataOutput.writeFloat(tFloatObjectIterator.key(), -1);
            serializationDataOutput.writeObjectPolymorphic(tFloatObjectIterator.value());
        }
    }

    @NotNull
    public static <T2> TFloatObjectHashMap<T2> A(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TFloatObjectHashMap tFloatObjectHashMap = new TFloatObjectHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            float f2 = serializationDataInput.readFloat(-1);
            Object t2 = serializationDataInput.readObjectPolymorphic();
            tFloatObjectHashMap.put(f2, t2);
        }
        return tFloatObjectHashMap;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TFloatByteHashMap tFloatByteHashMap) throws SerializationException {
        int n2 = tFloatByteHashMap.size();
        serializationDataOutput.writeInt(n2);
        TFloatByteIterator tFloatByteIterator = tFloatByteHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tFloatByteIterator.advance();
            serializationDataOutput.writeFloat(tFloatByteIterator.key(), -1);
            serializationDataOutput.writeByte(tFloatByteIterator.value());
        }
    }

    @NotNull
    public static TFloatByteHashMap B(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TFloatByteHashMap tFloatByteHashMap = new TFloatByteHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            float f2 = serializationDataInput.readFloat(-1);
            byte by = serializationDataInput.readByte();
            tFloatByteHashMap.put(f2, by);
        }
        return tFloatByteHashMap;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TLongShortHashMap tLongShortHashMap) throws SerializationException {
        int n2 = tLongShortHashMap.size();
        serializationDataOutput.writeInt(n2);
        TLongShortIterator tLongShortIterator = tLongShortHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tLongShortIterator.advance();
            serializationDataOutput.writeLong(tLongShortIterator.key());
            serializationDataOutput.writeShort(tLongShortIterator.value());
        }
    }

    @NotNull
    public static TLongShortHashMap C(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TLongShortHashMap tLongShortHashMap = new TLongShortHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            long l2 = serializationDataInput.readLong();
            short s2 = serializationDataInput.readShort();
            tLongShortHashMap.put(l2, s2);
        }
        return tLongShortHashMap;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TLongIntHashMap tLongIntHashMap) throws SerializationException {
        int n2 = tLongIntHashMap.size();
        serializationDataOutput.writeInt(n2);
        TLongIntIterator tLongIntIterator = tLongIntHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tLongIntIterator.advance();
            serializationDataOutput.writeLong(tLongIntIterator.key());
            serializationDataOutput.writeInt(tLongIntIterator.value());
        }
    }

    @NotNull
    public static TLongIntHashMap D(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TLongIntHashMap tLongIntHashMap = new TLongIntHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            long l2 = serializationDataInput.readLong();
            int n4 = serializationDataInput.readInt();
            tLongIntHashMap.put(l2, n4);
        }
        return tLongIntHashMap;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TLongDoubleHashMap tLongDoubleHashMap) throws SerializationException {
        int n2 = tLongDoubleHashMap.size();
        serializationDataOutput.writeInt(n2);
        TLongDoubleIterator tLongDoubleIterator = tLongDoubleHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tLongDoubleIterator.advance();
            serializationDataOutput.writeLong(tLongDoubleIterator.key());
            serializationDataOutput.writeDouble(tLongDoubleIterator.value());
        }
    }

    @NotNull
    public static TLongDoubleHashMap E(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TLongDoubleHashMap tLongDoubleHashMap = new TLongDoubleHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            long l2 = serializationDataInput.readLong();
            double d2 = serializationDataInput.readDouble();
            tLongDoubleHashMap.put(l2, d2);
        }
        return tLongDoubleHashMap;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TLongFloatHashMap tLongFloatHashMap) throws SerializationException {
        int n2 = tLongFloatHashMap.size();
        serializationDataOutput.writeInt(n2);
        TLongFloatIterator tLongFloatIterator = tLongFloatHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tLongFloatIterator.advance();
            serializationDataOutput.writeLong(tLongFloatIterator.key());
            serializationDataOutput.writeFloat(tLongFloatIterator.value(), -1);
        }
    }

    @NotNull
    public static TLongFloatHashMap F(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TLongFloatHashMap tLongFloatHashMap = new TLongFloatHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            long l2 = serializationDataInput.readLong();
            float f2 = serializationDataInput.readFloat(-1);
            tLongFloatHashMap.put(l2, f2);
        }
        return tLongFloatHashMap;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TLongLongHashMap tLongLongHashMap) throws SerializationException {
        int n2 = tLongLongHashMap.size();
        serializationDataOutput.writeInt(n2);
        TLongLongIterator tLongLongIterator = tLongLongHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tLongLongIterator.advance();
            serializationDataOutput.writeLong(tLongLongIterator.key());
            serializationDataOutput.writeLong(tLongLongIterator.value());
        }
    }

    @NotNull
    public static TLongLongHashMap G(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TLongLongHashMap tLongLongHashMap = new TLongLongHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            long l2 = serializationDataInput.readLong();
            long l3 = serializationDataInput.readLong();
            tLongLongHashMap.put(l2, l3);
        }
        return tLongLongHashMap;
    }

    public static <T2> void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TLongObjectHashMap<T2> tLongObjectHashMap) throws SerializationException {
        int n2 = tLongObjectHashMap.size();
        serializationDataOutput.writeInt(n2);
        TLongObjectIterator<T2> tLongObjectIterator = tLongObjectHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tLongObjectIterator.advance();
            serializationDataOutput.writeLong(tLongObjectIterator.key());
            serializationDataOutput.writeObjectPolymorphic(tLongObjectIterator.value());
        }
    }

    @NotNull
    public static <T2> TLongObjectHashMap<T2> H(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TLongObjectHashMap tLongObjectHashMap = new TLongObjectHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            long l2 = serializationDataInput.readLong();
            Object t2 = serializationDataInput.readObjectPolymorphic();
            tLongObjectHashMap.put(l2, t2);
        }
        return tLongObjectHashMap;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TLongByteHashMap tLongByteHashMap) throws SerializationException {
        int n2 = tLongByteHashMap.size();
        serializationDataOutput.writeInt(n2);
        TLongByteIterator tLongByteIterator = tLongByteHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tLongByteIterator.advance();
            serializationDataOutput.writeLong(tLongByteIterator.key());
            serializationDataOutput.writeByte(tLongByteIterator.value());
        }
    }

    @NotNull
    public static TLongByteHashMap I(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TLongByteHashMap tLongByteHashMap = new TLongByteHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            long l2 = serializationDataInput.readLong();
            byte by = serializationDataInput.readByte();
            tLongByteHashMap.put(l2, by);
        }
        return tLongByteHashMap;
    }

    public static <T1> void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TObjectShortHashMap<T1> tObjectShortHashMap) throws SerializationException {
        int n2 = tObjectShortHashMap.size();
        serializationDataOutput.writeInt(n2);
        TObjectShortIterator<T1> tObjectShortIterator = tObjectShortHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tObjectShortIterator.advance();
            serializationDataOutput.writeObjectPolymorphic(tObjectShortIterator.key());
            serializationDataOutput.writeShort(tObjectShortIterator.value());
        }
    }

    @NotNull
    public static <T1> TObjectShortHashMap<T1> J(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TObjectShortHashMap tObjectShortHashMap = new TObjectShortHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            Object t2 = serializationDataInput.readObjectPolymorphic();
            short s2 = serializationDataInput.readShort();
            tObjectShortHashMap.put(t2, s2);
        }
        return tObjectShortHashMap;
    }

    public static <T1> void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TObjectIntHashMap<T1> tObjectIntHashMap) throws SerializationException {
        int n2 = tObjectIntHashMap.size();
        serializationDataOutput.writeInt(n2);
        TObjectIntIterator<T1> tObjectIntIterator = tObjectIntHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tObjectIntIterator.advance();
            serializationDataOutput.writeObjectPolymorphic(tObjectIntIterator.key());
            serializationDataOutput.writeInt(tObjectIntIterator.value());
        }
    }

    @NotNull
    public static <T1> TObjectIntHashMap<T1> K(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TObjectIntHashMap tObjectIntHashMap = new TObjectIntHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            Object t2 = serializationDataInput.readObjectPolymorphic();
            int n4 = serializationDataInput.readInt();
            tObjectIntHashMap.put(t2, n4);
        }
        return tObjectIntHashMap;
    }

    public static <T1> void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TObjectDoubleHashMap<T1> tObjectDoubleHashMap) throws SerializationException {
        int n2 = tObjectDoubleHashMap.size();
        serializationDataOutput.writeInt(n2);
        TObjectDoubleIterator<T1> tObjectDoubleIterator = tObjectDoubleHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tObjectDoubleIterator.advance();
            serializationDataOutput.writeObjectPolymorphic(tObjectDoubleIterator.key());
            serializationDataOutput.writeDouble(tObjectDoubleIterator.value());
        }
    }

    @NotNull
    public static <T1> TObjectDoubleHashMap<T1> L(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TObjectDoubleHashMap tObjectDoubleHashMap = new TObjectDoubleHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            Object t2 = serializationDataInput.readObjectPolymorphic();
            double d2 = serializationDataInput.readDouble();
            tObjectDoubleHashMap.put(t2, d2);
        }
        return tObjectDoubleHashMap;
    }

    public static <T1> void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TObjectFloatHashMap<T1> tObjectFloatHashMap) throws SerializationException {
        int n2 = tObjectFloatHashMap.size();
        serializationDataOutput.writeInt(n2);
        TObjectFloatIterator<T1> tObjectFloatIterator = tObjectFloatHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tObjectFloatIterator.advance();
            serializationDataOutput.writeObjectPolymorphic(tObjectFloatIterator.key());
            serializationDataOutput.writeFloat(tObjectFloatIterator.value(), -1);
        }
    }

    @NotNull
    public static <T1> TObjectFloatHashMap<T1> M(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TObjectFloatHashMap tObjectFloatHashMap = new TObjectFloatHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            Object t2 = serializationDataInput.readObjectPolymorphic();
            float f2 = serializationDataInput.readFloat(-1);
            tObjectFloatHashMap.put(t2, f2);
        }
        return tObjectFloatHashMap;
    }

    public static <T1> void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TObjectLongHashMap<T1> tObjectLongHashMap) throws SerializationException {
        int n2 = tObjectLongHashMap.size();
        serializationDataOutput.writeInt(n2);
        TObjectLongIterator<T1> tObjectLongIterator = tObjectLongHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tObjectLongIterator.advance();
            serializationDataOutput.writeObjectPolymorphic(tObjectLongIterator.key());
            serializationDataOutput.writeLong(tObjectLongIterator.value());
        }
    }

    @NotNull
    public static <T1> TObjectLongHashMap<T1> N(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TObjectLongHashMap tObjectLongHashMap = new TObjectLongHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            Object t2 = serializationDataInput.readObjectPolymorphic();
            long l2 = serializationDataInput.readLong();
            tObjectLongHashMap.put(t2, l2);
        }
        return tObjectLongHashMap;
    }

    public static <T1, T2> void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull THashMap<T1, T2> tHashMap) throws SerializationException {
        int n2 = tHashMap.size();
        serializationDataOutput.writeInt(n2);
        Iterator<Map.Entry<T1, T2>> iterator = tHashMap.entrySet().iterator();
        int n3 = n2;
        while (n3-- > 0) {
            Map.Entry<T1, T2> entry = iterator.next();
            serializationDataOutput.writeObjectPolymorphic(entry.getKey());
            serializationDataOutput.writeObjectPolymorphic(entry.getValue());
        }
    }

    @NotNull
    public static <T1, T2> THashMap<T1, T2> O(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        THashMap tHashMap = new THashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            Object t2 = serializationDataInput.readObjectPolymorphic();
            Object t3 = serializationDataInput.readObjectPolymorphic();
            tHashMap.put(t2, t3);
        }
        return tHashMap;
    }

    public static <T1> void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TObjectByteHashMap<T1> tObjectByteHashMap) throws SerializationException {
        int n2 = tObjectByteHashMap.size();
        serializationDataOutput.writeInt(n2);
        TObjectByteIterator<T1> tObjectByteIterator = tObjectByteHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tObjectByteIterator.advance();
            serializationDataOutput.writeObjectPolymorphic(tObjectByteIterator.key());
            serializationDataOutput.writeByte(tObjectByteIterator.value());
        }
    }

    @NotNull
    public static <T1> TObjectByteHashMap<T1> P(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TObjectByteHashMap tObjectByteHashMap = new TObjectByteHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            Object t2 = serializationDataInput.readObjectPolymorphic();
            byte by = serializationDataInput.readByte();
            tObjectByteHashMap.put(t2, by);
        }
        return tObjectByteHashMap;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TByteShortHashMap tByteShortHashMap) throws SerializationException {
        int n2 = tByteShortHashMap.size();
        serializationDataOutput.writeInt(n2);
        TByteShortIterator tByteShortIterator = tByteShortHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tByteShortIterator.advance();
            serializationDataOutput.writeByte(tByteShortIterator.key());
            serializationDataOutput.writeShort(tByteShortIterator.value());
        }
    }

    @NotNull
    public static TByteShortHashMap Q(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TByteShortHashMap tByteShortHashMap = new TByteShortHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            byte by = serializationDataInput.readByte();
            short s2 = serializationDataInput.readShort();
            tByteShortHashMap.put(by, s2);
        }
        return tByteShortHashMap;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TByteIntHashMap tByteIntHashMap) throws SerializationException {
        int n2 = tByteIntHashMap.size();
        serializationDataOutput.writeInt(n2);
        TByteIntIterator tByteIntIterator = tByteIntHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tByteIntIterator.advance();
            serializationDataOutput.writeByte(tByteIntIterator.key());
            serializationDataOutput.writeInt(tByteIntIterator.value());
        }
    }

    @NotNull
    public static TByteIntHashMap R(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TByteIntHashMap tByteIntHashMap = new TByteIntHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            byte by = serializationDataInput.readByte();
            int n4 = serializationDataInput.readInt();
            tByteIntHashMap.put(by, n4);
        }
        return tByteIntHashMap;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TByteDoubleHashMap tByteDoubleHashMap) throws SerializationException {
        int n2 = tByteDoubleHashMap.size();
        serializationDataOutput.writeInt(n2);
        TByteDoubleIterator tByteDoubleIterator = tByteDoubleHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tByteDoubleIterator.advance();
            serializationDataOutput.writeByte(tByteDoubleIterator.key());
            serializationDataOutput.writeDouble(tByteDoubleIterator.value());
        }
    }

    @NotNull
    public static TByteDoubleHashMap S(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TByteDoubleHashMap tByteDoubleHashMap = new TByteDoubleHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            byte by = serializationDataInput.readByte();
            double d2 = serializationDataInput.readDouble();
            tByteDoubleHashMap.put(by, d2);
        }
        return tByteDoubleHashMap;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TByteFloatHashMap tByteFloatHashMap) throws SerializationException {
        int n2 = tByteFloatHashMap.size();
        serializationDataOutput.writeInt(n2);
        TByteFloatIterator tByteFloatIterator = tByteFloatHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tByteFloatIterator.advance();
            serializationDataOutput.writeByte(tByteFloatIterator.key());
            serializationDataOutput.writeFloat(tByteFloatIterator.value(), -1);
        }
    }

    @NotNull
    public static TByteFloatHashMap T(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TByteFloatHashMap tByteFloatHashMap = new TByteFloatHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            byte by = serializationDataInput.readByte();
            float f2 = serializationDataInput.readFloat(-1);
            tByteFloatHashMap.put(by, f2);
        }
        return tByteFloatHashMap;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TByteLongHashMap tByteLongHashMap) throws SerializationException {
        int n2 = tByteLongHashMap.size();
        serializationDataOutput.writeInt(n2);
        TByteLongIterator tByteLongIterator = tByteLongHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tByteLongIterator.advance();
            serializationDataOutput.writeByte(tByteLongIterator.key());
            serializationDataOutput.writeLong(tByteLongIterator.value());
        }
    }

    @NotNull
    public static TByteLongHashMap U(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TByteLongHashMap tByteLongHashMap = new TByteLongHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            byte by = serializationDataInput.readByte();
            long l2 = serializationDataInput.readLong();
            tByteLongHashMap.put(by, l2);
        }
        return tByteLongHashMap;
    }

    public static <T2> void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TByteObjectHashMap<T2> tByteObjectHashMap) throws SerializationException {
        int n2 = tByteObjectHashMap.size();
        serializationDataOutput.writeInt(n2);
        TByteObjectIterator<T2> tByteObjectIterator = tByteObjectHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tByteObjectIterator.advance();
            serializationDataOutput.writeByte(tByteObjectIterator.key());
            serializationDataOutput.writeObjectPolymorphic(tByteObjectIterator.value());
        }
    }

    @NotNull
    public static <T2> TByteObjectHashMap<T2> V(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TByteObjectHashMap tByteObjectHashMap = new TByteObjectHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            byte by = serializationDataInput.readByte();
            Object t2 = serializationDataInput.readObjectPolymorphic();
            tByteObjectHashMap.put(by, t2);
        }
        return tByteObjectHashMap;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TByteByteHashMap tByteByteHashMap) throws SerializationException {
        int n2 = tByteByteHashMap.size();
        serializationDataOutput.writeInt(n2);
        TByteByteIterator tByteByteIterator = tByteByteHashMap.iterator();
        int n3 = n2;
        while (n3-- > 0) {
            tByteByteIterator.advance();
            serializationDataOutput.writeByte(tByteByteIterator.key());
            serializationDataOutput.writeByte(tByteByteIterator.value());
        }
    }

    @NotNull
    public static TByteByteHashMap W(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TByteByteHashMap tByteByteHashMap = new TByteByteHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            byte by = serializationDataInput.readByte();
            byte by2 = serializationDataInput.readByte();
            tByteByteHashMap.put(by, by2);
        }
        return tByteByteHashMap;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TShortHashSet tShortHashSet) throws SerializationException {
        int n2 = tShortHashSet.size();
        serializationDataOutput.writeInt(n2);
        TShortIterator tShortIterator = tShortHashSet.iterator();
        int n3 = tShortHashSet.size();
        while (n3-- > 0) {
            serializationDataOutput.writeShort(tShortIterator.next());
        }
    }

    @NotNull
    public static TShortHashSet X(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TShortHashSet tShortHashSet = new TShortHashSet(n2);
        int n3 = n2;
        while (n3-- > 0) {
            short s2 = serializationDataInput.readShort();
            tShortHashSet.add(s2);
        }
        return tShortHashSet;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TIntHashSet tIntHashSet) throws SerializationException {
        int n2 = tIntHashSet.size();
        serializationDataOutput.writeInt(n2);
        TIntIterator tIntIterator = tIntHashSet.iterator();
        int n3 = tIntHashSet.size();
        while (n3-- > 0) {
            serializationDataOutput.writeInt(tIntIterator.next());
        }
    }

    @NotNull
    public static TIntHashSet Y(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TIntHashSet tIntHashSet = new TIntHashSet(n2);
        int n3 = n2;
        while (n3-- > 0) {
            int n4 = serializationDataInput.readInt();
            tIntHashSet.add(n4);
        }
        return tIntHashSet;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TDoubleHashSet tDoubleHashSet) throws SerializationException {
        int n2 = tDoubleHashSet.size();
        serializationDataOutput.writeInt(n2);
        TDoubleIterator tDoubleIterator = tDoubleHashSet.iterator();
        int n3 = tDoubleHashSet.size();
        while (n3-- > 0) {
            serializationDataOutput.writeDouble(tDoubleIterator.next());
        }
    }

    @NotNull
    public static TDoubleHashSet Z(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TDoubleHashSet tDoubleHashSet = new TDoubleHashSet(n2);
        int n3 = n2;
        while (n3-- > 0) {
            double d2 = serializationDataInput.readDouble();
            tDoubleHashSet.add(d2);
        }
        return tDoubleHashSet;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TFloatHashSet tFloatHashSet) throws SerializationException {
        int n2 = tFloatHashSet.size();
        serializationDataOutput.writeInt(n2);
        TFloatIterator tFloatIterator = tFloatHashSet.iterator();
        int n3 = tFloatHashSet.size();
        while (n3-- > 0) {
            serializationDataOutput.writeFloat(tFloatIterator.next(), -1);
        }
    }

    @NotNull
    public static TFloatHashSet ab(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TFloatHashSet tFloatHashSet = new TFloatHashSet(n2);
        int n3 = n2;
        while (n3-- > 0) {
            float f2 = serializationDataInput.readFloat(-1);
            tFloatHashSet.add(f2);
        }
        return tFloatHashSet;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TLongHashSet tLongHashSet) throws SerializationException {
        int n2 = tLongHashSet.size();
        serializationDataOutput.writeInt(n2);
        TLongIterator tLongIterator = tLongHashSet.iterator();
        int n3 = tLongHashSet.size();
        while (n3-- > 0) {
            serializationDataOutput.writeLong(tLongIterator.next());
        }
    }

    @NotNull
    public static TLongHashSet bb(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TLongHashSet tLongHashSet = new TLongHashSet(n2);
        int n3 = n2;
        while (n3-- > 0) {
            long l2 = serializationDataInput.readLong();
            tLongHashSet.add(l2);
        }
        return tLongHashSet;
    }

    public static <T1> void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull THashSet<T1> tHashSet) throws SerializationException {
        int n2 = tHashSet.size();
        serializationDataOutput.writeInt(n2);
        Iterator<T1> iterator = tHashSet.iterator();
        int n3 = tHashSet.size();
        while (n3-- > 0) {
            serializationDataOutput.writeObjectPolymorphic(iterator.next());
        }
    }

    @NotNull
    public static <T1> THashSet<T1> cb(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        THashSet tHashSet = new THashSet(n2);
        int n3 = n2;
        while (n3-- > 0) {
            Object t2 = serializationDataInput.readObjectPolymorphic();
            tHashSet.add(t2);
        }
        return tHashSet;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TByteHashSet tByteHashSet) throws SerializationException {
        int n2 = tByteHashSet.size();
        serializationDataOutput.writeInt(n2);
        TByteIterator tByteIterator = tByteHashSet.iterator();
        int n3 = tByteHashSet.size();
        while (n3-- > 0) {
            serializationDataOutput.writeByte(tByteIterator.next());
        }
    }

    @NotNull
    public static TByteHashSet db(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TByteHashSet tByteHashSet = new TByteHashSet(n2);
        int n3 = n2;
        while (n3-- > 0) {
            byte by = serializationDataInput.readByte();
            tByteHashSet.add(by);
        }
        return tByteHashSet;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TShortArrayList tShortArrayList) throws SerializationException {
        int n2 = tShortArrayList.size();
        serializationDataOutput.writeInt(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            serializationDataOutput.writeShort(tShortArrayList.getQuick(i2));
        }
    }

    @NotNull
    public static TShortArrayList eb(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TShortArrayList tShortArrayList = new TShortArrayList(n2);
        int n3 = n2;
        while (n3-- > 0) {
            short s2 = serializationDataInput.readShort();
            tShortArrayList.add(s2);
        }
        return tShortArrayList;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TIntArrayList tIntArrayList) throws SerializationException {
        int n2 = tIntArrayList.size();
        serializationDataOutput.writeInt(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            serializationDataOutput.writeInt(tIntArrayList.getQuick(i2));
        }
    }

    @NotNull
    public static TIntArrayList fb(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TIntArrayList tIntArrayList = new TIntArrayList(n2);
        int n3 = n2;
        while (n3-- > 0) {
            int n4 = serializationDataInput.readInt();
            tIntArrayList.add(n4);
        }
        return tIntArrayList;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TDoubleArrayList tDoubleArrayList) throws SerializationException {
        int n2 = tDoubleArrayList.size();
        serializationDataOutput.writeInt(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            serializationDataOutput.writeDouble(tDoubleArrayList.getQuick(i2));
        }
    }

    @NotNull
    public static TDoubleArrayList gb(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TDoubleArrayList tDoubleArrayList = new TDoubleArrayList(n2);
        int n3 = n2;
        while (n3-- > 0) {
            double d2 = serializationDataInput.readDouble();
            tDoubleArrayList.add(d2);
        }
        return tDoubleArrayList;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TFloatArrayList tFloatArrayList) throws SerializationException {
        int n2 = tFloatArrayList.size();
        serializationDataOutput.writeInt(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            serializationDataOutput.writeFloat(tFloatArrayList.getQuick(i2), -1);
        }
    }

    @NotNull
    public static TFloatArrayList hb(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TFloatArrayList tFloatArrayList = new TFloatArrayList(n2);
        int n3 = n2;
        while (n3-- > 0) {
            float f2 = serializationDataInput.readFloat(-1);
            tFloatArrayList.add(f2);
        }
        return tFloatArrayList;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TLongArrayList tLongArrayList) throws SerializationException {
        int n2 = tLongArrayList.size();
        serializationDataOutput.writeInt(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            serializationDataOutput.writeLong(tLongArrayList.getQuick(i2));
        }
    }

    @NotNull
    public static TLongArrayList ib(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TLongArrayList tLongArrayList = new TLongArrayList(n2);
        int n3 = n2;
        while (n3-- > 0) {
            long l2 = serializationDataInput.readLong();
            tLongArrayList.add(l2);
        }
        return tLongArrayList;
    }

    public static void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TByteArrayList tByteArrayList) throws SerializationException {
        int n2 = tByteArrayList.size();
        serializationDataOutput.writeInt(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            serializationDataOutput.writeByte(tByteArrayList.getQuick(i2));
        }
    }

    @NotNull
    public static TByteArrayList jb(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TByteArrayList tByteArrayList = new TByteArrayList(n2);
        int n3 = n2;
        while (n3-- > 0) {
            byte by = serializationDataInput.readByte();
            tByteArrayList.add(by);
        }
        return tByteArrayList;
    }

    public static <T2> void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull ArrayList<T2> arrayList) throws SerializationException {
        int n2 = arrayList.size();
        serializationDataOutput.writeInt(n2);
        Iterator<T2> iterator = arrayList.iterator();
        int n3 = arrayList.size();
        while (n3-- > 0) {
            serializationDataOutput.writeObjectPolymorphic(iterator.next());
        }
    }

    @NotNull
    public static <T2> ArrayList<T2> kb(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        ArrayList arrayList = new ArrayList(n2);
        int n3 = n2;
        while (n3-- > 0) {
            Object t2 = serializationDataInput.readObjectPolymorphic();
            arrayList.add(t2);
        }
        return arrayList;
    }

    public static <T2> void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull ArrayDeque<T2> arrayDeque) throws SerializationException {
        int n2 = arrayDeque.size();
        serializationDataOutput.writeInt(n2);
        Iterator<T2> iterator = arrayDeque.iterator();
        int n3 = arrayDeque.size();
        while (n3-- > 0) {
            serializationDataOutput.writeObjectPolymorphic(iterator.next());
        }
    }

    @NotNull
    public static <T2> ArrayDeque<T2> lb(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        ArrayDeque arrayDeque = new ArrayDeque(n2);
        int n3 = n2;
        while (n3-- > 0) {
            Object t2 = serializationDataInput.readObjectPolymorphic();
            arrayDeque.add(t2);
        }
        return arrayDeque;
    }

    public static <T2> void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull LinkedList<T2> linkedList) throws SerializationException {
        int n2 = linkedList.size();
        serializationDataOutput.writeInt(n2);
        Iterator iterator = linkedList.iterator();
        int n3 = linkedList.size();
        while (n3-- > 0) {
            serializationDataOutput.writeObjectPolymorphic(iterator.next());
        }
    }

    @NotNull
    public static <T2> LinkedList<T2> mb(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        LinkedList linkedList = new LinkedList();
        int n3 = n2;
        while (n3-- > 0) {
            Object t2 = serializationDataInput.readObjectPolymorphic();
            linkedList.add(t2);
        }
        return linkedList;
    }

    public static <T2> void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull HashSet<T2> hashSet) throws SerializationException {
        int n2 = hashSet.size();
        serializationDataOutput.writeInt(n2);
        Iterator<T2> iterator = hashSet.iterator();
        int n3 = hashSet.size();
        while (n3-- > 0) {
            serializationDataOutput.writeObjectPolymorphic(iterator.next());
        }
    }

    @NotNull
    public static <T2> HashSet<T2> nb(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        HashSet hashSet = new HashSet(n2);
        int n3 = n2;
        while (n3-- > 0) {
            Object t2 = serializationDataInput.readObjectPolymorphic();
            hashSet.add(t2);
        }
        return hashSet;
    }

    public static <T2> void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull LinkedHashSet<T2> linkedHashSet) throws SerializationException {
        int n2 = linkedHashSet.size();
        serializationDataOutput.writeInt(n2);
        Iterator iterator = linkedHashSet.iterator();
        int n3 = linkedHashSet.size();
        while (n3-- > 0) {
            serializationDataOutput.writeObjectPolymorphic(iterator.next());
        }
    }

    @NotNull
    public static <T2> LinkedHashSet<T2> ob(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        LinkedHashSet linkedHashSet = new LinkedHashSet(n2);
        int n3 = n2;
        while (n3-- > 0) {
            Object t2 = serializationDataInput.readObjectPolymorphic();
            linkedHashSet.add(t2);
        }
        return linkedHashSet;
    }

    public static <T2> void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TreeSet<T2> treeSet) throws SerializationException {
        int n2 = treeSet.size();
        serializationDataOutput.writeInt(n2);
        Iterator<T2> iterator = treeSet.iterator();
        int n3 = treeSet.size();
        while (n3-- > 0) {
            serializationDataOutput.writeObjectPolymorphic(iterator.next());
        }
    }

    @NotNull
    public static <T2> TreeSet<T2> pb(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TreeSet treeSet = new TreeSet();
        int n3 = n2;
        while (n3-- > 0) {
            Object t2 = serializationDataInput.readObjectPolymorphic();
            treeSet.add(t2);
        }
        return treeSet;
    }

    public static <T1, T2> void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull HashMap<T1, T2> hashMap) throws SerializationException {
        int n2 = hashMap.size();
        serializationDataOutput.writeInt(n2);
        Iterator<Map.Entry<T1, T2>> iterator = hashMap.entrySet().iterator();
        int n3 = n2;
        while (n3-- > 0) {
            Map.Entry<T1, T2> entry = iterator.next();
            serializationDataOutput.writeObjectPolymorphic(entry.getKey());
            serializationDataOutput.writeObjectPolymorphic(entry.getValue());
        }
    }

    @NotNull
    public static <T1, T2> HashMap<T1, T2> qb(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        HashMap hashMap = new HashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            Object t2 = serializationDataInput.readObjectPolymorphic();
            Object t3 = serializationDataInput.readObjectPolymorphic();
            hashMap.put(t2, t3);
        }
        return hashMap;
    }

    public static <T1, T2> void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull LinkedHashMap<T1, T2> linkedHashMap) throws SerializationException {
        int n2 = linkedHashMap.size();
        serializationDataOutput.writeInt(n2);
        Iterator<Map.Entry<T1, T2>> iterator = linkedHashMap.entrySet().iterator();
        int n3 = n2;
        while (n3-- > 0) {
            Map.Entry<T1, T2> entry = iterator.next();
            serializationDataOutput.writeObjectPolymorphic(entry.getKey());
            serializationDataOutput.writeObjectPolymorphic(entry.getValue());
        }
    }

    @NotNull
    public static <T1, T2> LinkedHashMap<T1, T2> rb(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        LinkedHashMap linkedHashMap = new LinkedHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            Object t2 = serializationDataInput.readObjectPolymorphic();
            Object t3 = serializationDataInput.readObjectPolymorphic();
            linkedHashMap.put(t2, t3);
        }
        return linkedHashMap;
    }

    public static <T1, T2> void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull TreeMap<T1, T2> treeMap) throws SerializationException {
        int n2 = treeMap.size();
        serializationDataOutput.writeInt(n2);
        Iterator<Map.Entry<T1, T2>> iterator = treeMap.entrySet().iterator();
        int n3 = n2;
        while (n3-- > 0) {
            Map.Entry<T1, T2> entry = iterator.next();
            serializationDataOutput.writeObjectPolymorphic(entry.getKey());
            serializationDataOutput.writeObjectPolymorphic(entry.getValue());
        }
    }

    @NotNull
    public static <T1, T2> TreeMap<T1, T2> sb(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        TreeMap treeMap = new TreeMap();
        int n3 = n2;
        while (n3-- > 0) {
            Object t2 = serializationDataInput.readObjectPolymorphic();
            Object t3 = serializationDataInput.readObjectPolymorphic();
            treeMap.put(t2, t3);
        }
        return treeMap;
    }

    public static <T1, T2> void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull IdentityHashMap<T1, T2> identityHashMap) throws SerializationException {
        int n2 = identityHashMap.size();
        serializationDataOutput.writeInt(n2);
        Iterator<Map.Entry<T1, T2>> iterator = identityHashMap.entrySet().iterator();
        int n3 = n2;
        while (n3-- > 0) {
            Map.Entry<T1, T2> entry = iterator.next();
            serializationDataOutput.writeObjectPolymorphic(entry.getKey());
            serializationDataOutput.writeObjectPolymorphic(entry.getValue());
        }
    }

    @NotNull
    public static <T1, T2> IdentityHashMap<T1, T2> tb(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
        int n2 = serializationDataInput.readInt();
        IdentityHashMap identityHashMap = new IdentityHashMap(n2);
        int n3 = n2;
        while (n3-- > 0) {
            Object t2 = serializationDataInput.readObjectPolymorphic();
            Object t3 = serializationDataInput.readObjectPolymorphic();
            identityHashMap.put(t2, t3);
        }
        return identityHashMap;
    }

    static {
        b.put(TShortShortHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TShortShortHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.a(serializationDataInput);
            }
        });
        b.put(TShortIntHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TShortIntHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.b(serializationDataInput);
            }
        });
        b.put(TShortDoubleHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TShortDoubleHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.c(serializationDataInput);
            }
        });
        b.put(TShortFloatHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TShortFloatHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.d(serializationDataInput);
            }
        });
        b.put(TShortLongHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TShortLongHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.e(serializationDataInput);
            }
        });
        b.put(TShortObjectHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TShortObjectHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.f(serializationDataInput);
            }
        });
        b.put(TShortByteHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TShortByteHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.g(serializationDataInput);
            }
        });
        b.put(TIntShortHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TIntShortHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.h(serializationDataInput);
            }
        });
        b.put(TIntIntHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TIntIntHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.i(serializationDataInput);
            }
        });
        b.put(TIntDoubleHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TIntDoubleHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.j(serializationDataInput);
            }
        });
        b.put(TIntFloatHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TIntFloatHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.k(serializationDataInput);
            }
        });
        b.put(TIntLongHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TIntLongHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.l(serializationDataInput);
            }
        });
        b.put(TIntObjectHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TIntObjectHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.m(serializationDataInput);
            }
        });
        b.put(TIntByteHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TIntByteHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.n(serializationDataInput);
            }
        });
        b.put(TDoubleShortHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TDoubleShortHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.o(serializationDataInput);
            }
        });
        b.put(TDoubleIntHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TDoubleIntHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.p(serializationDataInput);
            }
        });
        b.put(TDoubleDoubleHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TDoubleDoubleHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.q(serializationDataInput);
            }
        });
        b.put(TDoubleFloatHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TDoubleFloatHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.r(serializationDataInput);
            }
        });
        b.put(TDoubleLongHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TDoubleLongHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.s(serializationDataInput);
            }
        });
        b.put(TDoubleObjectHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TDoubleObjectHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.t(serializationDataInput);
            }
        });
        b.put(TDoubleByteHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TDoubleByteHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.u(serializationDataInput);
            }
        });
        b.put(TFloatShortHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TFloatShortHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.v(serializationDataInput);
            }
        });
        b.put(TFloatIntHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TFloatIntHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.w(serializationDataInput);
            }
        });
        b.put(TFloatDoubleHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TFloatDoubleHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.x(serializationDataInput);
            }
        });
        b.put(TFloatFloatHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TFloatFloatHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.y(serializationDataInput);
            }
        });
        b.put(TFloatLongHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TFloatLongHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.z(serializationDataInput);
            }
        });
        b.put(TFloatObjectHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TFloatObjectHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.A(serializationDataInput);
            }
        });
        b.put(TFloatByteHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TFloatByteHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.B(serializationDataInput);
            }
        });
        b.put(TLongShortHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TLongShortHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.C(serializationDataInput);
            }
        });
        b.put(TLongIntHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TLongIntHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.D(serializationDataInput);
            }
        });
        b.put(TLongDoubleHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TLongDoubleHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.E(serializationDataInput);
            }
        });
        b.put(TLongFloatHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TLongFloatHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.F(serializationDataInput);
            }
        });
        b.put(TLongLongHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TLongLongHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.G(serializationDataInput);
            }
        });
        b.put(TLongObjectHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TLongObjectHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.H(serializationDataInput);
            }
        });
        b.put(TLongByteHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TLongByteHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.I(serializationDataInput);
            }
        });
        b.put(TObjectShortHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TObjectShortHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.J(serializationDataInput);
            }
        });
        b.put(TObjectIntHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TObjectIntHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.K(serializationDataInput);
            }
        });
        b.put(TObjectDoubleHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TObjectDoubleHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.L(serializationDataInput);
            }
        });
        b.put(TObjectFloatHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TObjectFloatHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.M(serializationDataInput);
            }
        });
        b.put(TObjectLongHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TObjectLongHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.N(serializationDataInput);
            }
        });
        b.put(THashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (THashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.O(serializationDataInput);
            }
        });
        b.put(TObjectByteHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TObjectByteHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.P(serializationDataInput);
            }
        });
        b.put(TByteShortHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TByteShortHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.Q(serializationDataInput);
            }
        });
        b.put(TByteIntHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TByteIntHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.R(serializationDataInput);
            }
        });
        b.put(TByteDoubleHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TByteDoubleHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.S(serializationDataInput);
            }
        });
        b.put(TByteFloatHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TByteFloatHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.T(serializationDataInput);
            }
        });
        b.put(TByteLongHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TByteLongHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.U(serializationDataInput);
            }
        });
        b.put(TByteObjectHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TByteObjectHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.V(serializationDataInput);
            }
        });
        b.put(TByteByteHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TByteByteHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.W(serializationDataInput);
            }
        });
        b.put(TShortHashSet.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TShortHashSet)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.X(serializationDataInput);
            }
        });
        b.put(TIntHashSet.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TIntHashSet)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.Y(serializationDataInput);
            }
        });
        b.put(TDoubleHashSet.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TDoubleHashSet)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.Z(serializationDataInput);
            }
        });
        b.put(TFloatHashSet.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TFloatHashSet)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.ab(serializationDataInput);
            }
        });
        b.put(TLongHashSet.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TLongHashSet)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.bb(serializationDataInput);
            }
        });
        b.put(THashSet.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (THashSet)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.cb(serializationDataInput);
            }
        });
        b.put(TByteHashSet.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TByteHashSet)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.db(serializationDataInput);
            }
        });
        b.put(TShortArrayList.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TShortArrayList)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.eb(serializationDataInput);
            }
        });
        b.put(TIntArrayList.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TIntArrayList)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.fb(serializationDataInput);
            }
        });
        b.put(TDoubleArrayList.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TDoubleArrayList)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.gb(serializationDataInput);
            }
        });
        b.put(TFloatArrayList.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TFloatArrayList)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.hb(serializationDataInput);
            }
        });
        b.put(TLongArrayList.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TLongArrayList)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.ib(serializationDataInput);
            }
        });
        b.put(TByteArrayList.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TByteArrayList)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.jb(serializationDataInput);
            }
        });
        b.put(ArrayList.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (ArrayList)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.kb(serializationDataInput);
            }
        });
        b.put(ArrayDeque.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (ArrayDeque)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.lb(serializationDataInput);
            }
        });
        b.put(LinkedList.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (LinkedList)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.mb(serializationDataInput);
            }
        });
        b.put(HashSet.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (HashSet)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.nb(serializationDataInput);
            }
        });
        b.put(LinkedHashSet.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (LinkedHashSet)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.ob(serializationDataInput);
            }
        });
        b.put(TreeSet.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TreeSet)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.pb(serializationDataInput);
            }
        });
        b.put(HashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (HashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.qb(serializationDataInput);
            }
        });
        b.put(LinkedHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (LinkedHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.rb(serializationDataInput);
            }
        });
        b.put(TreeMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (TreeMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.sb(serializationDataInput);
            }
        });
        b.put(IdentityHashMap.class, new c(){

            @Override
            public void a(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Object object) throws SerializationException {
                tools.reflection.objectsFactory.b.a(serializationDataOutput, (IdentityHashMap)object);
            }

            @Override
            @NotNull
            public Object a(@NotNull SerializationDataInput serializationDataInput) throws SerializationException {
                return tools.reflection.objectsFactory.b.tb(serializationDataInput);
            }
        });
    }
}

