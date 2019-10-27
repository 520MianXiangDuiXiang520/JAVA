package Note.exceptions;

public class NeverCaught {
    static void f(){
        throw new RuntimeException();
    }

    static void g(){
        f();
    }

    public static void main(String[] args) {
        g();
    }
}
