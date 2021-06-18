/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  ru.mail.org.objectweb.asm.Label
 *  ru.mail.org.objectweb.asm.MethodVisitor
 */
package tools.reflection.objectsFactory;

import asserts.Verify;
import gnu.trove.TIntArrayList;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;
import ru.mail.org.objectweb.asm.Label;
import ru.mail.org.objectweb.asm.MethodVisitor;

public abstract class z {
    public static final int a = 255;
    @NotNull
    private final int[] b;
    @NotNull
    private final int[] c;
    @NotNull
    private final String d;

    public z(@NotNull int[] nArray, @NotNull String string) {
        this.b = Arrays.copyOf(nArray, nArray.length);
        this.d = string;
        Arrays.sort(this.b);
        this.c = z.a(this.b);
    }

    @NotNull
    private static int[] a(@NotNull int[] nArray) {
        int n2 = nArray[nArray.length - 1] / 255 + 1;
        TIntArrayList tIntArrayList = new TIntArrayList(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3;
            int n4 = z.a(nArray, 255 * i2);
            if (n4 == (n3 = z.a(nArray, 255 * (i2 + 1)))) continue;
            tIntArrayList.add(i2);
        }
        return tIntArrayList.toNativeArray();
    }

    @NotNull
    public int[] a() {
        return this.b;
    }

    @NotNull
    public int[] b() {
        return this.c;
    }

    @NotNull
    public String c() {
        return this.d;
    }

    public void a(@NotNull MethodVisitor methodVisitor) {
        int n2;
        Label label = new Label();
        int n3 = this.c.length;
        this.onOuterLoadId(methodVisitor);
        methodVisitor.visitLdcInsn((Object)255);
        methodVisitor.visitInsn(108);
        Label[] labelArray = new Label[n3];
        for (n2 = 0; n2 < n3; ++n2) {
            labelArray[n2] = new Label();
        }
        methodVisitor.visitLookupSwitchInsn(label, this.c, labelArray);
        for (n2 = 0; n2 < n3; ++n2) {
            methodVisitor.visitLabel(labelArray[n2]);
            this.onOuterCase(methodVisitor, this.c[n2]);
        }
        methodVisitor.visitLabel(label);
        this.onOuterDefaultCase(methodVisitor);
    }

    public void a(@NotNull MethodVisitor methodVisitor, int n2) {
        int n3 = z.a(this.b, 255 * n2);
        int n4 = z.a(this.b, 255 * (n2 + 1));
        int n5 = n4 - n3;
        if (n5 > 0) {
            Label[] labelArray = new Label[n5];
            for (int i2 = 0; i2 < n5; ++i2) {
                labelArray[i2] = new Label();
            }
            Label label = new Label();
            this.onInnerLoadId(methodVisitor);
            methodVisitor.visitLookupSwitchInsn(label, Arrays.copyOfRange(this.b, n3, n4), labelArray);
            for (int i3 = 0; i3 < n5; ++i3) {
                int n6 = this.b[i3 + n3];
                methodVisitor.visitLabel(labelArray[i3]);
                this.onInnerCase(methodVisitor, n6);
            }
            methodVisitor.visitLabel(label);
        } else {
            Verify.fail("No cases for inner switch");
        }
        this.onInnerDefaultCase(methodVisitor);
    }

    private static int a(@NotNull int[] nArray, int n2) {
        int n3 = Arrays.binarySearch(nArray, n2);
        if (n3 < 0) {
            return -n3 - 1;
        }
        return n3;
    }

    protected abstract void onOuterLoadId(@NotNull MethodVisitor var1);

    protected abstract void onOuterCase(@NotNull MethodVisitor var1, int var2);

    protected abstract void onOuterDefaultCase(@NotNull MethodVisitor var1);

    protected abstract void onInnerCase(@NotNull MethodVisitor var1, int var2);

    protected abstract void onInnerDefaultCase(@NotNull MethodVisitor var1);

    protected abstract void onInnerLoadId(@NotNull MethodVisitor var1);
}

