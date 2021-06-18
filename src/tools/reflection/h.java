/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection;

import asserts.Verify;
import gnu.trove.TByteByteHashMap;
import gnu.trove.TByteDoubleHashMap;
import gnu.trove.TByteFloatHashMap;
import gnu.trove.TByteIntHashMap;
import gnu.trove.TByteLongHashMap;
import gnu.trove.TByteShortHashMap;
import gnu.trove.TDoubleByteHashMap;
import gnu.trove.TDoubleDoubleHashMap;
import gnu.trove.TDoubleFloatHashMap;
import gnu.trove.TDoubleIntHashMap;
import gnu.trove.TDoubleLongHashMap;
import gnu.trove.TDoubleShortHashMap;
import gnu.trove.TFloatByteHashMap;
import gnu.trove.TFloatDoubleHashMap;
import gnu.trove.TFloatFloatHashMap;
import gnu.trove.TFloatIntHashMap;
import gnu.trove.TFloatLongHashMap;
import gnu.trove.TFloatShortHashMap;
import gnu.trove.TIntByteHashMap;
import gnu.trove.TIntDoubleHashMap;
import gnu.trove.TIntFloatHashMap;
import gnu.trove.TIntIntHashMap;
import gnu.trove.TIntLongHashMap;
import gnu.trove.TIntShortHashMap;
import gnu.trove.TLongByteHashMap;
import gnu.trove.TLongDoubleHashMap;
import gnu.trove.TLongFloatHashMap;
import gnu.trove.TLongIntHashMap;
import gnu.trove.TLongLongHashMap;
import gnu.trove.TLongShortHashMap;
import gnu.trove.TObjectByteHashMap;
import gnu.trove.TObjectDoubleHashMap;
import gnu.trove.TObjectFloatHashMap;
import gnu.trove.TObjectIntHashMap;
import gnu.trove.TObjectLongHashMap;
import gnu.trove.TObjectShortHashMap;
import gnu.trove.TShortByteHashMap;
import gnu.trove.TShortDoubleHashMap;
import gnu.trove.TShortFloatHashMap;
import gnu.trove.TShortIntHashMap;
import gnu.trove.TShortLongHashMap;
import gnu.trove.TShortShortHashMap;
import gnu.trove.decorator.TByteByteHashMapDecorator;
import gnu.trove.decorator.TByteDoubleHashMapDecorator;
import gnu.trove.decorator.TByteFloatHashMapDecorator;
import gnu.trove.decorator.TByteIntHashMapDecorator;
import gnu.trove.decorator.TByteLongHashMapDecorator;
import gnu.trove.decorator.TByteShortHashMapDecorator;
import gnu.trove.decorator.TDoubleByteHashMapDecorator;
import gnu.trove.decorator.TDoubleDoubleHashMapDecorator;
import gnu.trove.decorator.TDoubleFloatHashMapDecorator;
import gnu.trove.decorator.TDoubleIntHashMapDecorator;
import gnu.trove.decorator.TDoubleLongHashMapDecorator;
import gnu.trove.decorator.TDoubleShortHashMapDecorator;
import gnu.trove.decorator.TFloatByteHashMapDecorator;
import gnu.trove.decorator.TFloatDoubleHashMapDecorator;
import gnu.trove.decorator.TFloatFloatHashMapDecorator;
import gnu.trove.decorator.TFloatIntHashMapDecorator;
import gnu.trove.decorator.TFloatLongHashMapDecorator;
import gnu.trove.decorator.TFloatShortHashMapDecorator;
import gnu.trove.decorator.TIntByteHashMapDecorator;
import gnu.trove.decorator.TIntDoubleHashMapDecorator;
import gnu.trove.decorator.TIntFloatHashMapDecorator;
import gnu.trove.decorator.TIntIntHashMapDecorator;
import gnu.trove.decorator.TIntLongHashMapDecorator;
import gnu.trove.decorator.TIntShortHashMapDecorator;
import gnu.trove.decorator.TLongByteHashMapDecorator;
import gnu.trove.decorator.TLongDoubleHashMapDecorator;
import gnu.trove.decorator.TLongFloatHashMapDecorator;
import gnu.trove.decorator.TLongIntHashMapDecorator;
import gnu.trove.decorator.TLongLongHashMapDecorator;
import gnu.trove.decorator.TLongShortHashMapDecorator;
import gnu.trove.decorator.TObjectByteHashMapDecorator;
import gnu.trove.decorator.TObjectDoubleHashMapDecorator;
import gnu.trove.decorator.TObjectFloatHashMapDecorator;
import gnu.trove.decorator.TObjectIntHashMapDecorator;
import gnu.trove.decorator.TObjectLongHashMapDecorator;
import gnu.trove.decorator.TObjectShortHashMapDecorator;
import gnu.trove.decorator.TShortByteHashMapDecorator;
import gnu.trove.decorator.TShortDoubleHashMapDecorator;
import gnu.trove.decorator.TShortFloatHashMapDecorator;
import gnu.trove.decorator.TShortIntHashMapDecorator;
import gnu.trove.decorator.TShortLongHashMapDecorator;
import gnu.trove.decorator.TShortShortHashMapDecorator;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import tools.reflection.cb;

