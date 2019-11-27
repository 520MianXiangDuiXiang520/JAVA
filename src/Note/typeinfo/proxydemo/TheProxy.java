package Note.typeinfo.proxydemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TheProxy implements InvocationHandler {
    private Object proxy;
    public TheProxy(Object proxy) {
        this.proxy = proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy");
        return method.invoke(this.proxy, args);
    }
}
