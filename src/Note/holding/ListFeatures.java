package Note.holding;
import java.util.*;
import static junbao.tool.Print.*;

public class ListFeatures {
    public static void main(String[] args) {
        Random rand = new Random(99);
        List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        coutln("1: " + integerList);
        integerList.add(8);
        coutln("2: " + integerList);
        integerList.add(5, 50);
        coutln("3: " + integerList);
        coutln("4: " + integerList.contains(3));  // true
        // remove有两个重载，接受int的按索引删除，接受object的按equals()删除
        integerList.remove(3);
        coutln("5: " + integerList);
        Integer third = new Integer(3);
        integerList.remove(third);
        coutln("6: " + integerList);

        Integer getInt = integerList.get(2);
        coutln("7: " + getInt +  "  " + integerList.indexOf(getInt));

        coutln("8: " + integerList.indexOf(9));  // -1
        coutln("9: " + integerList.remove(new Integer(9)));  // false

        List<Integer> integerList1 = new ArrayList<>();
        Collections.addAll(integerList1, 1, 5, 2);

        coutln("10: " + integerList.containsAll(integerList1));
        Collections.sort(integerList1);  // 原地操作
        coutln("11: " + integerList1);

        Collections.shuffle(integerList1, rand);  // 随机排序
        coutln("12: " + integerList1);

        // Collection的构造器接受另一个Collection用于自己的初始化
        List<Integer> copy = new ArrayList<>(integerList);
        coutln("13: " + copy);
        integerList1 = Arrays.asList(2, 8, 80);
        copy.retainAll(integerList1);  // 交集
        coutln("13: " + copy);

        integerList.removeAll(integerList1);
        coutln("14: " + integerList);

        integerList.set(1, 118);  // 设置新值
        coutln("15: " + integerList);

        integerList.addAll(copy);
        coutln("16: " + integerList);

        copy.clear();
        coutln("17: " + copy.isEmpty());

        Object[] o = integerList.toArray();
        coutln("18: " + o[3]);

        Integer [] i = integerList.toArray(new Integer[0]);
        coutln("19: " + i[3]);


    }
}
