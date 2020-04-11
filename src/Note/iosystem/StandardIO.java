package Note.iosystem;

import java.io.*;

public class StandardIO {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String result = bfr.readLine();

        while (result != null && result.length() > 0) {
            System.setOut(new PrintStream(new FileOutputStream("./src/Note/iosystem/standard.txt", true)));
            System.out.println(result);
            result = bfr.readLine();
        }
    }
}
