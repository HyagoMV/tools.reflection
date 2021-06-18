/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.Logger
 */
package tools.reflection.objectsFactory;

import asserts.Verify;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tools.reflection.cb;
import tools.reflection.classLoading.h;
import tools.reflection.objectsFactory.j;
import tools.reflection.objectsFactory.w;
import tools.reflection.objectsFactory.y;
import tools.wb;

public final class x {
    @NotNull
    public static final Logger a = Logger.getLogger(x.class);
    @Nullable
    private static j b = null;
    private static int c = 0;
    @NotNull
    private static final List<wb<Integer, j.a_>> d = new ArrayList<wb<Integer, j.a_>>();
    public static final int e = 100;

    private x() {
    }

    @NotNull
    public static j a() {
        return x.a(false);
    }

    @NotNull
    public static j a(boolean bl) {
        boolean bl2 = x.c();
        if (bl || b == null || h.c().h() || bl2 && b instanceof y) {
            wb[] wbArray = d.toArray(new wb[d.size()]);
            c = x.b();
            b = bl2 ? new w(wbArray) : new y(wbArray);
        }
        return b;
    }

    private static int b() {
        if (!h.a()) {
            return 0;
        }
        return h.c().g();
    }

    private static boolean c() {
        return h.a() && h.c() instanceof tools.reflection.classLoading.j;
    }

    private static void a(int n2, @NotNull String string, Object ... objectArray) {
        j j2 = b;
        if (j2 == null) {
            throw new IllegalStateException("ObjectSerializator instance is null");
        }
        try {
            Class<?> clazz = Class.forName(string);
            j.a_ a_2 = (j.a_)cb.a(clazz, objectArray);
            d.add(wb.b(n2, a_2));
            j2.a(n2, a_2);
        }
        catch (ClassNotFoundException classNotFoundException) {
        }
        catch (cb.b_ b_2) {
            Verify.fail(b_2);
        }
    }

    @NotNull
    public static j d() {
        return b;
    }

    static {
        try {
            j j2 = x.a();
            x.a(1, "tools.geometry.mb", new Object[0]);
            x.a(100, "resourceDB.mb", new Object[0]);
            x.a(110, "rpcProtocol.impl.RpcServiceCodec", new Object[0]);
            j2.a();
        }
        catch (Throwable throwable) {
            Verify.fail("Can't initialize ObjSerializatorFactory", throwable);
            throw throwable;
        }
    }
}

