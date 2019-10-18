package Note.holding;

import java.util.*;

public class InterfaceVsIterator {
    public static void display(Iterator<Integer> it){
        while(it.hasNext()){
            int i = it.next();
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void display(Collection<Integer> collection){
        for(int i: collection){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        Collections.addAll(intList, 1, 2, 3, 4, 5, 6, 7, 8);
        Set<Integer> intSet = new HashSet<>(intList);
        Map<Integer, Integer> integerMap = new LinkedHashMap<>();
        for (int i = 0; i < 10 ; i++) {
            integerMap.put(i, i+10);
        }

        display(intList);
        display(intSet);
        display(intList.iterator());
        display(intSet.iterator());
        System.out.println(integerMap);
        System.out.println(integerMap.keySet());
        display(integerMap.values());
        display(integerMap.values().iterator());
    }
}
