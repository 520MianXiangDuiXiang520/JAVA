package Note.iosystem;

import java.io.*;

public class ConversionStream {
    public static void main(String[] args) throws IOException {
        String filePath = "./src/Note/iosystem/DirList.java";
        String filePathGBK = "./src/Note/iosystem/DirListGBK.java";
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePathGBK), "GBK");
        char [] chars = new char[1024];
        int result = isr.read(chars);
        while (result >= 0) {
            osw.write(chars);
            result = isr.read(chars);
        }
        isr.close();
        osw.close();
    }
}
