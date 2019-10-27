package Note.exceptions;

public class MultipleReturns {
    public static void f(int i) {
        System.out.println("Initialization that requires cleanup");
        try{
            System.out.println("print 1");
            if(i == 1)
                return;
            System.out.println("print 2");
            if(i == 2)
                return;
            System.out.println("print 3");
            if(i == 3)
                return;
            System.out.println("end");
            return;
        }finally {
            System.out.println("finally");
        }
    }

    public static void main(String[] args) {
        for(int i = 1; i <= 4; i++ ){
            f(i);
        }
    }
}
