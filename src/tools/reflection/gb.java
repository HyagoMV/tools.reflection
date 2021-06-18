/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection;

import gnu.trove.THashMap;
import gnu.trove.TObjectProcedure;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.StandardLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tools.containers.mb;
import tools.reflection.g;
import tools.reflection.hb;

final class gb
extends ForwardingJavaFileManager<JavaFileManager> {
    @NotNull
    private final Map<String, hb> a = new THashMap<String, hb>();
    @Nullable
    private TObjectProcedure<hb> b;

    gb(@NotNull JavaFileManager javaFileManager) {
        super(javaFileManager);
    }

    @Override
    @NotNull
    public JavaFileObject getJavaFileForOutput(@Nullable JavaFileManager.Location location, @NotNull String string, @NotNull JavaFileObject.Kind kind, @NotNull FileObject fileObject) {
        hb hb2 = new hb(string, kind);
        this.a.put(string, hb2);
        if (this.b != null) {
            this.b.execute(hb2);
        }
        return hb2;
    }

    @Override
    @NotNull
    public Iterable<JavaFileObject> list(@NotNull JavaFileManager.Location location, @NotNull String string, @NotNull Set<JavaFileObject.Kind> set, boolean bl) throws IOException {
        Iterable<JavaFileObject> iterable = this.a(location, super.list(location, string, set, bl));
        if (location != StandardLocation.CLASS_PATH || !set.contains((Object)JavaFileObject.Kind.CLASS) || this.a.isEmpty()) {
            return iterable;
        }
        ArrayList<hb> arrayList = new ArrayList<hb>();
        for (Map.Entry<String, hb> entry : this.a.entrySet()) {
            String string2 = entry.getKey();
            int n2 = string2.lastIndexOf(46);
            if (n2 <= 0 || !string.equals(string2.substring(0, n2))) continue;
            arrayList.add(entry.getValue());
        }
        return mb.a(arrayList, iterable);
    }

    @Override
    @NotNull
    public String inferBinaryName(@NotNull JavaFileManager.Location location, @NotNull JavaFileObject javaFileObject) {
        if (javaFileObject instanceof hb) {
            return ((hb)javaFileObject).b();
        }
        if (javaFileObject instanceof g) {
            return super.inferBinaryName(location, ((g)javaFileObject).a());
        }
        return super.inferBinaryName(location, javaFileObject);
    }

    void a(@Nullable TObjectProcedure<hb> tObjectProcedure) {
        this.b = tObjectProcedure;
    }

    @NotNull
    private Iterable<JavaFileObject> a(@NotNull JavaFileManager.Location location, @NotNull Iterable<JavaFileObject> iterable) {
        ArrayList<JavaFileObject> arrayList = new ArrayList<JavaFileObject>();
        for (JavaFileObject javaFileObject : iterable) {
            arrayList.add(new g(this.inferBinaryName(location, javaFileObject), javaFileObject));
        }
        return arrayList;
    }

    public void a(@NotNull hb[] hbArray) {
        for (hb hb2 : hbArray) {
            this.a.put(hb2.b(), hb2);
        }
    }
}

