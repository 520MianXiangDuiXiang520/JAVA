package Note.concurrency;

public class UninterruptibleDemo {
    private static final Object o = new Object();

    public static void main(String[] args) throws InterruptedException {
        // 线程1 拿到锁后阻塞3s
        new Thread(() -> {
            synchronized (o) {
                System.out.println("线程1的同步代码块开始执行");
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(" 线程1的同步代码块执行结束");
            }
        }).start();

        // 让线程1先执行
        Thread.sleep(100);

        Thread t2 = new Thread(() -> {
            synchronized (o) {
                System.out.println("线程2的同步代码块开始执行");
            }

        });
        t2.start();

        // 主线程休眠3s后，锁o 依然被线程1拿着，线程2处于BLOCKED状态
        Thread.sleep(3000);
        System.out.println("线程2的状态：" + t2.getState());

        // 尝试中断线程2，如果synchronized允许被中断，那线程2此时的状态应该会变为Terminated（死亡）状态
        // 反之synchronized如果不可中断，线程2的状态会保持BLOCKED（阻塞）状态
        t2.interrupt();

        System.out.println("线程2的状态：" + t2.getState());

    }
}

//线程1的同步代码块开始执行
//线程2的状态：BLOCKED
//线程2的状态：BLOCKED
//线程1的同步代码块执行结束
//线程2的同步代码块开始执行
