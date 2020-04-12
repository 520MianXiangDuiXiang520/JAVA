package Note.concurrency;

import java.util.ArrayList;
import java.util.List;

public class Demo08 {
    private static int num = 0;
    public static void main(String[] args) {
        Runnable runnable = () -> {
            num ++;
        };

        List<Thread> list = new ArrayList<Thread>();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
            list.add(thread);
        }

        for (Thread t :list) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(num);
    }
}
