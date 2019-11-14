package Note.typeinfo;

import static junbao.tool.Print.*;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class ShowMethods {
    public static void main(String[] args) {
        try{
            Class<?> c =  Class.forName("Note.typeinfo.ShowMethods");
            cout(c.getMethods(), "\n");
            coutLine("-", 10);
            cout(c.getConstructors());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
