package Note.strings;
import static junbao.tool.Print.*;

public class Receipt {
    public static void main(String[] args) {
        System.out.printf("%-15s %-5s %-10s\n", "Item", "Qty", "Price");
        System.out.println("hello\\world".matches("\\\\"));
        cout("hello world".split("\\W"));
    }
}
