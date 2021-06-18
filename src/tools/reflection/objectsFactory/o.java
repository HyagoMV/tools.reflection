/*
 * Decompiled with CFR 0.151.
 */
package tools.reflection.objectsFactory;

import ioBase.CppInSerializable;
import ioBase.CppOutSerializable;
import ioBase.NotOptimized;
import ioBase.ResourceSerializable;
import ioBase.SerializationDataInput;
import java.lang.reflect.Modifier;
import org.jetbrains.annotations.NotNull;
import tools.reflection.objectsFactory.j;

public abstract class o
extends j.a_ {
    @Override
    public boolean a(@NotNull Class<?> clazz) {
        boolean bl = !clazz.isAnnotationPresent(NotOptimized.class);
        return bl && CppOutSerializable.class.isAssignableFrom(clazz);
    }

    @Override
    public boolean b(@NotNull Class<?> clazz) {
        boolean bl;
        boolean bl2 = !clazz.isAnnotationPresent(NotOptimized.class);
        int n2 = clazz.getModifiers();
        boolean bl3 = Modifier.isInterface(n2) || Modifier.isAbstract(n2);
        boolean bl4 = bl = ResourceSerializable.class.isAssignableFrom(clazz) || Enum.class.isAssignableFrom(clazz);
        if (bl2 && !bl3 && CppInSerializable.class.isAssignableFrom(clazz) && !bl) {
            if (!Modifier.isPublic(n2)) {
                throw new a_("This CppInSerializable class must be public: " + clazz.getCanonicalName());
            }
            try {
                clazz.getConstructor(SerializationDataInput.class);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                throw new a_("There's no serialization constructor in class " + clazz.getCanonicalName(), noSuchMethodException);
            }
            return true;
        }
        return false;
    }

    public static final class a_
    extends RuntimeException {
        public a_(@NotNull String string) {
            super(string);
        }

        public a_(@NotNull String string, @NotNull Throwable throwable) {
            super(string, throwable);
        }
    }
}

