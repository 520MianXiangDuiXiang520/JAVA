package Note.exceptions;
import static junbao.tool.Print.*;

public class Rethrowing {
    public static void f() throws Exception {
        System.out.println("originating the exception in f()");
        throw new Exception("thrown from f()");
    }
    public static void g() throws Exception {
        try{
            f();
        }catch(Exception e){
            System.out.println("Inside g() e.printStackTrace()");
            e.printStackTrace(System.out);
            throw e;  // 重新抛出异常
        }
    }

    public static void h() throws Exception {
        try{
            f();
        }catch(Exception e){
            System.out.println("Inside h() e.printStackTrace()");
            e.printStackTrace(System.out);
            throw (Exception)e.fillInStackTrace();
        }
    }

    public static void main(String[] args) {
        try{
            g();
        }catch(Exception e){
            System.out.println("g() main() printStackTrace()");
            cout(e.getStackTrace(),"\n");
        }
        try{
            h();
        }catch(Exception e){
            System.out.println("h () main() printStackTrace()");
            cout(e.getStackTrace(),"\n");
        }
    }
}
/*
originating the exception in f()
Inside g() e.printStackTrace()
java.lang.Exception: thrown from f()
	at Note.exceptions.Rethrowing.f(Rethrowing.java:7)
	at Note.exceptions.Rethrowing.g(Rethrowing.java:11)
	at Note.exceptions.Rethrowing.main(Rethrowing.java:31)
g() main() printStackTrace()
Note.exceptions.Rethrowing.f(Rethrowing.java:7)
Note.exceptions.Rethrowing.g(Rethrowing.java:11)
Note.exceptions.Rethrowing.main(Rethrowing.java:31)

originating the exception in f()
Inside h() e.printStackTrace()
java.lang.Exception: thrown from f()
	at Note.exceptions.Rethrowing.f(Rethrowing.java:7)
	at Note.exceptions.Rethrowing.h(Rethrowing.java:21)
	at Note.exceptions.Rethrowing.main(Rethrowing.java:37)
h () main() printStackTrace()
Note.exceptions.Rethrowing.h(Rethrowing.java:25)
Note.exceptions.Rethrowing.main(Rethrowing.java:37)


Process finished with exit code 0

 */
