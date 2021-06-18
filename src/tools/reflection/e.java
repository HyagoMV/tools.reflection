/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.Logger
 */
package tools.reflection;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class e {
    @NotNull
    private static final Logger a = Logger.getLogger((String)"FileCache");
    @NotNull
    private File b;
    private final boolean c;

    public e() {
        this("out/fileCache/");
    }

    public e(@NotNull String string) {
        this.b = new File(string);
        a.info((Object)("Using '" + this.b.getAbsolutePath() + "' as cache directory"));
        if (!this.b.exists()) {
            a.info((Object)("File cache directory '" + this.b.getAbsolutePath() + "' not exists, creating"));
            if (!this.b.mkdirs()) {
                a.error((Object)("Can't create cache directory " + this.b.getAbsolutePath()));
            }
        }
        boolean bl = this.c = this.b.isDirectory() && this.b.canRead() && this.b.canWrite();
        if (!this.c) {
            a.warn((Object)("Can't access compiled cache directory " + this.b.getAbsolutePath() + ", cache will not be used"));
        }
    }

    /*
     * Exception decompiling
     */
    @Nullable
    public byte[] a(@NotNull String var1_1, @NotNull String var2_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public void a(@NotNull String string, @NotNull String string2, @NotNull byte[] byArray) {
        if (!this.c) {
            return;
        }
        try (FileOutputStream fileOutputStream = new FileOutputStream(this.c(string, string2));
             FileLock fileLock = fileOutputStream.getChannel().lock();){
            fileOutputStream.write(byArray);
        }
        catch (IOException iOException) {
            a.warn((Object)"Can't write cached compiled file", (Throwable)iOException);
        }
    }

    public void b(@NotNull String string, @NotNull String string2) {
        this.c(string, string2).delete();
    }

    @NotNull
    private File c(@NotNull String string, @NotNull String string2) {
        return new File(this.b, string + '.' + string2);
    }

    public boolean a() {
        return this.c;
    }
}

