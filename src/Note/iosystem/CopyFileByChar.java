package Note.iosystem;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFileByChar {
    private String sourcePath, targetPath;
    CopyFileByChar (String source, String target) {
        sourcePath = source;
        targetPath = target;
    }

    public void copy() throws IOException {
        FileReader fr = new FileReader(this.sourcePath);
        FileWriter fw = new FileWriter(this.targetPath, true);
        int readResult = 0;
        char [] chars = new char[1024];
        while(readResult >= 0) {
            readResult = fr.read(chars);
            if(readResult > 0){
                fw.write(chars, 0, readResult);
            }

        }
        fr.close();
        fw.close();
    }

    public static void main(String[] args) throws IOException {
        CopyFileByChar copyFileByChar = new CopyFileByChar("./src/Note/iosystem/DirList.java",
                "./src/Note/iosystem/DirListCopyByChar.txt");
        copyFileByChar.copy();
    }
}
