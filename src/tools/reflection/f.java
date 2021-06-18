/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.NestingKind;
import javax.tools.JavaFileObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class f
implements JavaFileObject {
    @NotNull
    private final String a;
    @NotNull
    private final JavaFileObject.Kind b;
    @NotNull
    private final URI c;
    @NotNull
    private final ByteArrayOutputStream d = new ByteArrayOutputStream();

    public f(@NotNull String string, @NotNull JavaFileObject.Kind kind) {
        this.a = string;
        this.b = kind;
        this.c = URI.create("string:///" + string.replace('.', '/') + JavaFileObject.Kind.SOURCE.extension);
    }

    @Override
    @NotNull
    public URI toUri() {
        return this.c;
    }

    @Override
    @NotNull
    public String getName() {
        return this.a;
    }

    @Override
    @Nullable
    public InputStream openInputStream() {
        return null;
    }

    @Override
    @NotNull
    public OutputStream openOutputStream() {
        return this.d;
    }

    @Override
    @Nullable
    public Reader openReader(boolean bl) {
        return null;
    }

    @Override
    @Nullable
    public CharSequence getCharContent(boolean bl) {
        return null;
    }

    @Override
    @Nullable
    public Writer openWriter() {
        return null;
    }

    @Override
    public long getLastModified() {
        return 0L;
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    @NotNull
    public JavaFileObject.Kind getKind() {
        return this.b;
    }

    @Override
    public boolean isNameCompatible(@NotNull String string, @NotNull JavaFileObject.Kind kind) {
        return this.b == kind;
    }

    @Override
    @NotNull
    public NestingKind getNestingKind() {
        return NestingKind.TOP_LEVEL;
    }

    @Override
    @NotNull
    public Modifier getAccessLevel() {
        return Modifier.PUBLIC;
    }

    @NotNull
    public byte[] a() {
        return this.d.toByteArray();
    }
}

