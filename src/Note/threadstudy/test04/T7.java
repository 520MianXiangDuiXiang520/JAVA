package Note.threadstudy.test04;

import java.util.concurrent.locks.ReentrantLock;

public class T7 {
    private static int ticket = 100;
    static ReentrantLock  lock = new ReentrantLock();
    public static void shell(){
        if(ticket > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " =====> " + ticket);
            ticket --;
        } else
            System.exit(1);
    }
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run(){
                while(true){
                    lock.lock();
                    shell();
                    lock.unlock();
                }
            }


        }.start();

        while(true){
            lock.lock();
            shell();
            lock.unlock();
        }
    }
}
