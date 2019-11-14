package Note.typeinfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Father{}

class Son extends Father{}

class GradeSon extends Son{}

public class TestIsInstance {

    public static void main(String[] args) {
        Son son = new Son();
        List<Class<? extends Father>> list =
                new ArrayList<Class<? extends Father>>(Arrays.asList(Father.class,Son.class, GradeSon.class));
        for (Class c: list
             ) {
            System.out.println(son instanceof Father);
        }

        System.out.println(Father.class.isInstance(son));
    }
}
