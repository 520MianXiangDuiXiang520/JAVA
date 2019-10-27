package Note.holding;

import java.util.*;

public class MultiIterableClass extends IterableClass {
    public Iterable<String> reversed() {
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                return new Iterator<String>() {
                    int current = words.length - 1;
                    @Override
                    public boolean hasNext() {
                        return current > -1 ;
                    }

                    @Override
                    public String next() {
                        return words[current --];
                    }
                };
            }
        };
    }

    public Iterable<String> randomized() {
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                List<String> shuffled = new ArrayList<>(Arrays.asList(words));
                Collections.shuffle(shuffled, new Random(66));
                return shuffled.iterator();
            }
        };
    }

    public static void main(String[] args) {
        MultiIterableClass mic = new MultiIterableClass();
        for(String s: mic.reversed()){
            System.out.print(s + " ");
        }
        System.out.println();
        for(String s: mic.randomized()){
            System.out.print(s + " ");
        }
        System.out.println();
        for(String s: mic){
            System.out.print(s + " ");
        }
    }
}
