package Note.exceptions;

class MyselfException extends Exception {}

public class SimpleException {
    public static void f() throws MyselfException {
        throw new MyselfException();
    }

    public static void main(String[] args) {
        try{
            f();
        }catch (MyselfException e){
            System.err.println(e);
        }
    }
}
