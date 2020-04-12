package Note.concurrency;

public class ReorderDemo {
    static int a = 0, b = 0, j = 0, i = 0;
    static int num = 0;
    public static void main(String[] args) throws InterruptedException {
        while(true) {
            num ++;
            i = 0;
            j = 0;
            a = 0;
            b = 0;

            Thread thread = new Thread(() -> {
                a = 1;
                i = b;
            });

            Thread thread1 = new Thread(() -> {
                b = 1;
                j = a;
            });

            thread.start();
            thread1.start();
            thread.join();
            thread1.join();

            System.out.println("第 "+ num +"次： i = " +  i + ", j = " + j);
            if(i == 0 && j == 0)
                break;
        }
    }
}
