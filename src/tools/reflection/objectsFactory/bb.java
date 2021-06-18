/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  ru.mail.org.objectweb.asm.ClassVisitor
 *  ru.mail.org.objectweb.asm.Label
 *  ru.mail.org.objectweb.asm.MethodVisitor
 *  ru.mail.org.objectweb.asm.Type
 *  ru.mail.org.objectweb.asm.commons.GeneratorAdapter
 */
package tools.reflection.objectsFactory;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.mail.org.objectweb.asm.ClassVisitor;
import ru.mail.org.objectweb.asm.Label;
import ru.mail.org.objectweb.asm.MethodVisitor;
import ru.mail.org.objectweb.asm.Type;
import ru.mail.org.objectweb.asm.commons.GeneratorAdapter;

public final class bb
extends GeneratorAdapter {
    @NotNull
    private final Type a;
    @NotNull
    private final Label b = new Label();
    @NotNull
    private final Label c = new Label();
    @NotNull
    private final Label d = new Label();

    @NotNull
    public static bb a(@NotNull ClassVisitor classVisitor, int n2, @NotNull String string, @NotNull String string2, @Nullable String string3, @NotNull Type type) {
        MethodVisitor methodVisitor = classVisitor.visitMethod(n2, string, string2, string3, new String[]{type.getInternalName()});
        return new bb(262144, methodVisitor, n2, string, string2, type);
    }

    public bb(int n2, @NotNull MethodVisitor methodVisitor, int n3, @NotNull String string, @NotNull String string2, @NotNull Type type) {
        super(n2, methodVisitor, n3, string, string2);
        this.a = type;
    }

    public void visitCode() {
        super.visitCode();
        this.a();
    }

    public void visitMaxs(int n2, int n3) {
        this.b();
        super.visitMaxs(n2, n3);
    }

    private void a() {
        this.mv.visitTryCatchBlock(this.b, this.c, this.c, this.a.getInternalName());
        this.mv.visitTryCatchBlock(this.b, this.c, this.d, Type.getInternalName(Throwable.class));
        this.mv.visitLabel(this.b);
    }

    private void b() {
        this.mv.visitLabel(this.c);
        this.mv.visitInsn(191);
        this.mv.visitLabel(this.d);
        int n2 = this.newLocal(this.a);
        this.mv.visitVarInsn(58, n2);
        this.mv.visitTypeInsn(187, this.a.getInternalName());
        this.mv.visitInsn(89);
        this.mv.visitVarInsn(25, n2);
        this.mv.visitMethodInsn(183, this.a.getInternalName(), "<init>", Type.getMethodDescriptor((Type)Type.VOID_TYPE, (Type[])new Type[]{Type.getType(Throwable.class)}));
        this.mv.visitInsn(191);
    }
}

