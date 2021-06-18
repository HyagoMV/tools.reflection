package tools.reflection.classLoading;

import java.util.ArrayList;
import java.util.List;

public class _a {
	void a (List <Object> i) {
        i.set (0, null);
    }
	void b (List <?> i) {
        i.set (0, null);
    }
	void c (List  i) {
        i.set (0, null);
    }
	
	void c (ArrayList  i) {
        i.set (0, null);
        i.trimToSize();
        int i2  = 80;
	}
}
