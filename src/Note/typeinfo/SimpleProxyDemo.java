package Note.typeinfo;
import static junbao.tool.Print.*;

interface Interface {
    void doSomeThing();
    void somethingElse(String arg);
}

class RealObject implements Interface {
    @Override
    public void doSomeThing() {
        coutln("doSomething()");
    }

    @Override
    public void somethingElse(String arg) {
        coutln("somethingElse" + arg);
    }
}

class SimpleProxy implements Interface {
    private Interface proxied;
    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomeThing() {
        coutln("SimpleProxy doSomeThing");
        proxied.doSomeThing();
    }

    @Override
    public void somethingElse(String arg) {
        coutln("SimpleProxy somethingElse" + arg);
        proxied.somethingElse(arg);
    }
}

public class SimpleProxyDemo {
    public static void consumer(Interface inface) {
        inface.doSomeThing();
        inface.somethingElse("mayiyahei");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}
