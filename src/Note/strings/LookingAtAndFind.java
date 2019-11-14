package Note.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LookingAtAndFind {
    public static void main(String[] args) {
        String testString = "We all live in sewers,but there are always people looking up at the stars";
        String regex1 = "We";
        String regex2 = "stars";
        Pattern pattern1 = Pattern.compile(regex1);
        Pattern pattern2 = Pattern.compile(regex2);

        Matcher matcher1 = pattern1.matcher(testString);
        Matcher matcher2 = pattern2.matcher(testString);

        System.out.println(matcher1.lookingAt());
        System.out.println(matcher2.lookingAt());
        System.out.println(matcher1.find());
        System.out.println(matcher2.find());
        System.out.println(matcher1.matches());
        System.out.println(matcher2.matches());
    }
}
