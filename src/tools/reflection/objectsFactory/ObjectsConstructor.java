/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection.objectsFactory;

import gnu.trove.TIntObjectProcedure;
import ioBase.SerializationDataInput;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.mail.org.objectweb.asm.ClassWriter;
import ru.mail.org.objectweb.asm.Label;
import ru.mail.org.objectweb.asm.MethodVisitor;
import ru.mail.org.objectweb.asm.Type;
import tools.reflection.cb;
import tools.reflection.objectsFactory.a;
import tools.reflection.objectsFactory.d;
import tools.reflection.objectsFactory.i;

public final class ObjectsConstructor<T, E extends Exception>
extends i {
    @NotNull
    public static final Logger a = Logger.getLogger(ObjectsConstructor.class);
    private static final int b = 255;
    @NotNull
    private static final AtomicInteger c = new AtomicInteger(0);
    @NotNull
    private final ObjectsConstructorGenerated<E> d;
    @NotNull
    private final a_ e;

    public ObjectsConstructor(@NotNull d_<T> d_2, @NotNull Class<? extends E> clazz) {
        this(d_2, clazz, a_.None, true);
    }

    public ObjectsConstructor(@NotNull d_<T> d_2, @NotNull Class<? extends E> clazz, boolean bl) {
        this(d_2, clazz, a_.None, bl);
    }

    public ObjectsConstructor(@NotNull d_<T> d_2, @NotNull Class<? extends E> clazz, @NotNull a_ a_2) {
        this(d_2, clazz, a_2, true);
    }

    public ObjectsConstructor(@NotNull d_<T> d_2, @NotNull Class<? extends E> clazz, @NotNull a_ a_2, boolean bl) {
        int n2;
        long l2 = System.currentTimeMillis();
        this.e = a_2;
        HashMap hashMap = new HashMap();
        int n3 = this.a(d_2, hashMap);
        if (hashMap.isEmpty()) {
            this.d = new d();
            return;
        }
        int n4 = c.getAndIncrement();
        String string = this.getClass().getPackage().getName() + ".autogen.ObjectsConstructor" + n4;
        ClassWriter classWriter = new ClassWriter(0);
        String string2 = string.replaceAll("\\.", "/");
        classWriter.visit(50, 33, string2, null, ObjectsConstructor.a(Object.class), new String[]{ObjectsConstructor.a(ObjectsConstructorGenerated.class)});
        classWriter.visitField(0, "instances", ObjectsConstructor.b(HashMap.class), null, null).visitEnd();
        List<Integer> list = ObjectsConstructor.a(classWriter, string2, hashMap, n3, bl);
        List<String> list2 = this.a(classWriter, string2, hashMap, n3, list, clazz);
        if (!list2.isEmpty()) {
            i.a_ a_3 = new i.a_("Failed to compile objects factory, because of\n" + list2.toString());
            a.error(a_3);
            throw a_3;
        }
        MethodVisitor methodVisitor = classWriter.visitMethod(129, "create", "(I[Ljava/lang/Object;)Ljava/lang/Object;", null, new String[]{ObjectsConstructor.a(clazz)});
        methodVisitor.visitCode();
        Label label = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        methodVisitor.visitTryCatchBlock(label, label2, label2, ObjectsConstructor.a(clazz));
        methodVisitor.visitTryCatchBlock(label, label3, label3, "java/lang/Throwable");
        methodVisitor.visitLabel(label);
        Label label4 = new Label();
        int n5 = n3 / 255 + 1;
        methodVisitor.visitVarInsn(21, 1);
        methodVisitor.visitLdcInsn(255);
        methodVisitor.visitInsn(108);
        Label[] labelArray = new Label[n5];
        int[] nArray = new int[n5];
        for (n2 = 0; n2 < n5; ++n2) {
            nArray[n2] = n2;
            labelArray[n2] = new Label();
        }
        methodVisitor.visitLookupSwitchInsn(label4, nArray, labelArray);
        for (n2 = 0; n2 < n5; ++n2) {
            methodVisitor.visitLabel(labelArray[n2]);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitVarInsn(21, 1);
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitMethodInsn(183, string2, "create" + n2, "(I[Ljava/lang/Object;)Ljava/lang/Object;");
            methodVisitor.visitInsn(176);
        }
        methodVisitor.visitLabel(label4);
        methodVisitor.visitInsn(1);
        methodVisitor.visitInsn(176);
        methodVisitor.visitLabel(label2);
        methodVisitor.visitFrame(4, 0, null, 1, new Object[]{ObjectsConstructor.a(clazz)});
        methodVisitor.visitVarInsn(58, 3);
        methodVisitor.visitVarInsn(25, 3);
        methodVisitor.visitInsn(191);
        methodVisitor.visitLabel(label3);
        methodVisitor.visitFrame(4, 0, null, 1, new Object[]{"java/lang/Throwable"});
        methodVisitor.visitVarInsn(58, 3);
        methodVisitor.visitTypeInsn(187, ObjectsConstructor.a(clazz));
        methodVisitor.visitInsn(89);
        methodVisitor.visitVarInsn(25, 3);
        methodVisitor.visitMethodInsn(183, ObjectsConstructor.a(clazz), "<init>", "(Ljava/lang/Throwable;)V");
        methodVisitor.visitInsn(191);
        methodVisitor.visitMaxs(3, 4);
        methodVisitor.visitEnd();
        classWriter.visitEnd();
        try {
            this.d = (ObjectsConstructorGenerated)this.a(string, classWriter.toByteArray());
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            throw new i.a_("failed to compile objects factory", reflectiveOperationException);
        }
        long l3 = System.currentTimeMillis() - l2;
        a.debug("Generated ObjectsConstructor: " + hashMap.size() + " classes, " + l3 + " ms");
        hashMap.clear();
    }

    @NotNull
    private Object a(@NotNull String string, @NotNull byte[] byArray) throws ReflectiveOperationException {
        a a2 = new a(this.getClass().getClassLoader());
        Class<?> clazz = a2.a(string, byArray);
        return clazz.getConstructor(new Class[0]).newInstance(new Object[0]);
    }

    @Nullable
    public <T> T a(int n2) throws E {
        Object object = this.d.create(n2, new Object[0]);
        return (T)object;
    }

    @Nullable
    public <T> T a(int n2, @NotNull SerializationDataInput serializationDataInput) throws E {
        Object object = this.d.create(n2, serializationDataInput);
        return (T)object;
    }

    private boolean a(@NotNull Class<?> clazz, @NotNull List<String> list) {
        try {
            Constructor<?> constructor = clazz.getConstructor(this.e.getArgumentsTypes());
            if (constructor == null) {
                throw new NoSuchMethodException();
            }
            if (!Modifier.isPublic(constructor.getModifiers())) {
                list.add(MessageFormat.format("\t\u0421onstructor should be public [{0}({1})]\n", clazz.getCanonicalName(), this.e.getCastedArguments()));
            }
            return true;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            list.add(MessageFormat.format("\t\u0421onstructor should be public [{0}({1})]\n", clazz.getCanonicalName(), this.e.getCastedArguments()));
            return false;
        }
    }

    private int a(@NotNull d_<T> d_2, final @NotNull HashMap<Integer, Class<?>> hashMap) {
        final int[] nArray = new int[]{-1};
        d_2.a(new TIntObjectProcedure<Class<? extends T>>(){

            public boolean execute(int n2, @NotNull Class<? extends T> clazz) {
                if (clazz.getCanonicalName() == null) {
                    throw new i.a_("canonical name of class \"" + clazz + "\" not found, probably anonymous class");
                }
                if (hashMap.containsKey(n2)) {
                    throw new i.a_("equal id found, classes are \"" + hashMap.get(n2) + "\", \"" + clazz + '\"');
                }
                hashMap.put(n2, clazz);
                if (n2 > nArray[0]) {
                    nArray[0] = n2;
                }
                return true;
            }
        });
        return nArray[0];
    }

    @NotNull
    private static List<Integer> a(@NotNull ClassWriter classWriter, @NotNull String string, @NotNull HashMap<Integer, Class<?>> hashMap, int n2, boolean bl) {
        Class<c_> clazz;
        Method method;
        MethodVisitor methodVisitor = classWriter.visitMethod(1, "<init>", "()V", null, null);
        methodVisitor.visitCode();
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitMethodInsn(183, ObjectsConstructor.a(Object.class), "<init>", "()V");
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitTypeInsn(187, ObjectsConstructor.a(HashMap.class));
        methodVisitor.visitInsn(89);
        methodVisitor.visitLdcInsn(n2);
        methodVisitor.visitMethodInsn(183, ObjectsConstructor.a(HashMap.class), "<init>", "(I)V");
        methodVisitor.visitFieldInsn(181, string, "instances", ObjectsConstructor.b(HashMap.class));
        ArrayList<Integer> arrayList = new ArrayList<Integer>(n2);
        if (bl) {
            ObjectsConstructor.a(hashMap, n2, arrayList);
        }
        if ((method = ObjectsConstructor.c(clazz = c_.class)) == null) {
            throw new i.a_("Invalid wrapper class: " + clazz.getName());
        }
        if (!arrayList.isEmpty()) {
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                int n3 = (Integer)iterator.next();
                Class<?> clazz2 = hashMap.get(n3);
                if (clazz2 == null) continue;
                methodVisitor.visitVarInsn(25, 0);
                methodVisitor.visitFieldInsn(180, string, "instances", ObjectsConstructor.b(HashMap.class));
                methodVisitor.visitLdcInsn(n3);
                methodVisitor.visitMethodInsn(184, ObjectsConstructor.a(Integer.class), "valueOf", "(I)" + ObjectsConstructor.b(Integer.class));
                methodVisitor.visitLdcInsn(Type.getType(ObjectsConstructor.b(clazz2)));
                methodVisitor.visitMethodInsn(184, ObjectsConstructor.a(clazz), method.getName(), "(Ljava/lang/Class;)Ljava/lang/Object;");
                methodVisitor.visitMethodInsn(182, ObjectsConstructor.a(HashMap.class), "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
                methodVisitor.visitInsn(87);
            }
        }
        methodVisitor.visitInsn(177);
        methodVisitor.visitMaxs(4, 1);
        methodVisitor.visitEnd();
        return arrayList;
    }

    private static void a(@NotNull HashMap<Integer, Class<?>> hashMap, int n2, @NotNull List<Integer> list) {
        for (int i2 = 0; i2 <= n2; ++i2) {
            Class<?> clazz = hashMap.get(i2);
            if (clazz == null) continue;
            boolean bl = true;
            Class<?> clazz2 = clazz;
            while (bl && !Object.class.equals(clazz2)) {
                Field[] fieldArray;
                for (Field field : fieldArray = clazz2.getDeclaredFields()) {
                    if (Modifier.isStatic(field.getModifiers())) continue;
                    bl = false;
                    break;
                }
                clazz2 = clazz2.getSuperclass();
            }
            if (!bl) continue;
            list.add(i2);
        }
    }

    @Nullable
    private static Method c(@NotNull Class<c_> clazz) {
        Method method = null;
        for (Method method2 : clazz.getMethods()) {
            if ((method2.getModifiers() & 8) == 0) continue;
            if (method != null) {
                return null;
            }
            method = method2;
        }
        return method;
    }

    @NotNull
    private List<String> a(@NotNull ClassWriter classWriter, @NotNull String string, @NotNull HashMap<Integer, Class<?>> hashMap, int n2, @NotNull List<Integer> list, @NotNull Class<? extends E> clazz) {
        ArrayList<String> arrayList = new ArrayList<String>(100);
        for (int i2 = 0; i2 <= n2 / 255; ++i2) {
            Class<?> clazz2;
            MethodVisitor methodVisitor = classWriter.visitMethod(2, "create" + i2, "(I[Ljava/lang/Object;)Ljava/lang/Object;", null, new String[]{ObjectsConstructor.a(clazz)});
            Label label = new Label();
            methodVisitor.visitLabel(label);
            HashMap<Integer, Object> hashMap2 = new HashMap<Integer, Object>();
            for (int i3 = i2 * 255; i3 < (i2 + 1) * 255 + 1; ++i3) {
                clazz2 = hashMap.get(i3);
                if (clazz2 == null || Number.class.isAssignableFrom(clazz2) || String.class.isAssignableFrom(clazz2)) continue;
                hashMap2.put(i3, clazz2);
            }
            if (!hashMap2.isEmpty()) {
                int n3;
                Label[] labelArray = new Label[hashMap2.size()];
                int[] arr = new int[hashMap2.size()];
                int n4 = 0;
                Iterator object = hashMap2.keySet().iterator();
                while (object.hasNext()) {
                    n3 = (Integer)object.next();
                    labelArray[n4] = new Label();
                    arr[n4] = n3;
                    ++n4;
                }
                Arrays.sort((int[])arr);
                Label l = new Label();
                methodVisitor.visitVarInsn(21, 1);
                methodVisitor.visitLookupSwitchInsn((Label)l, (int[])arr, labelArray);
                for (n3 = 0; n3 < labelArray.length; ++n3) {
                    Object object2 = arr[n3];
                    Class<?> clazz3 = hashMap.get((int)object2);
                    if (clazz3 == null || Number.class.isAssignableFrom(clazz3) || String.class.isAssignableFrom(clazz3)) continue;
                    if (!Modifier.isPublic(clazz3.getModifiers())) {
                        arrayList.add(MessageFormat.format("\tSerializable class should be public [{0}]\n", clazz3.getCanonicalName()));
                    }
                    methodVisitor.visitLabel(labelArray[n3]);
                    if (list.contains((int)object2)) {
                        methodVisitor.visitVarInsn(25, 0);
                        methodVisitor.visitFieldInsn(180, string, "instances", ObjectsConstructor.b(HashMap.class));
                        methodVisitor.visitLdcInsn((int)object2);
                        methodVisitor.visitMethodInsn(184, ObjectsConstructor.a(Integer.class), "valueOf", "(I)" + ObjectsConstructor.b(Integer.class));
                        methodVisitor.visitMethodInsn(182, ObjectsConstructor.a(HashMap.class), "get", "(Ljava/lang/Object;)Ljava/lang/Object;");
                        methodVisitor.visitInsn(176);
                        continue;
                    }
                    this.a(clazz3, arrayList);
                    this.e.invokeConstructor(methodVisitor, clazz3);
                    methodVisitor.visitInsn(176);
                }
                methodVisitor.visitLabel((Label)l);
            }
            methodVisitor.visitInsn(1);
            methodVisitor.visitInsn(176);
            methodVisitor.visitMaxs(4, 3);
            methodVisitor.visitEnd();
        }
        return arrayList;
    }

    public static final class c_ {
        private c_() {
        }

        @NotNull
        public static <T> T a(@NotNull Class<T> clazz) {
            try {
                Class<T> clazz2 = (Class<T>) cb.d(clazz);
                return cb.c(clazz, clazz2);
            }
            catch (cb.b_ b_2) {
                throw new RuntimeException(b_2);
            }
        }
    }

    public static interface ObjectsConstructorGenerated<E extends Exception> {
        @Nullable
        public Object create(int var1, Object ... var2) throws E;
    }

    public static interface d_<T> {
        public void a(@NotNull TIntObjectProcedure<Class<? extends T>> var1);
    }

    public static enum a_ {
        None(new Class[0]){

            @Override
            public void invokeConstructor(@NotNull MethodVisitor methodVisitor, @NotNull Class<?> clazz) {
                methodVisitor.visitTypeInsn(187, i.a(clazz));
                methodVisitor.visitInsn(89);
                methodVisitor.visitMethodInsn(183, i.a(clazz), "<init>", "()V");
            }
        }
        ,
        Serializable(new Class[]{SerializationDataInput.class}){

            @Override
            public void invokeConstructor(@NotNull MethodVisitor methodVisitor, @NotNull Class<?> clazz) {
                methodVisitor.visitTypeInsn(187, i.a(clazz));
                methodVisitor.visitInsn(89);
                methodVisitor.visitVarInsn(25, 2);
                methodVisitor.visitInsn(3);
                methodVisitor.visitInsn(50);
                methodVisitor.visitTypeInsn(192, i.a(SerializationDataInput.class));
                methodVisitor.visitMethodInsn(183, i.a(clazz), "<init>", '(' + i.b(SerializationDataInput.class) + ")V");
            }
        };

        @NotNull
        private final String a;
        @NotNull
        private final Class<?>[] b;

        private a_(Class<?> ... classArray) {
            this.b = classArray == null ? new Class[0] : classArray;
            StringBuilder stringBuilder = new StringBuilder();
            for (int i2 = 0; i2 < this.b.length; ++i2) {
                if (i2 > 0) {
                    stringBuilder.append(", ");
                }
                String string2 = this.b[i2].getCanonicalName();
                stringBuilder.append('(').append(string2).append(") arguments[").append(i2).append(']');
            }
            this.a = stringBuilder.toString();
        }

        @NotNull
        public Class<?>[] getArgumentsTypes() {
            return this.b;
        }

        @NotNull
        public String getCastedArguments() {
            return this.a;
        }

        public abstract void invokeConstructor(@NotNull MethodVisitor var1, @NotNull Class<?> var2);
    }
}

