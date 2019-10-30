package Note.strings;
import java.util.regex.*;

public class TestRegularExpression {
    public static void main(String[] args) {
        if(args.length < 2){
            System.err.println("error");
            System.exit(0);
        }

        for(String arg: args){
            System.out.println("Input:\"" + args[0] + "\"");
            Pattern p = Pattern.compile(arg);
            Matcher m = p.matcher(args[0]);
            while(m.find()) {
                System.out.println(
                        "Match \"" + m.group() + "\" at positions " + m.start() + "-" + (m.end()-1)
                );
            }
        }


    }
}
