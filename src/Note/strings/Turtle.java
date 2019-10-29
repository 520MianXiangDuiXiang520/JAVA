package Note.strings;

import java.io.PrintStream;
import java.util.Formatter;

public class Turtle {
    private String name;
    private Formatter f;
    public Turtle(String name, Formatter f) {
        this.f = f;
        this.name = name;
    }
    public void move (int x, int y) {
        f.format("%s The turtle is at (%d, %d)\n",name, x, y);
    }

    public static void main(String[] args) {
        PrintStream outAlias = System.out;

    }
}
