package Note.threadstudy.test05;

import java.util.ArrayList;

class Resources<T> extends ArrayList<T> {
    private static Resources resources = new Resources();
    private boolean flag = false;
    private Resources(){}

    public boolean isFull() {
        int maxSize = 10;
        return resources.size() < maxSize;
    }

    public static Resources getInstance() {
        return resources;
    }
}

class Producer<T> implements Runnable{
    private T product;
    private Resources<T> resources;

    Producer(Resources<T> resources, T product) {
        this.resources = resources;
        this.product = product;
    }

    @Override
    public void run() {
        // 如果没满，就生产
        while(true) {
            synchronized (resources) {
                if(resources.isFull()) {
                    resources.add(product);
                    System.out.println("我生产了， 现在有" + resources.size() + " 个");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    resources.notify();
                } else {
                    System.out.println("叫消费者来消费把！！！");
                    resources.notify();
                    try {
                        resources.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }

        }

    }
}

class Consumer<T> implements Runnable {
    private Resources<T> resources;

    Consumer(Resources<T> resources){
        this.resources = resources;
    }
    @Override
    public void run() {
        while(true) {
            synchronized (resources) {
                if(resources.size() > 5) {
                    resources.remove(resources.size() - 1);
                    System.out.println("我来消费了，现在还有 " + resources.size() + "个");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    resources.notify();
                } else {
                    System.out.println("生产者来生产啊！！！");
                    resources.notify();
                    try {
                        resources.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }
        }

    }
}

public class T5 {
    public static void main(String[] args) {
        Resources<String> stringResources = Resources.getInstance();
        String product = "111";
        Producer<String> producer = new Producer<String>(stringResources, product);
        Consumer<String> consumer = new Consumer<String>(stringResources);
        new Thread(producer).start();
        consumer.run();
    }
}
