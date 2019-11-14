package Note.typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class MethodSelector implements InvocationHandler {
    private Object proxied;
    public MethodSelector (Object proxied) {
        this.proxied = proxied;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("interesting"))
            System.out.println("Proxy detected the interesting method");
        return method.invoke(proxied, args);
    }
}

interface SomeMethods {
    void boringJava();
    void boringPython();
    void interesting(String play);
    void boringEveryThing();
}

class Implementation implements SomeMethods {
    @Override
    public void boringJava() {
        System.out.println("so boring java");
    }

    @Override
    public void boringPython() {
        System.out.println("so boring python");
    }

    @Override
    public void interesting(String play) {
        System.out.println("so interesting to play " + play);
    }

    @Override
    public void boringEveryThing() {
        System.out.println("every thing are so boring");
    }
}

public class SelectMethods {
    public static void main(String[] args) {
        SomeMethods proxy = (SomeMethods) Proxy.newProxyInstance(
                SomeMethods.class.getClassLoader(),
                new Class[]{SomeMethods.class},
                new MethodSelector(new Implementation())
        );
        proxy.boringJava();
        proxy.boringPython();
        proxy.interesting("I don't like student");
        proxy.boringEveryThing();
    }
}
