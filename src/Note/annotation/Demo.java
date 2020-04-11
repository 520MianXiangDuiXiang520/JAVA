package Note.annotation;

@SuppressWarnings("all")
public class Demo {
    @Check
    public void func1() {
        String s = null;
        s.toLowerCase();
    }

    @Check
    public void func2() {
        System.out.println("111");
    }

    @Check
    public void func3() {
        System.out.println(3/0);
    }

    @Check
    public void func4() {
        System.out.println(3 + "2");
    }
}
