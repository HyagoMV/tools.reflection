/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.Level
 */
package tools.reflection.classLoading;

import java.util.regex.Pattern;
import org.apache.log4j.Level;
import org.jetbrains.annotations.NotNull;

public final class p {
    @NotNull
    public static final p a = new p(".*", Level.WARN);
    @NotNull
    private final Pattern b;
    @NotNull
    private final Level c;

    public p(@NotNull String string, @NotNull Level level) {
        this.b = Pattern.compile(string);
        this.c = level;
    }

    public String toString() {
        return String.format("[%s:%s]", this.c, this.b);
    }

    public boolean a(@NotNull CharSequence charSequence) {
        return this.b.matcher(charSequence).matches();
    }

    @NotNull
    public Level a() {
        return this.c;
    }
}

