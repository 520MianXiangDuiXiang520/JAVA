package Note.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo03 extends Thread {
    private static int nums = 100;
    private static final Lock lock = new ReentrantLock();

    private void doThing(String name) {
        lock.lock();
        try{
            System.out.println(name + ": " + nums);
            Thread.sleep(50);
            nums --;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        while(nums >= 0) {
            doThing("nums");
        }
    }

    public static void main(String[] args) {
        Demo03 demo03 = new Demo03();
        demo03.start();

        while(nums >= 0) {
            demo03.doThing("NUMS");
        }
    }
}
