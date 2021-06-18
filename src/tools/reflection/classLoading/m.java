/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.Level
 *  org.apache.log4j.Logger
 *  org.apache.log4j.Priority
 */
package tools.reflection.classLoading;

import asserts.Verify;
import gnu.trove.THashMap;
import gnu.trove.THashSet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.jetbrains.annotations.NotNull;
import tools.commons.SimpleTimedLog;
import tools.commons.logs.ConsoleProgress;
import tools.reflection.classLoading.b;
import tools.reflection.classLoading.o;

public final class m {
    @NotNull
    private static final Logger a = Logger.getLogger(m.class);
    private static final int b = 4;
    private static int c = 0;

    @NotNull
    public static Collection<String> a(@NotNull String string) throws IOException {
        THashSet<String> tHashSet = new THashSet<String>();
        m.a(new o(string), tHashSet);
        return tHashSet;
    }

    public static void a(@NotNull String string, @NotNull Set<String> set) throws IOException {
        m.a(new o(string), set);
    }

    public static void a(@NotNull o o2, @NotNull Set<String> set) throws IOException {
        File file = o2.a();
        if (file.isDirectory()) {
            m.a("", o2, set);
        } else if (file.getName().endsWith(".jar") || file.getName().endsWith(".zip")) {
            m.a(new o(file, o2.c()), set);
        } else {
            throw new IOException("Unknown classpath entry: " + file.getAbsolutePath());
        }
    }

    @NotNull
    public static List<Class<?>> a(@NotNull Collection<o> collection) {
        final THashMap<String, Level> tHashMap = new THashMap<String, Level>(collection.size());
        for (o object2 : collection) {
            try {
                a.debug((Object)("scanning path " + object2));
                THashSet<String> tHashSet = new THashSet<String>();
                m.a(object2, tHashSet);
                for (String string : tHashSet) {
                    tHashMap.put(string, object2.d());
                }
            }
            catch (IOException iOException) {
                a.error((Object)iOException.getMessage());
            }
        }
        for (String string : tools.reflection.classLoading.b.a()) {
            if (tHashMap.containsKey(string)) continue;
            tHashMap.put(string, Level.DEBUG);
        }
        final Set set = Collections.synchronizedSet(new THashSet(tHashMap.size()));
        final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        m.a(4, tHashMap.keySet(), new c_<String>(){

            @Override
            public void a(@NotNull String string) {
                m.a(set, string, (Level)tHashMap.get(string), classLoader);
            }
        }, "Loading " + tHashMap.size() + " classes...");
        m.a(4, set, new c_<Class<?>>(){

            @Override
            public void a(@NotNull Class<?> clazz) {
                m.a(clazz, set, (Level)tHashMap.get(clazz.getName()));
            }
        }, "Checking class dependencies");
        a.info((Object)(c + " classes loading errors"));
        c = 0;
        return new ArrayList(set);
    }

    private static <T> void a(int n2, @NotNull Collection<T> collection, @NotNull c_<T> c_2, @NotNull String string) {
        SimpleTimedLog simpleTimedLog = new SimpleTimedLog(string, a);
        ConcurrentLinkedQueue<T> concurrentLinkedQueue = new ConcurrentLinkedQueue<T>(collection);
        d_<T> d_2 = new d_<T>(concurrentLinkedQueue, c_2);
        if (n2 > 1) {
            Thread[] threadArray = new Thread[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                Thread thread;
                threadArray[i2] = thread = new Thread(d_2, "Task" + i2);
                thread.start();
            }
            for (Thread thread : threadArray) {
                try {
                    thread.join();
                }
                catch (InterruptedException interruptedException) {
                    Verify.fail("Task " + thread + " interrupted", interruptedException);
                }
            }
        } else {
            d_2.run();
        }
        simpleTimedLog.done("Finished");
    }

