package Note.study_io.oi01;

import java.io.File;
import java.io.IOException;

public class StudentFile01 {
    public static void main(String[] args) throws IOException {
        // Java 中一个 “\” 表示转义开始
        File file = new File("E:\\桌面文件\\JAVA\\src\\Note\\study_io\\oi01\\demo2.txt");
        File file1 = new File("E:\\桌面文件\\JAVA\\src\\Note\\study_io\\oi01", "demo.txt");
        File file2 = new File("E:\\桌面文件\\JAVA\\src\\Note\\study_io\\oi01");
        File file3 = new File(file2, "demo.txt");
        File file5 = new File("E:\\hhssh\\h");
        System.out.println(file.lastModified());
        File file4 = new File(file5, "demo2.txt");
        boolean newFile = file2.createNewFile();
        System.out.println(newFile);
        System.out.println(file.delete());


        boolean mkdir = file5.mkdir();
        System.out.println(mkdir);

        System.out.println(file2.delete());
        System.out.println(file2.length());
        System.out.println(new File("\\jjy\\s.png").length());
    }
}