public final class h {
    @NotNull
    public static String a(@NotNull Object object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(object.getClass().getName()).append('\n');
        stringBuilder.append(object).append('\n');
        if (object instanceof Collection) {
            for (Object e2 : (Collection)object) {
                stringBuilder.append("  ").append(e2).append('\n');
            }
            return stringBuilder.toString();
        }
        if (h.j(object, stringBuilder)) {
            return stringBuilder.toString();
        }
        if (h.a(object, stringBuilder)) {
            return stringBuilder.toString();
        }
        h.a(stringBuilder, object);
        return stringBuilder.toString();
    }

    private static boolean a(@NotNull Object object, @NotNull StringBuilder stringBuilder) {
        if (h.i(object, stringBuilder)) {
            return true;
        }
        if (h.b(object, stringBuilder)) {
            return true;
        }
        if (h.c(object, stringBuilder)) {
            return true;
        }
        if (h.d(object, stringBuilder)) {
            return true;
        }
        if (h.e(object, stringBuilder)) {
            return true;
        }
        if (h.f(object, stringBuilder)) {
            return true;
        }
        if (h.g(object, stringBuilder)) {
            return true;
        }
        return h.h(object, stringBuilder);
    }

    private static boolean b(@NotNull Object object, @NotNull StringBuilder stringBuilder) {
        if (object instanceof TObjectByteHashMap && h.i(new TObjectByteHashMapDecorator((TObjectByteHashMap)object), stringBuilder)) {
            return true;
        }
        if (object instanceof TObjectShortHashMap && h.i(new TObjectShortHashMapDecorator((TObjectShortHashMap)object), stringBuilder)) {
            return true;
        }
        if (object instanceof TObjectIntHashMap && h.i(new TObjectIntHashMapDecorator((TObjectIntHashMap)object), stringBuilder)) {
            return true;
        }
        if (object instanceof TObjectLongHashMap && h.i(new TObjectLongHashMapDecorator((TObjectLongHashMap)object), stringBuilder)) {
            return true;
        }
        if (object instanceof TObjectFloatHashMap && h.i(new TObjectFloatHashMapDecorator((TObjectFloatHashMap)object), stringBuilder)) {
            return true;
        }
        return object instanceof TObjectDoubleHashMap && h.i(new TObjectDoubleHashMapDecorator((TObjectDoubleHashMap)object), stringBuilder);
    }

    private static boolean c(@NotNull Object object, @NotNull StringBuilder stringBuilder) {
        if (object instanceof TByteByteHashMap && h.i(new TByteByteHashMapDecorator((TByteByteHashMap)object), stringBuilder)) {
            return true;
        }
        if (object instanceof TByteShortHashMap && h.i(new TByteShortHashMapDecorator((TByteShortHashMap)object), stringBuilder)) {
            return true;
        }
        if (object instanceof TByteIntHashMap && h.i(new TByteIntHashMapDecorator((TByteIntHashMap)object), stringBuilder)) {
            return true;
        }
        if (object instanceof TByteLongHashMap && h.i(new TByteLongHashMapDecorator((TByteLongHashMap)object), stringBuilder)) {
            return true;
        }
        if (object instanceof TByteFloatHashMap && h.i(new TByteFloatHashMapDecorator((TByteFloatHashMap)object), stringBuilder)) {
            return true;
        }
        return object instanceof TByteDoubleHashMap && h.i(new TByteDoubleHashMapDecorator((TByteDoubleHashMap)object), stringBuilder);
    }

    private static boolean d(@NotNull Object object, @NotNull StringBuilder stringBuilder) {
        if (object instanceof TShortByteHashMap && h.i(new TShortByteHashMapDecorator((TShortByteHashMap)object), stringBuilder)) {
            return true;
        }
        if (object instanceof TShortShortHashMap && h.i(new TShortShortHashMapDecorator((TShortShortHashMap)object), stringBuilder)) {
            return true;
        }
        if (object instanceof TShortIntHashMap && h.i(new TShortIntHashMapDecorator((TShortIntHashMap)object), stringBuilder)) {
            return true;
        }
        if (object instanceof TShortLongHashMap && h.i(new TShortLongHashMapDecorator((TShortLongHashMap)object), stringBuilder)) {
            return true;
        }
        if (object instanceof TShortFloatHashMap && h.i(new TShortFloatHashMapDecorator((TShortFloatHashMap)object), stringBuilder)) {
            return true;
        }
        return object instanceof TShortDoubleHashMap && h.i(new TShortDoubleHashMapDecorator((TShortDoubleHashMap)object), stringBuilder);
    }

