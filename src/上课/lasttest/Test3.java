package 上课.lasttest;

public class Test3 {
    public void s() {
        int j = 0;
        for(j = 0;j < 2; ++j) {
            System.out.println(j);
        }
        System.out.println((j));
    }

    /**
     *   public int m();
     *     Code:
     *        0: iconst_1
     *        1: istore_1
     *        2: iload_1
     *        3: iinc          1, 1
     *        6: istore_2
     *        7: iload_2
     *        8: ireturn
     *
     *   public int q();
     *     Code:
     *        0: iconst_1
     *        1: istore_1
     *        2: iinc          1, 1
     *        5: iload_1
     *        6: istore_2
     *        7: iload_2
     *        8: ireturn
     */

    public int m() {
        int s = 1;
        int q = s++;
        return q;
    }

    public int q() {
        int s = 1;
        int q = ++s;
        return q;
    }
    public static void main(String[] args) {
        Test3 test3 = new Test3();
        test3.s();
        test3.q();
        test3.m();
    }
}

/**
 *  public void s();
 *     Code:
 *        0: iconst_0  将0压入栈
 *        1: istore_1  将0装入局部变量1
 *        2: iconst_0  0压入栈
 *        3: istore_1  将0装入局部变量1
 *        4: iload_1   从局部变量1装载0
 *        5: iconst_2  把2压入栈
 *        6: if_icmpge     22   如果大于等于2，跳转到22
 *        9: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *       12: iload_1
 *       13: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
 *       16: iinc          1, 1
 *       19: goto          4
 *       22: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *       25: iload_1
 *       26: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
 *       29: return
 */
