package 上课;

class Father{
    Father(){
        System.out.println("基类默认构造器");
    }
    Father(String name){
        System.out.println("基类带参构造器");
    }
}

public class ManyInit extends Father {
    static Father father = new Father();
    ManyInit(){
        super();
        System.out.println("派生类默认构造器");
    }
    Father father2 = new Father();
    ManyInit(String name){
        super(name);
        System.out.println("派生类带参构造器");
    }

    public static void main(String[] args) {
        System.out.println("main");
        ManyInit manyInit = new ManyInit("11");
        ManyInit manyInit2 = new ManyInit();
    }
}
/*
基类默认构造器
main
基类带参构造器
基类默认构造器
派生类带参构造器
基类默认构造器
基类默认构造器
派生类默认构造器

 */