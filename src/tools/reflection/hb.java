/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class hb
extends SimpleJavaFileObject {
    @NotNull
    private final String a;
    @NotNull
    private final ByteArrayOutputStream b = new ByteArrayOutputStream();

    public hb(@NotNull String string, @NotNull JavaFileObject.Kind kind) {
        super(URI.create("string:///" + string.replace('.', '/') + kind.extension), kind);
        this.a = string;
    }

    @Override
    @Nullable
    public InputStream openInputStream() {
        return new ByteArrayInputStream(this.a());
    }

    @Override
    @NotNull
    public OutputStream openOutputStream() {
        return this.b;
    }

    @NotNull
    public byte[] a() {
        return this.b.toByteArray();
    }

    @NotNull
    public String b() {
        return this.a;
    }
}

