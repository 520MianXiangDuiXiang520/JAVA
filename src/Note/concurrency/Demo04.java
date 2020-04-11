package Note.concurrency;


public class Demo04 {
    private static int nums;
    private static final Demo04 lock = new Demo04();

    static class Produce extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if(nums > 5) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    while(nums <= 5) {
                        nums ++;
                        System.out.println("produce :" + nums);
                    }
                    lock.notify();
                }

            }
        }
    }

    static class Customer implements Runnable {
        @Override
        public void run() {
           while (true) {
               synchronized (lock) {
                   if(nums <= 0) {
                       try {
                           lock.wait();
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
                   while(nums >0){
                       nums --;
                       System.out.println("customer: " + nums);
                   }
                   System.out.println("please produce");
                   lock.notify();
               }
               }

        }
    }

    public static void main(String[] args) {
        new Produce().start();
        new Thread(new Customer()).start();
        new Thread(() -> {});
    }
}
