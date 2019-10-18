package Note.holding;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Statistics {
    public static void main(String[] args) {
        Random random =  new Random();
        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < 1000; i++) {
            int r = random.nextInt(20);
            Integer freq = m.get(r);
            m.put(r, freq == null? 1: freq + 1);
        }
        System.out.println(m);
    }
}
