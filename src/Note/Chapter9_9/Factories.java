package Note.Chapter9_9;
import static junbao.tool.Print.*;

interface Server {
    void method1();
    void method2();
}

interface ServerFactory {
    Server getService();
}

class Implementation1 implements Server{
    Implementation1(){

    }

    @Override
    public void method1() {
        coutln("Implementation1 method1");
    }

    @Override
    public void method2() {
        coutln("Implementation1 method2");
    }
}

class Implementation1Factory implements ServerFactory{
    @Override
    public Server getService() {
        return new Implementation1();
    }
}

class Implementation2 implements Server{
    Implementation2(){}

    @Override
    public void method1() {
        coutln("Implementation method1");
    }

    @Override
    public void method2() {
        coutln("Implementation2 method2");
    }
}

class Implementation2Factory implements ServerFactory{
    @Override
    public Server getService() {
        return new Implementation2();
    }
}

public class Factories {
    public static void serviceConsumer (ServerFactory fact){
        Server s = fact.getService();
        s.method1();
        s.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(new Implementation1Factory());
        serviceConsumer(new Implementation2Factory());
    }
}
