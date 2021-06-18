/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  javassist.CannotCompileException
 *  javassist.ClassPool
 *  javassist.CtClass
 *  javassist.NotFoundException
 */
package tools.reflection;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.NestingKind;
import javax.tools.JavaFileObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class g
implements JavaFileObject {
    @NotNull
    private final JavaFileObject a;
    @NotNull
    private final String b;

    public g(@NotNull String string, @NotNull JavaFileObject javaFileObject) {
        this.b = string;
        this.a = javaFileObject;
    }

    @NotNull
    public JavaFileObject a() {
        return this.a;
    }

    @Override
    @NotNull
    public URI toUri() {
        return this.a.toUri();
    }

    @Override
    @NotNull
    public String getName() {
        return this.a.getName();
    }

    @Override
    @NotNull
    public InputStream openInputStream() throws IOException {
        try {
            CtClass ctClass = ClassPool.getDefault().get(this.b);
            return new ByteArrayInputStream(ctClass.toBytecode());
        }
        catch (CannotCompileException | NotFoundException throwable) {
            return this.a.openInputStream();
        }
    }

    @Override
    @NotNull
    public OutputStream openOutputStream() throws IOException {
        return this.a.openOutputStream();
    }

    @Override
    @NotNull
    public Reader openReader(boolean bl) throws IOException {
        return this.a.openReader(bl);
    }

    public boolean equals(@Nullable Object object) {
        if (object instanceof g) {
            return this.a.equals(((g)object).a);
        }
        return this.a.equals(object);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override
    @NotNull
    public CharSequence getCharContent(boolean bl) throws IOException {
        return this.a.getCharContent(bl);
    }

    @Override
    @NotNull
    public Writer openWriter() throws IOException {
        return this.a.openWriter();
    }

    @Override
    public long getLastModified() {
        return this.a.getLastModified();
    }

    @Override
    public boolean delete() {
        return this.a.delete();
    }

    @Override
    @NotNull
    public JavaFileObject.Kind getKind() {
        return this.a.getKind();
    }

    @Override
    public boolean isNameCompatible(@NotNull String string, @NotNull JavaFileObject.Kind kind) {
        return this.a.isNameCompatible(string, kind);
    }

    @Override
    @NotNull
    public NestingKind getNestingKind() {
        return this.a.getNestingKind();
    }

    @Override
    @NotNull
    public Modifier getAccessLevel() {
        return this.a.getAccessLevel();
    }
}

