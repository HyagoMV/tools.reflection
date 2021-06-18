/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  javassist.ClassPool
 *  javassist.CtClass
 *  javassist.CtConstructor
 *  javassist.Modifier
 *  javassist.NotFoundException
 *  javassist.Translator
 *  javassist.bytecode.Descriptor
 */
package tools.reflection.classLoading;

import ioBase.CppInSerializable;
import ioBase.NotOptimized;
import ioBase.SerializationDataInput;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.Modifier;
import javassist.NotFoundException;
import javassist.Translator;
import javassist.bytecode.Descriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class r
implements Translator {
    @NotNull
    private static final CtClass[] a = new CtClass[0];
    @Nullable
    private String b = null;
    @NotNull
    private final String c = Descriptor.ofConstructor((CtClass[])a);
    @Nullable
    private CtClass d = null;

    public void start(@NotNull ClassPool classPool) {
    }

    public void onLoad(@NotNull ClassPool classPool, @NotNull String string) throws NotFoundException {
        boolean bl;
        CtClass ctClass;
        if (this.d == null || this.b == null) {
            try {
                this.d = classPool.get(CppInSerializable.class.getCanonicalName());
                ctClass = classPool.get(SerializationDataInput.class.getCanonicalName());
                this.b = Descriptor.ofConstructor((CtClass[])new CtClass[]{ctClass});
            }
            catch (IllegalStateException illegalStateException) {
                return;
            }
        }
        boolean bl2 = !(ctClass = classPool.get(string)).hasAnnotation(NotOptimized.class);
        int n2 = ctClass.getModifiers();
        boolean bl3 = bl = Modifier.isInterface((int)n2) || Modifier.isAbstract((int)n2);
        if (bl2 && !bl && ctClass.subtypeOf(this.d)) {
            try {
                CtConstructor ctConstructor = ctClass.getConstructor(this.b);
                ctClass.setModifiers(Modifier.setPublic((int)n2));
                ctConstructor.setModifiers(Modifier.setPublic((int)ctConstructor.getModifiers()));
                CtConstructor ctConstructor2 = ctClass.getConstructor(this.c);
                ctConstructor2.setModifiers(Modifier.setPublic((int)ctConstructor2.getModifiers()));
            }
            catch (NotFoundException notFoundException) {
                // empty catch block
            }
        }
    }
}

