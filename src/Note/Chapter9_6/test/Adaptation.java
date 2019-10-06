package Note.Chapter9_6.test;

// 策略模式
public class Adaptation {
    public static void accept(MyInterfice miace){
        System.out.println("name is: " + miace.name());
    }
}
