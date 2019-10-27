package Note.exceptions;

class Demo{
    Demo(String name){
        System.out.println(name);
    }
}

public class CatchException {
    public static void method(int s) throws TooBig {
        if(s > 10){
            throw new TooBig();
        }else{
            System.out.println(s);
        }
    }
    public static void main(String[] args) throws TooBig {
        Demo s1, s2, s3, s4;
        try{
            s1 = new Demo("s1");
            s2 = new Demo("s2");
            method(11);
            System.out.println("11");
            s3 = new Demo("s3");
            s4 = new Demo("s4");
        }catch(TooBig e){
            System.out.println(e);
        }
    }
}
