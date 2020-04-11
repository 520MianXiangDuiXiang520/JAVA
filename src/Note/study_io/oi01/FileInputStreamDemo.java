package Note.study_io.oi01;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("demo2.txt");
//        int getData = 0;
//        while(getData != -1) {
//            getData = fis.read();
//            System.out.println(getData);
//        }

//        byte [] bytes = new byte[5];
//        int read = fis.read(bytes);
//        System.out.println(read);
//        System.out.println(Arrays.toString(bytes));
//        System.out.println(new String(bytes));

        int len = 0;
        byte [] bytes = new byte[1024];
        while((len = fis.read(bytes)) != -1){
            System.out.println(new String(bytes, 0, len));
        }

    }
}
