package 上课.lasttest;

class A1 {
    int m;
    int getM() {
        return m;
    }
    int seeM() {
        return m;
    }
}
class B1 extends A1 {
    int m ;
    int getM() {
        return m+100;
    }
}
public class E {
    public static void main(String args[]) {
        B1 b = new B1();
        b.m = 20;
//        System.out.println(b.getM());  //【代码1】
        A1 a = b;
        System.out.println(a.m);
        a.m = -100;                 // 上转型对象访问的是被隐藏的m
        System.out.println(a.m);
        System.out.println(b);
        System.out.println(b.m);
        System.out.println(a.getM());  //【代码2】上转型对象调用的一定是子类重写的getM()方法
        System.out.println(b.seeM()); //【代码3】子类继承的seeM()方法操作的m是被子类隐藏的m
    }
}

