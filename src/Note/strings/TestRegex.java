package Note.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("(?m)([a-zA-Z]+)(\\s*)([,]*)");
        Matcher matcher = p.matcher("We all live in sewers," +
                " but there are always people looking up at the stars");
        System.out.println(matcher.groupCount());
        while(matcher.find()){
            System.out.print(matcher.group(3) + "-");
        }
        System.out.println();
        String s1 = matcher.replaceAll("hah");
        System.out.println(s1);
        String s3 = matcher.replaceFirst("first");
        System.out.println(s3);
        System.out.println(matcher.matches());
    }
}
