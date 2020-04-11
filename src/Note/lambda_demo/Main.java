package Note.lambda_demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.function.Predicate;

public class Main {
    public Object[] filterInteger(int[] nums, Predicate<Integer> filter) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(filter.test(nums[i])){
                result.add(nums[i]);
            }
        }
        return result.toArray();
    }

    public int getP(int p) {
        return p;
    }

    public static void main(String[] args) {
        Main main = new Main();
//        Demo01 demo01 = new Demo01() {
//            @Override
//            public void test() {
//                System.out.println("通过匿名内部类实现接口");
//            }
//        };
        Demo01 demo01 = () -> System.out.println("lll");

//        Demo02 demo02 = (int s) -> {
//            return s * s;
//        };
        Demo02 demo02 = (int s) -> s * s;

        demo01.test();
        System.out.println(demo02.test(13));

        Demo03 demo03 = demo02::test;
        System.out.println(demo03.test(10));

//        Demo04 demo04 = () -> new HashMap();
        Demo04 demo04 = HashMap::new;

        Predicate<Integer> predicate = (Integer s) -> s % 2 == 0;
        int [] nums = {-1, 2, 8, -9, 0, 7, -5};

        System.out.println(Arrays.toString(main.filterInteger(nums, predicate)));

    }
}
