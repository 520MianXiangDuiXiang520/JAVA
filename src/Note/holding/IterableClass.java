package Note.holding;

import java.util.Iterator;

public class IterableClass implements Iterable<String> {
    protected String [] words =
            ("Don't try to compute pulse until we have at least the min. number of frames").split(" ");
    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int index;
            @Override
            public boolean hasNext() {
                return index < words.length;
            }

            @Override
            public Object next() {
                return words[index ++];
            }
        };
    }

    public static void main(String[] args) {
        for(String s: new IterableClass()){
            System.out.println(s);
        }
    }
}
