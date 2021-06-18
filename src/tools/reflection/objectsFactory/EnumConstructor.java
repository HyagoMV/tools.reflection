/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  ru.mail.org.objectweb.asm.ClassVisitor
 *  ru.mail.org.objectweb.asm.ClassWriter
 *  ru.mail.org.objectweb.asm.MethodVisitor
 *  ru.mail.org.objectweb.asm.Type
 */
package tools.reflection.objectsFactory;

import gnu.trove.TIntObjectHashMap;
import gnu.trove.TIntObjectProcedure;
import gnu.trove.TObjectIntHashMap;
import ioBase.SerializationDataInput;
import ioBase.SerializationDataOutput;
import ioBase.SerializationException;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.NotNull;
import ru.mail.org.objectweb.asm.ClassVisitor;
import ru.mail.org.objectweb.asm.ClassWriter;
import ru.mail.org.objectweb.asm.MethodVisitor;
import ru.mail.org.objectweb.asm.Type;
import tools.reflection.objectsFactory.a;
import tools.reflection.objectsFactory.bb;
import tools.reflection.objectsFactory.i;
import tools.reflection.objectsFactory.z;

public final class EnumConstructor
extends i {
    @NotNull
    private static final AtomicInteger a = new AtomicInteger(0);
    @NotNull
    private static final String b = "writeEnum";
    @NotNull
    private static final String c = "(LioBase/SerializationDataOutput;ILjava/lang/Enum;)V";
    @NotNull
    private static final String d = "(LioBase/SerializationDataOutput;ILjava/lang/Enum<*>;)V";
    @NotNull
    private static final String e = "readEnum";
    @NotNull
    private static final String f = "(LioBase/SerializationDataInput;I)Ljava/lang/Enum;";
    @NotNull
    private static final String g = "(LioBase/SerializationDataInput;I)Ljava/lang/Enum<*>;";
    @NotNull
    private static final String h = "ENUM_VALUES_$";
    @NotNull
    private final TObjectIntHashMap<Class<?>> i = new TObjectIntHashMap();
    @NotNull
    private final EnumConstructorGenerated j;

    public EnumConstructor(@NotNull Iterable iterable, @NotNull Class<? extends Throwable> clazz) {
        TIntObjectHashMap tIntObjectHashMap = new TIntObjectHashMap();
        EnumConstructor.collectClasses(iterable, tIntObjectHashMap);
        tIntObjectHashMap.forEachEntry(new TIntObjectProcedure<Class<Enum<?>>>(){

            @Override
            public boolean execute(int n2, @NotNull Class<Enum<?>> clazz) {
                EnumConstructor.this.i.put(clazz, n2);
                return true;
            }
        });
        int n2 = a.getAndIncrement();
        String string = this.getClass().getPackage().getName() + ".autogen.EnumConstructor" + n2;
        ClassWriter classWriter = new ClassWriter(3);
        String string2 = string.replaceAll("\\.", "/");
        classWriter.visit(50, 33, string2, null, Type.getInternalName(EnumConstructorGeneratedBase.class), new String[]{Type.getInternalName(EnumConstructorGenerated.class)});
        this.generateStatics(classWriter, string2, tIntObjectHashMap);
        EnumConstructor.generateConstructor(classWriter);
        EnumConstructor.generateWriteEnum(classWriter, tIntObjectHashMap, string2, clazz);
        EnumConstructor.generateReadEnum(classWriter, tIntObjectHashMap, string2, clazz);
        classWriter.visitEnd();
        Class<?> clazz2 = tools.reflection.objectsFactory.a.a(this.getClass().getClassLoader(), string, classWriter.toByteArray());
        try {
            this.j = (EnumConstructorGenerated)clazz2.getConstructor(new Class[0]).newInstance(new Object[0]);
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            throw new i.a_(reflectiveOperationException);
        }
    }

    public <T extends Enum<T>> void writeEnum(@NotNull SerializationDataOutput serializationDataOutput, @NotNull Class<T> clazz, @NotNull T t2) throws SerializationException {
        int n2 = this.i.get(clazz);
        if (n2 == 0 && !this.i.containsKey(clazz)) {
            throw new SerializationException("Can't serialize unknown enum class: " + clazz);
        }
        this.j.writeEnum(serializationDataOutput, n2, t2);
    }

    @NotNull
    public <T extends Enum<T>> T readEnum(@NotNull SerializationDataInput serializationDataInput, @NotNull Class<T> clazz) throws SerializationException {
        int n2 = this.i.get(clazz);
        if (n2 == 0 && !this.i.containsKey(clazz)) {
            throw new SerializationException("Can't deserialize unknown enum class: " + clazz);
        }
        return (T)this.j.readEnum(serializationDataInput, n2);
    }

    private static void generateWriteEnum(@NotNull ClassWriter classWriter, @NotNull TIntObjectHashMap<Class<Enum<?>>> tIntObjectHashMap, @NotNull String string, @NotNull Class<? extends Throwable> clazz) {
        bb bb2 = bb.a((ClassVisitor)classWriter, 1, b, c, d, Type.getType(clazz));
        bb2.visitCode();
        WriteSwitchGenerator writeSwitchGenerator = new WriteSwitchGenerator(tIntObjectHashMap.keys(), string);
        writeSwitchGenerator.a((MethodVisitor)bb2);
        bb2.visitMaxs(0, 0);
        bb2.visitEnd();
        for (int n2 : writeSwitchGenerator.b()) {
            MethodVisitor methodVisitor = classWriter.visitMethod(10, "writeEnum$" + n2, c, d, new String[]{Type.getInternalName(clazz)});
            methodVisitor.visitCode();
            writeSwitchGenerator.a(methodVisitor, n2);
            methodVisitor.visitMaxs(10, 14);
            methodVisitor.visitEnd();
        }
    }

    private static void generateReadEnum(@NotNull ClassWriter classWriter, @NotNull TIntObjectHashMap<Class<Enum<?>>> tIntObjectHashMap, @NotNull String string, @NotNull Class<? extends Throwable> clazz) {
        bb bb2 = bb.a((ClassVisitor)classWriter, 1, e, f, g, Type.getType(clazz));
        bb2.visitCode();
        ReadSwitchGenerator readSwitchGenerator = new ReadSwitchGenerator(tIntObjectHashMap.keys(), string, tIntObjectHashMap);
        readSwitchGenerator.a((MethodVisitor)bb2);
        bb2.visitMaxs(0, 0);
        bb2.visitEnd();
        for (int n2 : readSwitchGenerator.b()) {
            MethodVisitor methodVisitor = classWriter.visitMethod(10, "readEnum$" + n2, f, g, new String[]{Type.getInternalName(clazz)});
            methodVisitor.visitCode();
            readSwitchGenerator.a(methodVisitor, n2);
            methodVisitor.visitMaxs(10, 10);
            methodVisitor.visitEnd();
        }
    }

    private void generateStatics(@NotNull ClassWriter classWriter, @NotNull String string, @NotNull TIntObjectHashMap<Class<Enum<?>>> tIntObjectHashMap) {
    }

    private static void generateConstructor(@NotNull ClassWriter classWriter) {
        MethodVisitor methodVisitor = classWriter.visitMethod(1, "<init>", Type.getMethodDescriptor((Type)Type.VOID_TYPE, (Type[])new Type[0]), null, null);
        methodVisitor.visitCode();
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitMethodInsn(183, Type.getInternalName(EnumConstructorGeneratedBase.class), "<init>", Type.getMethodDescriptor((Type)Type.VOID_TYPE, (Type[])new Type[0]));
        methodVisitor.visitInsn(177);
        methodVisitor.visitMaxs(1, 1);
        methodVisitor.visitEnd();
    }

    private static void collectClasses(@NotNull Iterable iterable, final @NotNull TIntObjectHashMap<Class> tIntObjectHashMap) {
        iterable.forEach(new TIntObjectProcedure<Class<?>>(){

            @Override
            public boolean execute(int n2, @NotNull Class<?> clazz) {
                if (clazz.getCanonicalName() == null) {
                    throw new i.a_("canonical name of class \"" + clazz + "\" not found, probably anonymous class");
                }
                if (tIntObjectHashMap.containsKey(n2)) {
                    throw new i.a_("equal id found, classes are \"" + tIntObjectHashMap.get(n2) + "\", \"" + clazz + '\"');
                }
                tIntObjectHashMap.put(n2, clazz.asSubclass(Enum.class));
                return true;
            }
        });
    }

    public static abstract class EnumConstructorGeneratedBase {
        protected static void writeEnumDefault(@NotNull SerializationDataOutput serializationDataOutput, int n2, @NotNull Enum<?> enum_) throws SerializationException {
            throw new SerializationException("Can't serialize enum value: type=" + enum_.getClass() + ", value=" + enum_ + ", typeId=" + n2);
        }

        @NotNull
        protected static Enum<?> readEnumDefault(@NotNull SerializationDataInput serializationDataInput, int n2) throws SerializationException {
            throw new SerializationException("Can't deserialize enum value: typeId=" + n2);
        }

        @NotNull
        protected static Enum<?> readEnumInternal(@NotNull SerializationDataInput serializationDataInput, @NotNull Class<?> clazz, @NotNull Enum<?>[] enumArray, int n2) throws SerializationException {
            int n3 = serializationDataInput.readInt();
            if (n3 < 0 || n3 >= n2) {
                throw new SerializationException("Invalid enum value: enumType=" + clazz + ", value=" + n3);
            }
            return enumArray[n3];
        }
    }

    public static interface EnumConstructorGenerated {
        public void writeEnum(@NotNull SerializationDataOutput var1, int var2, @NotNull Enum<?> var3) throws SerializationException;

        @NotNull
        public Enum<?> readEnum(@NotNull SerializationDataInput var1, int var2) throws SerializationException;
    }

    public static interface Iterable {
        public void forEach(@NotNull TIntObjectProcedure<Class<?>> var1);
    }

    private static final class ReadSwitchGenerator
    extends z {
        @NotNull
        private final TIntObjectHashMap<Class<Enum<?>>> e;

        private ReadSwitchGenerator(@NotNull int[] nArray, @NotNull String string, @NotNull TIntObjectHashMap<Class<Enum<?>>> tIntObjectHashMap) {
            super(nArray, string);
            this.e = tIntObjectHashMap;
        }

        @Override
        protected void onOuterLoadId(@NotNull MethodVisitor methodVisitor) {
            methodVisitor.visitVarInsn(21, 2);
        }

        @Override
        protected void onOuterCase(@NotNull MethodVisitor methodVisitor, int n2) {
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(21, 2);
            methodVisitor.visitMethodInsn(184, this.c(), "readEnum$" + n2, EnumConstructor.f);
            methodVisitor.visitInsn(176);
        }

        @Override
        protected void onOuterDefaultCase(@NotNull MethodVisitor methodVisitor) {
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(21, 2);
            methodVisitor.visitMethodInsn(184, this.c(), "readEnumDefault", EnumConstructor.f);
            methodVisitor.visitInsn(176);
        }

        @Override
        protected void onInnerLoadId(@NotNull MethodVisitor methodVisitor) {
            methodVisitor.visitVarInsn(21, 1);
        }

        @Override
        protected void onInnerCase(@NotNull MethodVisitor methodVisitor, int n2) {
            Class<Enum<?>> clazz = this.e.get(n2);
            if (clazz == null) {
                throw new i.a_("Class for id=" + n2 + " wasn't found during generation");
            }
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitLdcInsn((Object)Type.getType(clazz));
            Type type = Type.getType(Enum[].class);
            Type type2 = Type.getType(Array.newInstance(clazz, 0).getClass());
            methodVisitor.visitMethodInsn(184, Type.getInternalName(clazz), "values", Type.getMethodDescriptor((Type)type2, (Type[])new Type[0]));
            methodVisitor.visitInsn(89);
            methodVisitor.visitInsn(190);
            methodVisitor.visitMethodInsn(184, this.c(), "readEnumInternal", Type.getMethodDescriptor((Type)Type.getType(Enum.class), (Type[])new Type[]{Type.getType(SerializationDataInput.class), Type.getType(Class.class), type, Type.INT_TYPE}));
            methodVisitor.visitInsn(176);
        }

        @Override
        protected void onInnerDefaultCase(@NotNull MethodVisitor methodVisitor) {
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitVarInsn(21, 1);
            methodVisitor.visitMethodInsn(184, this.c(), "readEnumDefault", EnumConstructor.f);
            methodVisitor.visitInsn(176);
        }
    }

    private static final class WriteSwitchGenerator
    extends z {
        private WriteSwitchGenerator(@NotNull int[] nArray, @NotNull String string) {
            super(nArray, string);
        }

        @Override
        protected void onOuterLoadId(@NotNull MethodVisitor methodVisitor) {
            methodVisitor.visitVarInsn(21, 2);
        }

        @Override
        protected void onOuterCase(@NotNull MethodVisitor methodVisitor, int n2) {
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(21, 2);
            methodVisitor.visitVarInsn(25, 3);
            methodVisitor.visitMethodInsn(184, this.c(), "writeEnum$" + n2, EnumConstructor.c);
            methodVisitor.visitInsn(177);
        }

        @Override
        protected void onOuterDefaultCase(@NotNull MethodVisitor methodVisitor) {
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(21, 2);
            methodVisitor.visitVarInsn(25, 3);
            methodVisitor.visitMethodInsn(184, this.c(), "writeEnumDefault", EnumConstructor.c);
            methodVisitor.visitInsn(177);
        }

        @Override
        protected void onInnerLoadId(@NotNull MethodVisitor methodVisitor) {
            methodVisitor.visitVarInsn(21, 1);
        }

        @Override
        protected void onInnerCase(@NotNull MethodVisitor methodVisitor, int n2) {
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitMethodInsn(182, Type.getInternalName(Enum.class), "ordinal", Type.getMethodDescriptor((Type)Type.INT_TYPE, (Type[])new Type[0]));
            methodVisitor.visitMethodInsn(182, Type.getInternalName(SerializationDataOutput.class), "writeInt", Type.getMethodDescriptor((Type)Type.VOID_TYPE, (Type[])new Type[]{Type.INT_TYPE}));
            methodVisitor.visitInsn(177);
        }

        @Override
        protected void onInnerDefaultCase(@NotNull MethodVisitor methodVisitor) {
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitVarInsn(21, 1);
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitMethodInsn(184, this.c(), "writeEnumDefault", EnumConstructor.c);
            methodVisitor.visitInsn(177);
        }
    }
}

