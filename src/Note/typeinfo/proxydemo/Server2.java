package Note.typeinfo.proxydemo;

public class Server2 implements BuyTicketInterface {
    @Override
    public void getTicket() {
        System.out.println("server2");
    }
}