    private static boolean e(@NotNull Object object, @NotNull StringBuilder stringBuilder) {
        if (object instanceof TIntByteHashMap && h.i(new TIntByteHashMapDecorator((TIntByteHashMap)object), stringBuilder)) {
            return true;
        }
        if (object instanceof TIntShortHashMap && h.i(new TIntShortHashMapDecorator((TIntShortHashMap)object), stringBuilder)) {
            return true;
        }
        if (object instanceof TIntIntHashMap && h.i(new TIntIntHashMapDecorator((TIntIntHashMap)object), stringBuilder)) {
            return true;
        }
        if (object instanceof TIntLongHashMap && h.i(new TIntLongHashMapDecorator((TIntLongHashMap)object), stringBuilder)) {
            return true;
        }
        if (object instanceof TIntFloatHashMap && h.i(new TIntFloatHashMapDecorator((TIntFloatHashMap)object), stringBuilder)) {
            return true;
        }
        return object instanceof TIntDoubleHashMap && h.i(new TIntDoubleHashMapDecorator((TIntDoubleHashMap)object), stringBuilder);
    }

    private static boolean f(@NotNull Object object, @NotNull StringBuilder stringBuilder) {
        if (object instanceof TLongByteHashMap && h.i(new TLongByteHashMapDecorator((TLongByteHashMap)object), stringBuilder)) {
            return true;
        }
        if (object instanceof TLongShortHashMap && h.i(new TLongShortHashMapDecorator((TLongShortHashMap)object), stringBuilder)) {
            return true;
        }
        if (object instanceof TLongIntHashMap && h.i(new TLongIntHashMapDecorator((TLongIntHashMap)object), stringBuilder)) {
            return true;
        }
        if (object instanceof TLongLongHashMap && h.i(new TLongLongHashMapDecorator((TLongLongHashMap)object), stringBuilder)) {
            return true;
        }
        if (object instanceof TLongFloatHashMap && h.i(new TLongFloatHashMapDecorator((TLongFloatHashMap)object), stringBuilder)) {
            return true;
        }
        return object instanceof TLongDoubleHashMap && h.i(new TLongDoubleHashMapDecorator((TLongDoubleHashMap)object), stringBuilder);
    }

    private static boolean g(@NotNull Object object, @NotNull StringBuilder stringBuilder) {
        if (object instanceof TFloatByteHashMap && h.i(new TFloatByteHashMapDecorator((TFloatByteHashMap)object), stringBuilder)) {
            return true;
        }
        if (object instanceof TFloatShortHashMap && h.i(new TFloatShortHashMapDecorator((TFloatShortHashMap)object), stringBuilder)) {
            return true;
        }
        if (object instanceof TFloatIntHashMap && h.i(new TFloatIntHashMapDecorator((TFloatIntHashMap)object), stringBuilder)) {
            return true;
        }
        if (object instanceof TFloatLongHashMap && h.i(new TFloatLongHashMapDecorator((TFloatLongHashMap)object), stringBuilder)) {
            return true;
        }
        if (object instanceof TFloatFloatHashMap && h.i(new TFloatFloatHashMapDecorator((TFloatFloatHashMap)object), stringBuilder)) {
            return true;
        }
        return object instanceof TFloatDoubleHashMap && h.i(new TFloatDoubleHashMapDecorator((TFloatDoubleHashMap)object), stringBuilder);
    }

    private static boolean h(@NotNull Object object, @NotNull StringBuilder stringBuilder) {
        if (object instanceof TDoubleByteHashMap && h.i(new TDoubleByteHashMapDecorator((TDoubleByteHashMap)object), stringBuilder)) {
            return true;
        }
        if (object instanceof TDoubleShortHashMap && h.i(new TDoubleShortHashMapDecorator((TDoubleShortHashMap)object), stringBuilder)) {
            return true;
        }
        if (object instanceof TDoubleIntHashMap && h.i(new TDoubleIntHashMapDecorator((TDoubleIntHashMap)object), stringBuilder)) {
            return true;
        }
        if (object instanceof TDoubleLongHashMap && h.i(new TDoubleLongHashMapDecorator((TDoubleLongHashMap)object), stringBuilder)) {
            return true;
        }
        if (object instanceof TDoubleFloatHashMap && h.i(new TDoubleFloatHashMapDecorator((TDoubleFloatHashMap)object), stringBuilder)) {
            return true;
        }
        return object instanceof TDoubleDoubleHashMap && h.i(new TDoubleDoubleHashMapDecorator((TDoubleDoubleHashMap)object), stringBuilder);
    }

