package Note.holding;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

public class CollectionSequence extends AbstractCollection {

    public static void display(Iterator<String> it){
        while(it.hasNext()){
            String i = it.next();
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void display(Collection<String> collection){
        for(String i: collection){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private String [] strings = {
            "package Note.holding",
            "import java.util.AbstractCollection",
            "import java..util.Iterator",
            "public class CollectionSequence extends AbstractCollection {",
            "@Override",
            "public Iterator iterator()"
    };

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < strings.length;
            }

            @Override
            public String next() {
                return strings[index ++];
            }
        };
    }

    @Override
    public int size() {
        return strings.length;
    }

    public static void main(String[] args) {
        CollectionSequence collectionSequence = new CollectionSequence();
        display(collectionSequence);
        display(collectionSequence.iterator());
    }
}
