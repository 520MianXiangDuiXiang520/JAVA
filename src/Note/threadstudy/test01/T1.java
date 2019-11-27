package Note.threadstudy.test01;

public class T1 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("llll" + i);
        }
    }

    public static void main(String[] args) {
        T1 t1 = new T1();
        t1.start();
    }
}
