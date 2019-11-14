package Note.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupTest {
    public static void main(String[] args) {
        String testString = "ABCDABCDABCD";
        String regex = "A(B(C))D";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(testString);

        System.out.println(matcher.groupCount());
        boolean isFind = matcher.find();
        System.out.println(matcher.group());
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));
    }
}
