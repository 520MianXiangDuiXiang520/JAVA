package Note.holding;
import java.util.*;

public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Integer [] moreInts = {6, 7, 8, 9, 10};
        collection.addAll(Arrays.asList(moreInts));

        Collections.addAll(collection, 11, 12, 13);
        Collections.addAll(collection, moreInts);

        List<Integer> list = Arrays.asList(11,12,23);
        list.set(1,21);
    }
}
