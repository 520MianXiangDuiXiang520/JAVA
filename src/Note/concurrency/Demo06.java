package Note.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo06 {
    static class testThread implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        es.submit(new Thread(new testThread()));
        es.submit(new Thread(new testThread()));
        es.submit(new Thread(new testThread()));
        es.submit(new Thread(new testThread()));
        es.submit(new Thread(new testThread()));
        es.submit(new Thread(new testThread()));
        es.submit(new Thread(new testThread()));
        es.submit(new Thread(new testThread()));
    }
}
