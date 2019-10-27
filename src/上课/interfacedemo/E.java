package 上课.interfacedemo;
import static junbao.tool.Print.*;

public class E implements D {
    @Override
    public void m7() {
        cout("m7");
    }

    @Override
    public void m1() {
        cout("m1");
    }

    @Override
    public void m2() {
        cout("m2");
    }

    @Override
    public void m3() {
        cout("m3");
    }

    @Override
    public void m4() {
        cout("m4");
    }

    @Override
    public void m5() {
        cout("m5");
    }

    @Override
    public void m6() {
        cout("m6");
    }

    public static void main(String[] args) {
        D d = new E();
        d.m1();
        d.m2();
        d.m3();
        d.m4();
        d.m5();
        d.m6();
        d.m7();
    }
}
