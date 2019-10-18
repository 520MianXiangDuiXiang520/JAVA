package Note.holding;

import java.util.*;

// 优先级队列
public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> integers = new PriorityQueue<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            integers.offer(random.nextInt(i + 10));
        }
        QueueDemo.printQ(integers);

        List<Integer> ints = Arrays.asList(25, 20, 33, 56, 2, 6, 8, 0, 556, 23);
        integers = new PriorityQueue<>(ints);
        QueueDemo.printQ(integers);

        integers = new PriorityQueue<>(ints.size(), Collections.reverseOrder());
        integers.addAll(ints);
        QueueDemo.printQ(integers);


    }
}
