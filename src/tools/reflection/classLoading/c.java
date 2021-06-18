/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  ru.mail.org.objectweb.asm.ClassReader
 *  ru.mail.org.objectweb.asm.ClassVisitor
 *  ru.mail.org.objectweb.asm.ClassWriter
 *  ru.mail.org.objectweb.asm.tree.AbstractInsnNode
 *  ru.mail.org.objectweb.asm.tree.ClassNode
 *  ru.mail.org.objectweb.asm.tree.InsnList
 *  ru.mail.org.objectweb.asm.tree.InsnNode
 *  ru.mail.org.objectweb.asm.tree.LdcInsnNode
 *  ru.mail.org.objectweb.asm.tree.MethodInsnNode
 *  ru.mail.org.objectweb.asm.tree.MethodNode
 */
package tools.reflection.classLoading;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import java.util.List;
import java.util.ListIterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.mail.org.objectweb.asm.ClassReader;
import ru.mail.org.objectweb.asm.ClassVisitor;
import ru.mail.org.objectweb.asm.ClassWriter;
import ru.mail.org.objectweb.asm.tree.AbstractInsnNode;
import ru.mail.org.objectweb.asm.tree.ClassNode;
import ru.mail.org.objectweb.asm.tree.InsnList;
import ru.mail.org.objectweb.asm.tree.InsnNode;
import ru.mail.org.objectweb.asm.tree.LdcInsnNode;
import ru.mail.org.objectweb.asm.tree.MethodInsnNode;
import ru.mail.org.objectweb.asm.tree.MethodNode;
import tools.reflection.classLoading.d;

public final class c {
    private static volatile boolean a = false;

    public static void a(@Nullable String string, @NotNull Instrumentation instrumentation) {
        d.a();
        instrumentation.addTransformer(new b_());
        d.a(instrumentation.getAllLoadedClasses());
        a = true;
    }

    public static boolean a() {
        return a;
    }

    private c() {
    }

    private static final class b_
    implements ClassFileTransformer {
        @NotNull
        public static final String[] a = new String[0];
        @NotNull
        private static final String b = "tools/reflection/classLoading/agent/ClassLoadingHelper";
        @NotNull
        public static final String c = "onClassAdded";
        @NotNull
        public static final String d = "(Ljava/lang/String;)V";

        private b_() {
        }

        @Override
        @Nullable
        public byte[] transform(@Nullable ClassLoader classLoader, @Nullable String string, @Nullable Class<?> clazz, @Nullable ProtectionDomain protectionDomain, @NotNull byte[] byArray) {
            if (classLoader != null && clazz == null && string != null) {
                ClassNode classNode = b_.a(byArray);
                if (string.equals("asserts/Verify") || string.equals(b)) {
                    return null;
                }
                if ((classNode.access & 0x1000) != 0 || classNode.sourceFile == null) {
                    return null;
                }
                if ((classNode.access & 0x200) != 0) {
                    tools.reflection.classLoading.d.e(string);
                }
                List<MethodNode> list = classNode.methods;
                boolean bl = false;
                for (MethodNode methodNode : list) {
                    if (!methodNode.name.equals("<clinit>")) continue;
                    b_.a(classNode, methodNode);
                    bl = true;
                }
                if (!bl) {
                    b_.a(classNode);
                }
                ClassWriter classWriter = new ClassWriter(0);
                classNode.accept((ClassVisitor)classWriter);
                return classWriter.toByteArray();
            }
            return null;
        }

        private static void a(@NotNull ClassNode classNode) {
            MethodNode methodNode = new MethodNode(8, "<clinit>", "()V", null, a);
            methodNode.instructions.add((AbstractInsnNode)b_.b(classNode));
            methodNode.instructions.add((AbstractInsnNode)b_.a());
            methodNode.instructions.add((AbstractInsnNode)new InsnNode(177));
            methodNode.maxLocals = 0;
            methodNode.maxStack = 1;
            classNode.methods.add(methodNode);
        }

        private static void a(@NotNull ClassNode classNode, @NotNull MethodNode methodNode) {
            AbstractInsnNode abstractInsnNode = b_.b(classNode, methodNode);
            methodNode.instructions.insertBefore(abstractInsnNode, (AbstractInsnNode)b_.b(classNode));
            methodNode.instructions.insertBefore(abstractInsnNode, (AbstractInsnNode)b_.a());
            methodNode.maxStack = Math.max(methodNode.maxStack, 1);
        }

        @NotNull
        private static AbstractInsnNode b(@NotNull ClassNode classNode, @NotNull MethodNode methodNode) {
            InsnList insnList = methodNode.instructions;
            ListIterator listIterator = insnList.iterator();
            int n2 = 0;
            AbstractInsnNode abstractInsnNode = null;
            while (listIterator.hasNext()) {
                AbstractInsnNode abstractInsnNode2 = (AbstractInsnNode)listIterator.next();
                if (abstractInsnNode2.getOpcode() != 177) continue;
                ++n2;
                abstractInsnNode = abstractInsnNode2;
            }
            if (n2 > 1) {
                throw new RuntimeException(classNode.name + " has more than 1 return operation in static initializer");
            }
            if (abstractInsnNode == null) {
                throw new RuntimeException(classNode.name + " has NO return operation in static initializer. Really unexpected, this one.");
            }
            return abstractInsnNode;
        }

        @NotNull
        private static MethodInsnNode a() {
            return new MethodInsnNode(184, b, c, d);
        }

        @NotNull
        private static LdcInsnNode b(@NotNull ClassNode classNode) {
            return new LdcInsnNode((Object)classNode.name);
        }

        @NotNull
        private static ClassNode a(@NotNull byte[] byArray) {
            ClassReader classReader = new ClassReader(byArray);
            ClassNode classNode = new ClassNode();
            classReader.accept((ClassVisitor)classNode, 0);
            return classNode;
        }
    }
}