    private static void a(@NotNull Collection<Class<?>> collection, @NotNull String string, @NotNull Level level, @NotNull ClassLoader classLoader) {
        try {
            Class<?> clazz;
            if (a.isDebugEnabled()) {
                a.debug((Object)("loading " + string));
            }
            if (!collection.add(clazz = classLoader.loadClass(string))) {
                a.error((Object)("duplicated class found: " + clazz));
            }
        }
        catch (Throwable throwable) {
            m.a(level, string, throwable);
        }
    }

    private static void a(@NotNull Level level, @NotNull String string, @NotNull Throwable throwable) {
        ++c;
        a.log((Priority)level, (Object)MessageFormat.format("Can not load class {0}. {1}: {2}", string, throwable.getClass(), throwable.getMessage()));
    }

    private m() {
    }

    private static void a(@NotNull Class<?> clazz, @NotNull Collection<Class<?>> collection, @NotNull Level level) {
        if (Modifier.isAbstract(clazz.getModifiers())) {
            return;
        }
        try {
            for (Class<?> clazz2 = clazz; clazz2 != null; clazz2 = clazz2.getSuperclass()) {
                clazz2.getDeclaredFields();
            }
        }
        catch (NoClassDefFoundError noClassDefFoundError) {
            for (Class<?> clazz3 = clazz; clazz3 != null; clazz3 = clazz3.getSuperclass()) {
                collection.remove(clazz3);
            }
            ++c;
            a.log((Priority)level, (Object)("Coud not load class " + clazz + ". excluding from loading : " + noClassDefFoundError.getMessage()));
        }
    }

    private static void a(@NotNull o o2, @NotNull Collection<String> collection) throws IOException {
        if (a.isDebugEnabled()) {
            a.debug((Object)("scanning jar " + o2));
        }
        try {
            JarFile jarFile = new JarFile(o2.a());
            Enumeration<JarEntry> enumeration = jarFile.entries();
            while (enumeration.hasMoreElements()) {
                JarEntry jarEntry = enumeration.nextElement();
                if (jarEntry.isDirectory()) continue;
                m.a(jarEntry.getName(), collection);
            }
            jarFile.close();
        }
        catch (FileNotFoundException fileNotFoundException) {
            a.log((Priority)o2.d(), (Object)"File not found", (Throwable)fileNotFoundException);
        }
        catch (ZipException zipException) {
            a.log((Priority)o2.d(), (Object)("Zip read error (file = " + o2.a().getCanonicalPath() + ')'), (Throwable)zipException);
        }
    }

    private static void a(@NotNull String string, @NotNull o o2, @NotNull Set<String> set) {
        if (a.isDebugEnabled()) {
            a.debug((Object)("scanning dir " + o2));
        }
        for (File file : o2.a().listFiles(o2.b())) {
            if (file.isDirectory()) {
                m.a(string + file.getName() + File.separator, new o(file), set);
                continue;
            }
            try {
				m.a(string + file.getName(), set);
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
    }

    private static void a(@NotNull String string, @NotNull Collection<String> collection) {
        if (!string.endsWith(".class")) {
            return;
        }
        String string2 = string.substring(0, string.length() - 6).replace("/", ".").replace("\\", ".");
        if (!collection.add(string2)) {
            a.error((Object)("Duplicated class found: " + string));
        }
    }

    private static final class d_<T>
    implements Runnable {
        private static final int a = 64;
        @NotNull
        private final Queue<T> b;
        @NotNull
        private final c_<T> c;
        private final int d;
        @NotNull
        private final ConsoleProgress e = new ConsoleProgress(64);

        public d_(@NotNull Queue<T> queue, @NotNull c_<T> c_2) {
            this.b = queue;
            this.d = queue.size();
            this.c = c_2;
        }

        @Override
        public void run() {
            T t2 = this.b.poll();
            while (t2 != null) {
                this.c.a(t2);
                this.e.setProgress(((float)this.d - (float)this.b.size()) / (float)this.d);
                t2 = this.b.poll();
            }
        }
    }

    private static interface c_<T> {
        public void a(@NotNull T var1);
    }
}

