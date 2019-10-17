package junbao.tool;
import java.io.*;
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
        for(int i = 0; i<obj.length; i++){
            cout(obj[i] + ", ");
        }
        coutln();
    }

    public static void cout(Object[] obj, boolean s){
        if(!s)
            System.out.println(obj);
        else
            cout(obj);
    }

    public static PrintStream
    Printf(String format, Object... args){
        return System.out.printf(format,args);
    }
}
