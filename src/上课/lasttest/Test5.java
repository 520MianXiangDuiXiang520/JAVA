package 上课.lasttest;

class Father {
    public String name = "father";

    public void getName() {
        System.out.println("Father: " + this.name);
    }

    public void getName2() {
        System.out.println("Father: " + this.name);
    }
}

class Son extends Father {
    public String name = "son";

    @Override
    public void getName() {
        System.out.println("Son: " + this.name);
    }
}

public class Test5 {
    public static void main(String[] args) {
        Son son = new Son();
        Father father = son;
        System.out.println(son.name);
        System.out.println(father.name);
    }


}
