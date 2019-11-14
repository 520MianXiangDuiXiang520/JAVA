package 上课.thread;

class Thread1 extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("new thread");
        }
    }
}

class Thread2 implements Runnable {

    @Override
    public void run() {

    }
}

public class AThread extends Thread {
    public static void main(String[] args) {
        Thread thread = new Thread1();
        thread.run();
    }
}
