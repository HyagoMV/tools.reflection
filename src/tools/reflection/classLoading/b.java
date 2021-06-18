/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection.classLoading;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class b
extends ClassLoader {
    @NotNull
    private static final Object a = new Object();
    @Nullable
    private static volatile Map<String, byte[]> b = null;

    @NotNull
    public static Collection<String> a() {
        return a((ClassLoader) null).keySet();
    }

    public b(@NotNull ClassLoader classLoader) {
        super(classLoader);
    }

    @Override
    @NotNull
    protected Class<?> findClass(@NotNull String string) throws ClassNotFoundException {
        byte[] byArray = tools.reflection.classLoading.b.a(this.getParent()).get(string);
        if (byArray != null) {
            return this.defineClass(string, byArray, 0, byArray.length);
        }
        return super.findClass(string);
    }

    @NotNull
    private static Map<String, byte[]> a(@Nullable ClassLoader classLoader) {
        if (b == null) {
            return tools.reflection.classLoading.b.b(classLoader);
        }
        return b;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NotNull
    private static Map<String, byte[]> b(@Nullable ClassLoader classLoader) {
        Object object = a;
        synchronized (object) {
            if (b != null) {
                return b;
            }
            URL[] uRLArray = classLoader instanceof URLClassLoader ? ((URLClassLoader)classLoader).getURLs() : tools.reflection.classLoading.b.a(System.getProperty("java.class.path").split(File.pathSeparator));
            LinkedHashMap<String, byte[]> linkedHashMap = new LinkedHashMap<String, byte[]>();
            b = linkedHashMap;
            for (URL uRL : uRLArray) {
                String string = uRL.getPath();
                if (!string.endsWith(".war")) continue;
                try {
                    a_.a(linkedHashMap, string);
                }
                catch (IOException iOException) {
                    String string2 = "Can not load War-file " + uRL;
                    System.err.println(string2 + " : " + iOException.getMessage());
                    throw new IllegalArgumentException(string2, iOException);
                }
            }
            return linkedHashMap;
        }
    }

    @NotNull
    private static URL[] a(@NotNull String[] stringArray) {
        ArrayList<URL> arrayList = new ArrayList<URL>();
        for (String string : stringArray) {
            try {
                arrayList.add(new File(string).toURI().toURL());
            }
            catch (MalformedURLException malformedURLException) {
                System.err.println("Can not convert path " + string + " into valid url : " + malformedURLException.getMessage());
            }
        }
        return arrayList.toArray(new URL[arrayList.size()]);
    }

    static {
        ClassLoader.registerAsParallelCapable();
    }

    private static final class a_ {
        private static final int a = 1024;
        private static final int b = 0x100000;
        @NotNull
        private static final Pattern c = Pattern.compile("WEB-INF/lib/.*\\.jar");
        @NotNull
        private static final Pattern d = Pattern.compile(".*\\.class");
        @NotNull
        private static final String e = "className";
        @NotNull
        private static final Pattern f = Pattern.compile(String.format("(WEB-INF/classes/)?(?<%s>.*\\.class)", "className"));

        public static void a(@NotNull Map<String, byte[]> map, @NotNull String string) throws IOException {
            try (FileInputStream fileInputStream = new FileInputStream(string);
                 ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);){
                ZipEntry zipEntry = zipInputStream.getNextEntry();
                while (zipEntry != null) {
                    String string2 = zipEntry.getName();
                    Matcher matcher = f.matcher(string2);
                    if (matcher.matches()) {
                        map.put(a_.a(matcher.group(e)), a_.a(zipInputStream, 1024));
                    } else if (c.matcher(string2).matches()) {
                        a_.a(map, zipInputStream);
                    }
                    zipEntry = zipInputStream.getNextEntry();
                }
            }
        }

        private a_() {
        }

        @NotNull
        private static String a(@NotNull String string) {
            return string.substring(0, string.length() - ".class".length()).replace("/", ".");
        }

        @NotNull
        private static byte[] a(@NotNull ZipInputStream zipInputStream, int n2) throws IOException {
            int n3 = n2;
            byte[] byArray = new byte[n3];
            int n4 = 0;
            int n5 = 0;
            while (n5 >= 0) {
                if (n3 - (n4 += n5) <= 0) {
                    byte[] byArray2 = new byte[n3 *= 2];
                    System.arraycopy(byArray, 0, byArray2, 0, byArray.length);
                    byArray = byArray2;
                }
                n5 = zipInputStream.read(byArray, n4, n3 - n4);
            }
            byte[] byArray3 = new byte[n4];
            System.arraycopy(byArray, 0, byArray3, 0, n4);
            return byArray3;
        }

        private static void a(@NotNull Map<String, byte[]> map, @NotNull ZipInputStream zipInputStream) throws IOException {
            try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(a_.a(zipInputStream, 0x100000));
                 ZipInputStream zipInputStream2 = new ZipInputStream(byteArrayInputStream);){
                ZipEntry zipEntry = zipInputStream2.getNextEntry();
                while (zipEntry != null) {
                    String string = zipEntry.getName();
                    if (d.matcher(string).matches()) {
                        map.put(a_.a(string), a_.a(zipInputStream2, 1024));
                    }
                    zipEntry = zipInputStream2.getNextEntry();
                }
            }
        }
    }
}

