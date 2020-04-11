package Note.concurrency;

import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo05 {
    private static final Lock lock = new ReentrantLock();
    private static LinkedList<Integer> linkedList = new LinkedList<Integer>();

    static class Produce extends Thread {
        private void produce() throws InterruptedException {
            if(linkedList.size() <= 5) {
                lock.lock();
                linkedList.add(1);
                Thread.sleep(20);
                System.out.println("produce: " + linkedList.toString());
                lock.unlock();
            }
        }

        @Override
        public void run() {
            while(true) {
                try {
                    produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Customer extends Thread {
        private void consume() throws InterruptedException {
            if(linkedList.size() > 0) {
                lock.lock();
                linkedList.pop();
                Thread.sleep(20);
                System.out.println("consume: " + linkedList.toString());
                lock.unlock();
            }
        }

        @Override
        public void run() {
            while(true) {
                try {
                    consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Produce produce = new Produce();
        Customer customer = new Customer();

        produce.start();
        customer.start();
    }
}
