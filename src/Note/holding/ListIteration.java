package Note.holding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import static junbao.tool.Print.*;

public class ListIteration {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 1, 2, 3, 4, 5, 6, 7);
        ListIterator iterator = integers.listIterator();
        while(iterator.hasNext()){
            coutln(iterator.previousIndex() + ", " + iterator.next() + ", " + iterator.nextIndex());
//            iterator.next();
            iterator.set(1);
        }
        cout(integers);
    }
}
