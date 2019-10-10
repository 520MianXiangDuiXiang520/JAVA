package Note.Chapter10_4;
import static junbao.tool.Print.*;

// 使用实例初始化达到内部类构造器的效果
abstract class Base {
    public Base (int i) {
        coutln("base init i = " + i);
    }
    public abstract void f();
}

public class AnonymousConstructor {
    public static Base getBase(int i){
        return new Base(i) {
            {
                coutln("内部类构造器");
            }
            @Override
            public void f() {
                coutln("f()");
            }
        };
    }

    public static void main(String[] args) {
        Base base = getBase(26);
        base.f();
    }
}
