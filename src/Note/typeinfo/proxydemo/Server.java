package Note.typeinfo.proxydemo;

public class Server implements BuyTicketInterface{
    public Server() {}

    private String ticketName;
    private double ticketPrice;

    @Override
    public void getTicket() {
        this.ticketName = "vip";
        this.ticketPrice = 126.8;
        System.out.println("ticket: " + this.ticketName + "price: " + this.ticketPrice);
    }
}
