package Note.enumDemo;

public class Main {
    public static void main(String[] args) {
        String name = Season.SUMMER.name();
        System.out.println(name);

        Season[] values = Season.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i].toString());
        }
        Season.SUMMER.poem();

        Season spring = Season.valueOf("SPRING");
        System.out.println(spring);
    }
}
