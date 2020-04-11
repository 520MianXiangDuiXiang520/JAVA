package 上课.lasttest;

public class test1 {
    public static void main(String[] args) {
        int s = 1;
        while(s-- > 0) {
            System.out.println(s);
        }
        System.out.println(s);
    }
    /**
     * s--
     *  public static void main(java.lang.String[]);
     *     Code:
     *        0: bipush        6
     *        2: istore_1
     *        3: iload_1
     *        4: iinc          1, -1
     *        7: ifle          20
     *       10: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *       13: iload_1
     *       14: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
     *       17: goto          3
     *       20: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *       23: iload_1
     *       24: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
     *       27: return
     * }
     * <center><h2>--s</h2></center>
     * public static void main(java.lang.String[]);
     *     Code:
     *        0: bipush        6
     *        2: istore_1
     *        3: iinc          1, -1
     *        6: iload_1
     *        7: ifle          20
     *       10: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *       13: iload_1
     *       14: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
     *       17: goto          3
     *       20: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *       23: iload_1
     *       24: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
     *       27: return
     * }
     */
}
