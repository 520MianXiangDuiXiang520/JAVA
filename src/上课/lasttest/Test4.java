package 上课.lasttest;
class A {
    double f (double x, double y) {
        return x + y;
    }
    static int g (int n) {
        return n * n;
    }
}
class B extends A {
    @Override
    double f (double x, double y) {
        double m = super. f (x, y);
        return m + x*y;
    }
    static int g(int n) {
        int m = A.g(n);
        return m+n;
    }
}
public class Test4 {
    public static void main(String args[]) {
        B b = new B();
        System.out.println(b.f(10.0,8.0));   //【代码1】
        System.out.println(b.g(3));        //【代码2】
        A a = new B();
        System.out.println(a.f(10.0,8.0));   //【代码3】
        System.out.println(a.g(3));        //【代码4】
    }
}

