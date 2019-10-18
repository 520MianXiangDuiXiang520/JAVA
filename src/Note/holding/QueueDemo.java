package Note.holding;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class QueueDemo {
    public static void printQ(Queue q){
        while(q.peek() != null){
            System.out.print(q.remove() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue<Integer> queue =  new LinkedList<Integer>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            queue.offer(random.nextInt(i + 10));
        }
        printQ(queue);

        Queue<Character> characterQueue = new LinkedList<>();
        for(char c: "File Edit View".toCharArray())
            characterQueue.offer(c);
        printQ(characterQueue);
    }
}
