package Note.Chapter9_6;
import java.io.IOException;
import java.nio.*;
import java.util.*;

public class RandomWords implements Readable {
    private static Random rand = new Random(47);
    private static final String word = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final char [] capitals = word.toCharArray();
    private static final char [] lower = word.toLowerCase().toCharArray();
    private static final char [] vowels = "aeiou".toCharArray();
    private int count;
    public RandomWords(int count){
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb){
        if(count -- == 0){
            return -1;
        }
        cb.append(capitals[rand.nextInt(vowels.length)]);
        for(int i = 0;i<4;i++){
            cb.append(vowels[rand.nextInt(vowels.length)]);
            cb.append(lower[rand.nextInt(vowels.length)]);
        }
        cb.append(" ");
        return 10;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(new RandomWords(5));
        while(s.hasNext()){
            System.out.println(s.next());
        }
    }
}
