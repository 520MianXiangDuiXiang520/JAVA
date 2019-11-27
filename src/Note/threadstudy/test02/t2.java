package Note.threadstudy.test02;

public class t2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("llll" + i);
        }
    }
}
