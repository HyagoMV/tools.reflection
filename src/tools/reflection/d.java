/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.apache.commons.lang.StringUtils
 *  org.apache.log4j.Logger
 */
package tools.reflection;

import gnu.trove.THashMap;
import gnu.trove.TObjectProcedure;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.tools.Diagnostic;
import javax.tools.DiagnosticListener;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tools.ec;
import tools.reflection.a;
import tools.reflection.b;
import tools.reflection.c;
import tools.reflection.classLoading.l;
import tools.reflection.gb;
import tools.reflection.hb;
import tools.reflection.ib;

@system.c
public final class d {
    @NotNull
    private static final Object a = new Object();
    @NotNull
    private static final Logger b = Logger.getLogger(d.class);
    @Nullable
    private static d c = null;
    @NotNull
    private final Collection<String> d = new ArrayList<String>();
    @NotNull
    private final JavaCompiler e;
    @NotNull
    private final a f;
    @NotNull
    private final gb g;
    @NotNull
    private final c h = new c();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NotNull
    public static d a() {
        Object object = a;
        synchronized (object) {
            if (c == null) {
                c = new d();
            }
            return c;
        }
    }

    private d() {
        this.f = new a();
        this.d.add("-g");
        Object[] objectArray = l.a();
        if (objectArray.length > 0) {
            this.d.add("-classpath");
            this.d.add(StringUtils.join((Object[])objectArray, (String)File.pathSeparator));
        }
        b.info((Object)("Using compiler options: " + Arrays.toString(this.d.toArray(new String[this.d.size()]))));
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        if (javaCompiler == null) {
            throw new IllegalStateException("System java compiler not found. Possibly we run under JRE, not JDK");
        }
        this.e = javaCompiler;
        this.g = new gb(this.e.getStandardFileManager(null, null, Charset.defaultCharset()));
    }

    @NotNull
    public synchronized Collection<Class<?>> a(@NotNull ib ib2) throws b {
        Object object;
        String string;
        String string2 = ib2.a();
        hb[] hbArray = this.h.a(string2, string = new StringBuilder(ib2.getCharContent(false)).toString());
        if (hbArray != null) {
            this.g.a(hbArray);
        } else {
            object = new b_();
            this.g.a((TObjectProcedure<hb>)object);
            c_ c_2 = new c_();
            int n2 = this.e.getTask(null, this.g, c_2, this.d, null, Arrays.asList(ib2)).call().booleanValue() ? 1 : 0;
            hbArray = ((b_)object).a();
            if (n2 == 0) {
                throw new b('\n' + tools.reflection.d.a(c_2.a(), ib2));
            }
            this.h.a(string2, string, hbArray);
        }
        List list = new ArrayList(hbArray.length);
        for (hb hb2 : hbArray) {
            Class<?> clazz = this.f.a(hb2.b(), hb2.a());
            list.add(clazz);
        }
        return list;
    }

    @NotNull
    public Class<?> a(@NotNull String string) throws ClassNotFoundException {
        return this.f.loadClass(string);
    }

    @NotNull
    private static String a(@NotNull Iterable<Diagnostic<? extends JavaFileObject>> iterable, @NotNull ib ib2) {
        ArrayList<ec> arrayList;
        Object object;
        Diagnostic<? extends JavaFileObject> diagnostic2;
        THashMap<Object, ArrayList<ec>> tHashMap = new THashMap<Object, ArrayList<ec>>();
        for (Diagnostic<? extends JavaFileObject> diagnostic21 : iterable) {
            object = diagnostic21.getSource();
            arrayList = (ArrayList<ec>)tHashMap.get(object);
            if (arrayList == null) {
                arrayList = new ArrayList<ec>();
                tHashMap.put(object, arrayList);
            }
            
            long l2 = diagnostic21.getStartPosition();
            long l3 = diagnostic21.getPosition();
            long l4 = diagnostic21.getEndPosition();
            if (l2 < 0L || l3 < 0L || l4 < 0L) continue;
            arrayList.add((ec)((Object)new d_(l2, l3, l4, diagnostic21.getMessage(null), diagnostic21.getCode(), diagnostic21.getKind())));
        }
        StringBuilder stringBuilder = new StringBuilder();
        CharSequence diagnostic22 = ib2.getCharContent(true);
        List list = (List)tHashMap.get(ib2);
        if (list == null || list.isEmpty()) {
            return "";
        }
        arrayList = new ArrayList(3 * list.size());
        StringBuilder stringBuilder2 = new StringBuilder((CharSequence)((Object)diagnostic22));
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            d_ d_2 = (d_)iterator.next();
            stringBuilder2.insert(tools.reflection.d.a(arrayList, d_2.a(), 3), "<<<");
            stringBuilder2.insert(tools.reflection.d.a(arrayList, d_2.b(), 3), "!!!");
            stringBuilder2.insert(tools.reflection.d.a(arrayList, d_2.c(), 3), ">>>");
            stringBuilder.append(d_2).append('\n');
        }
        stringBuilder.append("Source:\n").append((CharSequence)stringBuilder2).append((CharSequence)stringBuilder2).append('\n').append(StringUtils.repeat((String)"-", (int)100)).append('\n');
        return stringBuilder.toString();
    }

    private static int a(@NotNull Collection<ec> collection, int n2, int n3) {
        int n4 = 0;
        for (ec ec2 : collection) {
            if (ec2.a() > n2) continue;
            n4 += ec2.b();
        }
        collection.add(ec.a(n2, n3));
        return n4 + n2;
    }

    private static final class b_
    implements TObjectProcedure<hb> {
        @NotNull
        private final Collection<hb> a = new ArrayList<hb>();

        private b_() {
        }

        public boolean execute(@NotNull hb hb2) {
            this.a.add(hb2);
            return true;
        }

        @NotNull
        public hb[] a() {
            return this.a.toArray(new hb[this.a.size()]);
        }

    }

    private static final class c_
    implements DiagnosticListener<JavaFileObject> {
        @NotNull
        private List<Diagnostic<? extends JavaFileObject>> a = new ArrayList<Diagnostic<? extends JavaFileObject>>();

        private c_() {
        }

        @Override
        public void report(@NotNull Diagnostic<? extends JavaFileObject> diagnostic) {
            this.a.add(diagnostic);
        }

        @NotNull
        public List<Diagnostic<? extends JavaFileObject>> a() {
            return this.a;
        }
    }

    private static final class d_ {
        private final long a;
        private final long b;
        private final long c;
        @NotNull
        private final String d;
        @NotNull
        private final String e;
        @NotNull
        private final Diagnostic.Kind f;

        public d_(long l2, long l3, long l4, @NotNull String string, @NotNull String string2, @NotNull Diagnostic.Kind kind) {
            this.a = l2;
            this.b = l3;
            this.c = l4;
            ArrayDeque<String> arrayDeque = new ArrayDeque<String>(Arrays.asList(StringUtils.split((String)string, (String)"\n")));
            this.d = arrayDeque.pop() + (arrayDeque.isEmpty() ? "" : String.format(" (%s)", StringUtils.join(arrayDeque, (String)", ")));
            this.e = string2;
            this.f = kind;
        }

        public int a() {
            return (int)this.a;
        }

        public int b() {
            return (int)this.b;
        }

        public int c() {
            return (int)this.c;
        }

        public String toString() {
            return String.format("%s! [%s] %s: (%d-%d)", new Object[]{this.f, this.e, this.d, this.a, this.c});
        }
    }
}

