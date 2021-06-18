/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.Logger
 */
package tools.reflection.classLoading;

import asserts.Verify;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.TestOnly;

public final class l {
    @NotNull
    private static final Logger a = Logger.getLogger(l.class);
    @NotNull
    public static final l b = new l();
    @NotNull
    private b_ c = this.getClass().getClassLoader() instanceof URLClassLoader ? new d_() : new c_();

    @NotNull
    public static String[] a() {
        return l.b.c.a();
    }

    @NotNull
    public static List<URL> b() throws MalformedURLException {
        ArrayList<URL> arrayList = new ArrayList<URL>();
        for (String string : l.a()) {
            arrayList.add(new File(string).toURI().toURL());
        }
        return arrayList;
    }

    @TestOnly
    public static void a(@NotNull b_ b_2) {
        l.b.c = b_2;
    }

    private l() {
    }

    private static final class d_
    implements b_ {
        private d_() {
        }

        @Override
        @NotNull
        public String[] a() {
            a.info((Object)"Using URLClassLoader classpath");
            ArrayList<String> arrayList = new ArrayList<String>();
            ClassLoader classLoader = this.getClass().getClassLoader();
            for (URL uRL : ((URLClassLoader)classLoader).getURLs()) {
                try {
                    arrayList.add(new File(uRL.toURI()).getAbsolutePath());
                }
                catch (URISyntaxException uRISyntaxException) {
                    Verify.fail("Invalid classpath URL: " + uRL, uRISyntaxException);
                }
            }
            return arrayList.toArray(new String[arrayList.size()]);
        }
    }

    private static final class c_
    implements b_ {
        private c_() {
        }

        @Override
        @NotNull
        public String[] a() {
            a.info((Object)"Using System.getProperty(\"java.class.path\")");
            return System.getProperty("java.class.path").split(File.pathSeparator);
        }
    }

    public static interface b_ {
        @NotNull
        public String[] a();
    }
}

