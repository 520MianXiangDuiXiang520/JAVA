package Note.Chapter10_4;
import static junbao.tool.Print.*;

// 定义在方法内部的内部类
public class Parcel5 {
    public Destination destination(String s) {
        class PDestination implements Destination {
            private String label;
            private PDestination(String whereTo) {
                this.label = whereTo;
            }

            @Override
            public String readLabel() {
                return label;
            }
        }
        return new PDestination(s);
    }

    public static void main(String[] args) {
        Parcel5 p5 = new Parcel5();
        Destination de = p5.destination("java");
        coutln(de.readLabel());
    }
}
