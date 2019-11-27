package Note.threadstudy.test02;

public class Test02 {
    public static void main(String[] args) {
        t2 t =  new t2();
        Thread thread = new Thread(t);
        thread.start();
        for (int i = 0; i < 20; i++) {
            System.out.println("aaaa" + i);
        }
    }
}
