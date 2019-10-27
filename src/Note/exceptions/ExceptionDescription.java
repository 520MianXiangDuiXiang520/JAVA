package Note.exceptions;

class TooBig extends Exception{}
class TooSmall extends Exception{}

interface TestInterface1 {
    void method () throws TooBig, TooSmall;
    void method2();
}

public class ExceptionDescription implements TestInterface1 {
    @Override
    public void method() throws TooBig, TooSmall {
        throw new TooBig();

    }

    @Override
    public void method2(){
//        throw new TooSmall();
    }
}
