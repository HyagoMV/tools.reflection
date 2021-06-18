/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.Level
 */
package tools.reflection.classLoading;

import java.io.File;
import org.apache.log4j.Level;
import org.jetbrains.annotations.NotNull;
import tools.reflection.classLoading.o;
import tools.reflection.classLoading.p;

public final class n {
    @NotNull
    private static final p[] a = new p[]{new p("^(?=.*(vendor)).*$", Level.DEBUG), new p(".*", Level.WARN)};
    @NotNull
    private static final o[] b = new o[]{new o(new File("server", "bin"), a), new o(new File("jars"), a), new o(new File("vendor"), false, a), new o(new File("target", "test-classes")), new o(new File("target", "test")), new o(new File("target", "classes")), new o(new File("target", "production")), new o(new File("classes", "production")), new o(new File("classes", "test")), new o(new File("jars_local")), new o(new File("server_bin", "jars"), a), new o(new File("server_bin", "jars_local"))};
    @NotNull
    private static final o[] c = new o[]{new o(new File("target/production", "dataSets")), new o(new File("target/production", "accountDatabase")), new o(new File("target/production", "dbcommons")), new o(new File("target/production", "dbcommonsjdbc")), new o(new File("target/production", "masterServerDB")), new o(new File("target/production", "transactionService"))};

    @NotNull
    public static o[] a() {
        return b;
    }

    @NotNull
    public static o[] b() {
        return c;
    }

    private n() {
    }
}

