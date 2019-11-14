package Note.typeinfo;

import 上课.interfacedemo.B;

class Base{}
class Derived extends Base {}

public class FamilyVsExactType {
    static void test(Object x) {
        System.out.println("type x" + x.getClass());
        System.out.println("x instanceof Base " + (x instanceof Base));
        System.out.println("x instanceof Derived " + (x instanceof Derived));
        System.out.println();
        System.out.println(Base.class.isInstance(x));
        System.out.println(Derived.class.isInstance(x));
        System.out.println();
        System.out.println(x.getClass() == Base.class);
        System.out.println(x.getClass() == Derived.class);
        System.out.println();
        System.out.println(x.getClass().equals(Base.class));
        System.out.println(x.getClass().equals(Derived.class));
    }

    public static void main(String[] args) {
        test(new Base());
        System.out.println("****************************************");
        test(new Derived());
    }

}
