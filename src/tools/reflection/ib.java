/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection;

import java.net.URI;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import org.jetbrains.annotations.NotNull;

public final class ib
extends SimpleJavaFileObject {
    @NotNull
    private final String a;
    @NotNull
    private final String b;

    public ib(@NotNull String string, @NotNull String string2) {
        super(URI.create("string:///" + string.replace('.', '/') + JavaFileObject.Kind.SOURCE.extension), JavaFileObject.Kind.SOURCE);
        this.b = string;
        this.a = string2;
    }

    @Override
    @NotNull
    public CharSequence getCharContent(boolean bl) {
        return this.a;
    }

    @NotNull
    public String a() {
        return this.b;
    }
}

