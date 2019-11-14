package junbao.tool;
import java.io.*;
import java.util.Arrays;
import java.util.Iterator;

public class Print {
    public static void coutln(Object obj){
        System.out.println(obj);
    }

    public static void coutln(){
        System.out.println();
    }

    public static void cout(Object obj){
        System.out.print(obj);
    }

    public static void cout(Iterator iterator){
        while(iterator.hasNext()){
            Object obj = iterator.next();
            cout(obj + ", ");
        }
        coutln();
    }

    public static void cout(Object[] obj){
        System.out.println(Arrays.toString(obj));
    }

    public static void coutln(Object[] obj){
        /**
         * 输出数组，废弃不用
         */
        cout(obj);
    }

    public static void cout(Object[] obj, String end){
        /**
         * 输出数组
         * end: 数组中每个元素输出之后的连接字符
         */
        for(int i = 0; i<obj.length; i++){
            cout(obj[i] + end);
        }
        coutln();
    }

    public static void cout(Object[] obj, boolean s){
        /**
         * 按默认输出数组
         */
        if(!s)
            System.out.println(obj);
        else
            cout(obj);
    }

    public static void coutLine(String s, int count) {
        /**
         * 重复某个字符s count 遍（用作分割线）
         */
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuffer.append(s);
        }
        System.out.println(stringBuffer.toString());
    }

    public static PrintStream
    Printf(String format, Object... args){
        return System.out.printf(format,args);
    }
}
