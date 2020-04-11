package holiday.autoboxing;

public class Demo2 {
    public static void main(String[] args) {
        Integer a1 = 133;
        Integer a2 = 133;
        int a3 = 133;
        boolean b1 = a1 == a2;
        boolean b2 = a1.equals(a2);
        boolean b3 = a1 == a3;
        boolean b4 = a1.equals(a3);
        System.out.println(b1);  // false
        System.out.println(b2);  // true
        System.out.println(b3);  // true
        System.out.println(b4);  // true
    }
}
