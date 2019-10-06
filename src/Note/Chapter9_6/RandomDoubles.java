package Note.Chapter9_6;
import java.util.*;

public class RandomDoubles {
    private static Random rand = new Random(47);
    public double next(){
        return rand.nextDouble();
    }

    public static void main(String[] args) {
        RandomDoubles rd = new RandomDoubles();
        System.out.println(rd.next());
    }
}
