package 上课.容器;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {


    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>(Arrays.asList("abc", "def", "hig"));
        List<String> list2 = new ArrayList<String>(list1);
        System.out.println(list1);
        System.out.println(list2);
    }
}
