package Note.typeinfo;
import java.util.Random;

import static junbao.tool.Range.*;

class Initable {
    static final int staticFinal = 66;
    static final int StaticFinal2 = ClassInitialization.random.nextInt(1000);
    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {
    static int staticNoFinal = 666;
    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNoFinal = 66;
    static {
        System.out.println("Initializing Initable3");
    }
}

public class ClassInitialization {
    public static Random random = new Random(66);

    public static void main(String[] args) throws ClassNotFoundException {
        Class initable = Initable.class;
        System.out.println("after creating Initable ref");
        System.out.println(Initable.staticFinal);
        System.out.println(Initable.StaticFinal2);
        System.out.println(Initable2.staticNoFinal);
        Class initable3 = Class.forName("Note.typeinfo.Initable3");
        System.out.println("create initable3");
        System.out.println(Initable3.staticNoFinal);
    }
}
