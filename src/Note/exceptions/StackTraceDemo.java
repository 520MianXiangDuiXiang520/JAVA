package Note.exceptions;
import static junbao.tool.Print.*;

public class StackTraceDemo {
    public void q() throws MyException{
        throw new MyException();
    }

    public void w() throws MyException {
        q();
    }

    public void e() throws MyException {
        w();
    }

    public void r() throws MyException {
        e();
    }

    public static void main(String[] args) {
        StackTraceDemo stackTraceDemo = new StackTraceDemo();
        try{
            stackTraceDemo.r();
        }catch(MyException e){
            // 打印数组
            cout(e.getStackTrace(),"\n");
        }
    }
}
/*
Note.exceptions.StackTraceDemo.q(StackTraceDemo.java:6)
Note.exceptions.StackTraceDemo.w(StackTraceDemo.java:10)
Note.exceptions.StackTraceDemo.e(StackTraceDemo.java:14)
Note.exceptions.StackTraceDemo.r(StackTraceDemo.java:18)
Note.exceptions.StackTraceDemo.main(StackTraceDemo.java:24)
 */
