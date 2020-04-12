package Note.concurrency;

public class ReentrantLockDemo {
    private int num = 0;
    final Object object = new Object();

    private void method1() {
        synchronized (object) {
            num ++;
        }
    }

    private void method2() {
        synchronized (object) {
            method1();
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
        new Thread(reentrantLockDemo::method2).start();
        new Thread(reentrantLockDemo::method2).start();
    }
}
