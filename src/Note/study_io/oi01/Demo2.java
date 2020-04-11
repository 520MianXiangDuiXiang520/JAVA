package Note.study_io.oi01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(new File("demo2.txt"));
        byte[] bytes = "Hello IO".getBytes();
        fos.write(bytes);
        fos.close();

        FileOutputStream fos2 = new FileOutputStream(new File("demo2.txt"), true);
        fos2.write(36);

        // 默认查看ASCII,如果有负数，或者超过127，就会按照系统编码规则，和后面的一个或两个一起组成一个
        byte [] bytes1 = {37, 38, 39, 40, 41, -42, 43, 44};
        fos2.write(bytes1);
        fos2.write("\n".getBytes());
        fos2.write(bytes1, 2, 2);
    }
}
