package Note.iosystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {

    private String sourcePath, targetPath;
    CopyFile (String source, String target) {
        sourcePath = source;
        targetPath = target;
    }

    public void copy() throws IOException {
        FileInputStream fis = new FileInputStream(this.sourcePath);
        FileOutputStream fos = new FileOutputStream(this.targetPath, true);
        byte [] bytes = new byte[1024];
        int readResult = 0;
        while(readResult >= 0) {
            readResult  = fis.read(bytes);
            if(readResult > 0) {
                fos.write(bytes, 0, readResult);
            }
        }
        fis.close();
        fos.close();
    }


    public static void main(String[] args) throws IOException {
        CopyFile copyFile = new CopyFile("./src/Note/iosystem/DirList.java",
                "./src/Note/iosystem/DirListCopy.txt");
        copyFile.copy();
    }
}
