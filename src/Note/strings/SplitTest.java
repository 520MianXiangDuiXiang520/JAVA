package Note.strings;

import java.util.regex.Pattern;
import java.util.*;
import static junbao.tool.Print.*;

public class SplitTest {
    public static void main(String[] args) {
        String testString = "We all live in sewers,but there are always people looking up at the stars";
        String regex = "a";
        System.out.println(Arrays.toString(Pattern.compile(regex).split(testString)));
        System.out.println(Arrays.toString(testString.split(regex)));
    }
}
