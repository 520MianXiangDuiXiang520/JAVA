package Note.iosystem;

import java.io.*;

public class BufferDemo {
    private String from, to;
    public BufferDemo(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public void copy() throws IOException {
        BufferedReader bfr = new BufferedReader(new FileReader(this.from));
//        char [] chars = new char[1024];
//        bfr.read(chars);
        BufferedWriter bfw = new BufferedWriter(new FileWriter(this.to));
        String line = bfr.readLine();
        while (line != null) {
            bfw.write(line);
            bfw.newLine();
            line = bfr.readLine();
        }
        bfr.close();
        bfw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferDemo bd = new BufferDemo("./src/Note/iosystem/DirList.java",
                "./src/Note/iosystem/DirListCopyByChar.txt");
        bd.copy();
    }
}