    private static boolean i(@NotNull Object object, @NotNull StringBuilder stringBuilder) {
        if (object instanceof Map) {
            Map map = (Map)object;
            int n2 = 0;
            for (Object o : map.entrySet()) {
            	Map.Entry entry = (Map.Entry) o;
                stringBuilder.append("  ").append(entry.getKey()).append(" [").append(n2).append("]=> ").append(entry.getValue()).append('\n');
                ++n2;
            }
            return true;
        }
        return false;
    }

    private static boolean j(@NotNull Object object, @NotNull StringBuilder stringBuilder) {
        if (h.k(object, stringBuilder)) {
            return true;
        }
        if (h.l(object, stringBuilder)) {
            return true;
        }
        if (h.m(object, stringBuilder)) {
            return true;
        }
        if (h.n(object, stringBuilder)) {
            return true;
        }
        if (h.o(object, stringBuilder)) {
            return true;
        }
        if (h.p(object, stringBuilder)) {
            return true;
        }
        if (h.q(object, stringBuilder)) {
            return true;
        }
        if (h.q(object, stringBuilder)) {
            return true;
        }
        return h.r(object, stringBuilder);
    }

    private static boolean k(@NotNull Object object, @NotNull StringBuilder stringBuilder) {
        if (object instanceof Object[]) {
            for (Object object2 : (Object[])object) {
                stringBuilder.append("  ").append(object2).append('\n');
            }
            return true;
        }
        return false;
    }

    private static boolean l(@NotNull Object object, @NotNull StringBuilder stringBuilder) {
        if (object instanceof byte[]) {
            for (byte by : (byte[])object) {
                stringBuilder.append("  ").append(by).append('\n');
            }
            return true;
        }
        return false;
    }

    private static boolean m(@NotNull Object object, @NotNull StringBuilder stringBuilder) {
        if (object instanceof short[]) {
            for (short s2 : (short[])object) {
                stringBuilder.append("  ").append(s2).append('\n');
            }
            return true;
        }
        return false;
    }

    private static boolean n(@NotNull Object object, @NotNull StringBuilder stringBuilder) {
        if (object instanceof int[]) {
            for (int n2 : (int[])object) {
                stringBuilder.append("  ").append(n2).append('\n');
            }
            return true;
        }
        return false;
    }

    private static boolean o(@NotNull Object object, @NotNull StringBuilder stringBuilder) {
        if (object instanceof long[]) {
            for (long l2 : (long[])object) {
                stringBuilder.append("  ").append(l2).append('\n');
            }
            return true;
        }
        return false;
    }

    private static boolean p(@NotNull Object object, @NotNull StringBuilder stringBuilder) {
        if (object instanceof float[]) {
            for (float f2 : (float[])object) {
                stringBuilder.append("  ").append(f2).append('\n');
            }
            return true;
        }
        return false;
    }

    private static boolean q(@NotNull Object object, @NotNull StringBuilder stringBuilder) {
        if (object instanceof double[]) {
            for (double d2 : (double[])object) {
                stringBuilder.append("  ").append(d2).append('\n');
            }
            return true;
        }
        return false;
    }

    private static boolean r(@NotNull Object object, @NotNull StringBuilder stringBuilder) {
        if (object instanceof char[]) {
            for (char c2 : (char[])object) {
                stringBuilder.append("  ").append(c2).append('\n');
            }
            return true;
        }
        return false;
    }

    private static void a(@NotNull StringBuilder stringBuilder, @NotNull Object object) {
        List<Class<?>> list = cb.b(object);
        for (Class<?> clazz : list) {
            for (Field field : clazz.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers()) || field.getName().equals("replicator")) continue;
                stringBuilder.append("  ").append(field.getName()).append(" = ");
                try {
                    stringBuilder.append(String.valueOf(cb.a(object, field)));
                }
                catch (cb.b_ b_2) {
                    Verify.fail(b_2);
                }
                stringBuilder.append('\n');
            }
        }
    }

    @NotNull
    public static String a(@NotNull Object object, @NotNull String[] stringArray) {
        Object object2;
        try {
            object2 = cb.a(object, stringArray);
        }
        catch (cb.b_ b_2) {
            Verify.fail("can't get last field", b_2);
            object2 = null;
        }
        return object2 == null ? "invalid field" : h.a(object2);
    }

    private h() {
    }
}

