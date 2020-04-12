package Note.concurrency;

public class Demo07 {
    private static boolean s = true;
    public static void main(String[] args) {

        new Thread(() -> {
            while(s) {

            }

        }).start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            s = false;

        }).start();
        System.out.println(s);
    }
}
