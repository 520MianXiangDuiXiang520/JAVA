package Note.annotation;

import 上课.interfacedemo.D;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyCheck {

    public static void main(String[] args) throws IOException {
        Demo demo = new Demo();
        int errorNum = 0;
        Class<? extends Demo> aClass = demo.getClass();
        Method[] methods = aClass.getMethods();
        FileWriter fileWriter = new FileWriter("./src/Note/annotation/error.txt", true);
        fileWriter.write("\n" +aClass.getName() + "的测试结果 【" +
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) +" 】 \n");
        fileWriter.write("======================================================================\n");
        for (Method m:methods
             ) {
            if(m.isAnnotationPresent(Check.class)) {
                try {
                    m.invoke(demo);
                } catch (Exception e) {
                    errorNum ++;
                    fileWriter.write(m.getName() + " 发生异常 " + "异常类型为：" + e.getCause().getClass().getSimpleName() + "\n");
                    fileWriter.write("异常原因为：" + e.getCause().getMessage() + "\n");
                    fileWriter.write("----------------------------------------------------------------------------------- \n");
                }
            }
        }
        fileWriter.write("======================================================================\n" +
                "测试结束，共发现" + errorNum + "个异常");
        fileWriter.close();
    }
}
