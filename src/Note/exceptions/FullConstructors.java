package Note.exceptions;

class MyException extends Exception{
    MyException(){}
    MyException(String s) {
        super(s);
    }
}

public class FullConstructors {
    public static void f() throws MyException {
        System.out.println("throws MyException()");
        throw new MyException();
    }

    public static void g() throws MyException {
        System.out.println("throws MyException(String)");
        throw new MyException("error");
    }

    public static void main(String[] args){
        try {
            f();
        }catch (MyException m){
            // 标准输出流
            m.printStackTrace(System.out);
        }

        try {
            g();
        }catch (MyException m){
            // 标准错误流
            m.printStackTrace();
        }
    }
}
