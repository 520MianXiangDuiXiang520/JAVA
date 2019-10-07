package Note.Chapter10_4;
import static junbao.tool.Print.*;

public class TestParcel {
    public static void main(String[] args) {
        Parcel4 parcel4 = new Parcel4();
        Contents contents = parcel4.getContents();
        Destination destination = parcel4.getDestination("TestParcel Main");
        coutln(contents.value());
        coutln(destination.readLabel());
    }
}
