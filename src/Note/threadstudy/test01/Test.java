package Note.threadstudy.test01;

public class Test {
    public static void main(String[] args) {
        T1 t = new T1();
        t.start();
        for (int i = 0; i < 20; i++) {
            System.out.println("aaaa" + i);
        }
    }
}
