package Note.concurrency;

public class Demo02 extends Thread {
    private static int nums = 100;
    private synchronized void doThing(String name) throws InterruptedException {
        System.out.println(name + nums);
        Thread.sleep(50);
        nums --;
    }
    @Override
    public void run() {
        try {
            while(nums >= 0)
                doThing("nums");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Demo02 demo02 = new Demo02();
        demo02.start();

        while(nums >= 0) {
            demo02.doThing("NUMS");
        }
    }
}
