/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.Logger
 */
package tools.reflection.classLoading;

import gnu.trove.THashSet;
import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tools.commons.SimpleTimedLog;
import tools.reflection.classLoading.h;
import tools.reflection.classLoading.l;
import tools.reflection.classLoading.m;
import tools.reflection.classLoading.o;

public final class k {
    @NotNull
    private static final Logger a = Logger.getLogger(h.class);

    private k() {
    }

    
    
    public static void a(@NotNull h h2, o ... oArray) {
        Object[] objectArray = l.a();
        SimpleTimedLog simpleTimedLog = new SimpleTimedLog(MessageFormat.format("Loading classes from {0}(cp = {1})...", Arrays.toString(oArray), Arrays.toString(objectArray)), a);
        a.info((Object)("Current base path: " + new File("").getAbsolutePath()));
        String[] stringArray = k.a((String[])objectArray);
        ArrayList<o> arrayList = new ArrayList<o>();
        ArrayList<o> arrayList2 = new ArrayList<o>(stringArray.length);
        for (String string : stringArray) {
            String string2 = new File(string).getAbsolutePath();
            o o2 = k.a(string2, oArray);
            if (a.isDebugEnabled()) {
                a.debug((Object)((o2 != null ? "added path: " : "skipped path: ") + string2));
            }
            if (o2 != null) {
                if (o2.e()) {
                    arrayList.add(o2);
                }
                arrayList2.add(o2);
                continue;
            }
            arrayList2.add(new o(string));
        }
        k.a(arrayList2);
        List<Class<?>> list = m.a(arrayList);
        Collections.sort(list, new Comparator<Class<?>>(){

            public int compare(@NotNull Class<?> clazz, @NotNull Class<?> clazz2) {
                return clazz.toString().compareTo(clazz2.toString());
            }

        });
        h2.c(list);
        int n2 = k.a(h2);
        simpleTimedLog.done(n2 + " classes loaded");
        
    }

    private static int a(@NotNull h h2) {
        int n2 = 0;
        Iterator<Class<?>> iterator = h2.f().iterator();
        while (iterator.hasNext() && iterator.next() != null) {
            ++n2;
        }
        return n2;
    }

    @Nullable
    private static o a(@NotNull String string, o ... oArray) {
        String string2 = string.replace('\\', '/');
        if (string2.endsWith("/client.jar")) {
            return new o(string);
        }
        if (string2.contains("/vendor/jars/")) {
            return null;
        }
        if (string2.contains("/jars/vendors/")) {
            return null;
        }
        for (o o2 : oArray) {
            if (!o2.a(string2)) continue;
            return new o(string2, o2);
        }
        return null;
    }

    @NotNull
    private static String[] a(@NotNull String[] stringArray) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (String string : stringArray) {
            if (!string.endsWith(".jar") && !string.endsWith(".war")) continue;
            try {
                String string2;
                Manifest manifest = new JarFile(string).getManifest();
                if (manifest == null || (string2 = manifest.getMainAttributes().getValue("Class-Path")) == null) continue;
                File file = new File(string);
                String string3 = file.getParent() == null ? "." : file.getParent();
                for (String string4 : string2.split(" ")) {
                    File file2 = new File(string3, string4);
                    if (!file2.exists()) {
                        a.info((Object)("Path does not exist: " + file2));
                        continue;
                    }
                    arrayList.add(file2.getPath());
                }
            }
            catch (IOException iOException) {
                a.info((Object)"failed to load manifest", (Throwable)iOException);
            }
        }
        arrayList.addAll(Arrays.asList(stringArray));
        return arrayList.toArray(new String[arrayList.size()]);
    }

    private static void a(@NotNull Iterable<o> iterable) {
        LinkedHashSet<String> linkedHashSet;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (o iterator : iterable) {
            THashSet<String> tHashSet = new THashSet<String>();
            try {
                m.a(iterator, tHashSet);
                for (String objectArray : tHashSet) {
                    linkedHashSet = (LinkedHashSet<String>)linkedHashMap.get(objectArray);
                    if (linkedHashSet == null) {
                        linkedHashSet = new LinkedHashSet<String>();
                        linkedHashMap.put(objectArray, linkedHashSet);
                    }
                    linkedHashSet.add(iterator.a().getAbsolutePath());
                }
            }
            catch (IOException iOException) {
                a.error((Object)iOException.getMessage());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Object o : linkedHashMap.entrySet()) {
        	Map.Entry entry  = (Map.Entry) o;
            Object[] objectArray;
            Set set = (Set)entry.getValue();
            if (set.size() == 1) continue;
            objectArray = set.toArray(new String[set.size()]);
            Arrays.sort(objectArray);
            String s = Arrays.toString(objectArray);
            ArrayList arrayList = (ArrayList)linkedHashMap2.get(s);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap2.put(s, arrayList);
            }
            arrayList.add(entry.getKey());
        }
        for (Object o : linkedHashMap2.entrySet()) {
        	Map.Entry entry  = (Map.Entry) o;
            a.warn((Object)("Duplicated " + ((ArrayList)entry.getValue()).size() + " classes in " + (String)entry.getKey() + ", for example '" + (String)((ArrayList)entry.getValue()).get(0) + '\"'));
        }
    }
}

