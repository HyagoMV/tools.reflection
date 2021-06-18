/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.Level
 */
package tools.reflection.classLoading;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import org.apache.log4j.Level;
import org.jetbrains.annotations.NotNull;
import tools.reflection.classLoading.p;

public final class o {
    @NotNull
    private static final p[] a = new p[]{p.a};
    @NotNull
    private final File b;
    @NotNull
    private final p[] c;
    private final boolean d;

    public o(@NotNull String string) {
        this(string, p.a);
    }

    public o(@NotNull String string, @NotNull o o2) {
        this.b = o.b(string);
        this.c = o2.c;
        this.d = o2.d;
    }

    public o(@NotNull String string, p ... pArray) {
        this(o.b(string), pArray);
    }

    public o(@NotNull File file) {
        this(file, a);
    }

    public o(@NotNull File file, p ... pArray) {
        this(file, true, pArray);
    }

    public o(@NotNull File file, boolean bl, p ... pArray) {
        this.c = pArray;
        this.b = file;
        this.d = bl;
    }

    public String toString() {
        return String.format("%s|%s", this.b.getAbsolutePath(), Arrays.toString(this.c));
    }

    @NotNull
    public File a() {
        return this.b;
    }

    public boolean a(@NotNull String string) {
        return string.contains(this.b.getPath().replace('\\', '/'));
    }

    public boolean a(@NotNull CharSequence charSequence) {
        for (p p2 : this.c) {
            if (!p2.a(charSequence)) continue;
            return true;
        }
        return false;
    }

    @NotNull
    public FilenameFilter b() {
        return new FilenameFilter(){

            @Override
            public boolean accept(@NotNull File file, @NotNull String string) {
                String string2 = new File(file, string).getAbsolutePath();
                return o.this.a((CharSequence)string2);
            }
        };
    }

    @NotNull
    public p[] c() {
        return this.c;
    }

    @NotNull
    public Level d() {
        String string = this.b.getAbsolutePath();
        for (p p2 : this.c) {
            if (!p2.a(string)) continue;
            return p2.a();
        }
        return p.a.a();
    }

    public boolean e() {
        return this.d;
    }

    @NotNull
    private static File b(@NotNull String string) {
        return new File(string.replace('\\', '/'));
    }
}

