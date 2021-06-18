/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection.objectsFactory;

import ioBase.SerializationDataInput;
import ioBase.SerializationDataOutput;
import ioBase.SerializationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.TestOnly;

public interface j {
    public static final int a = 50;
    public static final int b = 150;

    @NotNull
    public Object a(@NotNull SerializationDataInput var1, @NotNull Class<?> var2) throws SerializationException;

    @NotNull
    public a_ a(@NotNull Object var1);

    public void a(int var1, @NotNull a_ var2);

    public void a();

    @TestOnly
    @NotNull
    public a_ a(@NotNull Class<?> var1);

    @NotNull
    public a_ b();

    public static abstract class a_ {
        public abstract boolean a(@NotNull Class<?> var1);

        public boolean b(@NotNull Class<?> clazz) {
            return this.a(clazz);
        }

        @NotNull
        public Class<?> c(@NotNull Class<?> clazz) {
            return clazz;
        }

        @NotNull
        public abstract Object a(@NotNull SerializationDataInput var1, @NotNull Class<?> var2) throws SerializationException;

        public abstract void a(@NotNull SerializationDataOutput var1, @NotNull Object var2) throws SerializationException;
    }
}

