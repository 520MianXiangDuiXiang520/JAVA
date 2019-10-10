package Note.Chapter10_4;
import static junbao.tool.Print.*;

interface Service {
    void method1();
    void method2();
}

interface ServiceFactor {
    Service getService();
}

class Implementation1 implements Service{
    private Implementation1() {
        coutln("Implemention1 init");
    }
    @Override
    public void method1() {
        coutln("Implementation1 method1");
    }

    @Override
    public void method2() {
        coutln("Implementation method2");
    }

    // 匿名内部类实现了ServiceFactor接口
    public static ServiceFactor factor = new ServiceFactor() {
        @Override
        public Service getService() {
            return new Implementation1();
        }
    };
}

class Implementation2 implements Service {
    private Implementation2() {
        coutln("Implemention2 init");
    }

    @Override
    public void method1() {
        coutln("Implementation2 method1 ");
    }

    @Override
    public void method2() {
        coutln("Implementation2 method2");
    }

    public static ServiceFactor factor = new ServiceFactor() {
        @Override
        public Service getService() {
            return new Implementation2();
        }
    };
}

public class Factories {
    public static void serviceConsumer(ServiceFactor serviceFactor){
        Service service = serviceFactor.getService();
        service.method1();
        service.method2();
    }
    public static void main(String[] args) {
        serviceConsumer(Implementation1.factor);
        serviceConsumer(Implementation2.factor);
    }
}
