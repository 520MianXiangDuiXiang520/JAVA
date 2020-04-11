package Note.cistern;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyIterator implements Iterator<Integer>, Iterable<Integer> {
    int start, end, step;

    public MyIterator(int start, int end, int step) {
        this.start = start;
        this.end = end;
        this.step = step;
    }

    public MyIterator(int start, int end) {
        this(start, end, 1);
    }
    public MyIterator(int end) {
        this(0, end, 1);
    }

    @Override
    public boolean hasNext() {
        return this.start < this.end;
    }

    @Override
    public Integer next() {
        int now;
        if (this.start < this.end){
            now = this.start;
            this.start ++;
            return now;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void remove() {

    }

    @Override
    public Iterator<Integer> iterator() {
        return this;
    }

    public static void main(String[] args) {
        MyIterator myIterator = new MyIterator(10);
        for (int i:myIterator
             ) {
            System.out.println(i);
        }
    }
}
