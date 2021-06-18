/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONException
 *  net.sf.json.JSONObject
 *  org.apache.commons.codec.digest.DigestUtils
 *  org.apache.log4j.Logger
 *  sun.misc.IOUtils
 */
package tools.reflection;

import asserts.Verify;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import javax.tools.JavaFileObject;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sun.misc.IOUtils;
import tools.reflection.e;
import tools.reflection.hb;

public final class c {
    @NotNull
    private static String a = "out/compiledCache";
    @NotNull
    private static final Logger b = Logger.getLogger((String)"FileCache");
    @NotNull
    private final e c;

    public c() {
        this.c = new e(a);
    }

    public c(@NotNull String string) {
        this.c = new e(string);
    }

    @Nullable
    public hb[] a(@NotNull String string, @NotNull String string2) {
        String string3 = tools.reflection.c.c(string2);
        byte[] byArray = this.c.a(tools.reflection.c.b(tools.reflection.c.c(string)), string3);
        if (byArray == null) {
            return null;
        }
        try {
            JSONObject jSONObject = JSONObject.fromObject((Object)new String(byArray, Charset.defaultCharset()));
            JSONArray jSONArray = jSONObject.getJSONArray("compiled");
            ArrayList<hb> arrayList = new ArrayList<hb>(jSONArray.size());
            for (Object e2 : jSONArray) {
                JSONObject jSONObject2 = (JSONObject)e2;
                String string4 = (String)jSONObject2.get("className");
                String string5 = (String)jSONObject2.get("hash");
                byte[] byArray2 = this.c.a(tools.reflection.c.c(string4), string5);
                if (byArray2 == null) {
                    b.warn((Object)"Can't get compiled class content, removing it");
                    this.c.b(string, string3);
                    return null;
                }
                hb hb2 = new hb(string4, JavaFileObject.Kind.CLASS);
                hb2.openOutputStream().write(byArray2);
                arrayList.add(hb2);
            }
            return arrayList.toArray(new hb[arrayList.size()]);
        }
        catch (IOException iOException) {
            Verify.fail(iOException);
        }
        catch (ClassCastException | JSONException throwable) {
            this.c.b(string, string3);
            b.warn((Object)"Can't parse descriptionBytes description file, removing it", throwable);
        }
        return null;
    }

    public void a(@NotNull String string, @NotNull String string2, @NotNull hb[] hbArray) {
        String string3 = tools.reflection.c.c(string2);
        String string4 = tools.reflection.c.b(tools.reflection.c.c(string));
        try {
            String string5;
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
           
            for (hb hb2 : hbArray) {
            	JSONObject object2 = new JSONObject();
            	byte[] object = IOUtils.readFully((InputStream)hb2.openInputStream(), (int)-1, (boolean)true);
                string5 = hb2.b();
                String string6 = tools.reflection.c.a(object);
                object2.put("className", string5);
                object2.put((Object)"hash", (Object)string6);
                jSONArray.add(object2);
            }
            
            jSONObject.put((Object)"compiled", (Object)jSONArray);
            this.c.a(string4, string3, jSONObject.toString(2).getBytes(Charset.defaultCharset()));
           
            for (hb hb2 : hbArray) {
                byte[] object2 = IOUtils.readFully((InputStream)hb2.openInputStream(), (int)-1, (boolean)true);
                String object = hb2.b();
                string5 = tools.reflection.c.a((byte[])object2);
                this.c.a(tools.reflection.c.c((String)object), string5, (byte[])object2);
            }
        }
        catch (IOException iOException) {
            Verify.fail(iOException);
        }
        catch (ClassCastException | JSONException throwable) {
            this.c.b(string4, string3);
            b.warn((Object)"Can't parse cached description file, removing it", throwable);
        }
    }

    public void b(@NotNull String string, @NotNull String string2) {
        String string3 = tools.reflection.c.c(string2);
        String string4 = tools.reflection.c.b(tools.reflection.c.c(string));
        byte[] byArray = this.c.a(string4, string3);
        if (byArray == null) {
            return;
        }
        try {
            JSONObject jSONObject = JSONObject.fromObject((Object)new String(byArray, Charset.defaultCharset()));
            JSONArray jSONArray = jSONObject.getJSONArray("compiled");
            for (Object e2 : jSONArray) {
                JSONObject jSONObject2 = (JSONObject)e2;
                String string5 = (String)jSONObject2.get("className");
                String string6 = (String)jSONObject2.get("hash");
                this.c.b(tools.reflection.c.c(string5), string6);
            }
        }
        catch (ClassCastException | JSONException throwable) {
            // empty catch block
        }
        this.c.b(string4, string3);
    }

    public static void a(@NotNull String string) {
        a = string;
    }

    @NotNull
    private static String b(@NotNull String string) {
        return string + ".desc";
    }

    @NotNull
    private static String c(@NotNull String string) {
        return DigestUtils.md5Hex((String)string);
    }

    @NotNull
    private static String a(@NotNull byte[] byArray) {
        return DigestUtils.md5Hex((byte[])byArray);
    }
}

