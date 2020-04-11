package holiday.autoboxing;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {
    public void func1() {
        Integer integer = 3;
        int i = integer;
    }
    public void func2(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
    }

    public void func3(){
        Integer integer = 3;
        int i = 1;
        Integer integer1 = 1;
        boolean b1 = integer > i;
        boolean b2 = integer > integer1;
    }
    public void func4() {
        Integer integer = 3;
        int i = 1;
        Integer integer1 = 1;
        int s = integer + integer1;
        int s1 = integer + i;
    }

    public void func5() {
        boolean flag = true;
        Integer i = 8;
        int j;
        j = 3;
        int k = flag ? i: j;
    }

    public void func6() {
        boolean flag = true;
        Integer i = 0;
        int j;
        j = 1;
        Integer k = flag ? i: j;
    }
    public void func7() {
        boolean flag = true;
        Integer i = 0;
        int j;
        j = 1;
        int k = flag ? j: i;
    }
    public void func8() {
        boolean flag = true;
        Integer i = 0;
        int j;
        j = 1;
        int k = flag ? i: i;
    }
    public void func9() {
        boolean flag = true;
        Integer i = 0;
        int j;
        j = 1;
        Integer k = flag ? i: i;
    }
    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        demo1.func1();
        demo1.func2();

    }
}
