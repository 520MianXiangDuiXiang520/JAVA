package Note.typeinfo.proxydemo;

import java.lang.reflect.Proxy;

public class Customer {
    public static BuyTicketInterface getProxy(Object obj) {
        BuyTicketInterface proxy = (BuyTicketInterface) Proxy.newProxyInstance(
                BuyTicketInterface.class.getClassLoader(),
                new Class[]{BuyTicketInterface.class},
                new TheProxy(obj)
        );
        return proxy;
    }
    public static void main(String[] args) {
        Server2 server = new Server2();
        BuyTicketInterface proxy = getProxy(server);
        proxy.getTicket();
    }
}
