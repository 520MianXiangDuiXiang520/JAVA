package junbao.tool;
import java.io.*;

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

    public static PrintStream
    Printf(String format, Object... args){
        return System.out.printf(format,args);
    }
}
