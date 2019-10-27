package Note.exceptions;
import static junbao.tool.Print.*;

public class ExceptionMethods {
    public static void main(String[] args) {
        try{
            throw new Exception("My Exception");
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            System.out.println(e);
            cout(e.getStackTrace());
            // 输出栈轨迹
            e.printStackTrace(System.out);
            // 默认标准错误流
            e.printStackTrace();
        }
    }
}
