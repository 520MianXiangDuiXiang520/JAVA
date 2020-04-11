package Note.concurrency;

public class Demo01 implements Runnable {
    private int nums = 100;

    @Override
    public void run() {
        while(true) {
            synchronized (this) {
                System.out.println("nums:" + nums);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                nums --;
            }
        }
    }

    public static void main(String[] args) {
        Demo01 demo01 = new Demo01();
        Thread thread = new Thread(demo01);
        thread.start();

        while(true) {
            synchronized (demo01) {
                System.out.println("NUMS:" + demo01.nums);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                demo01.nums --;
            }

        }
    }
}
