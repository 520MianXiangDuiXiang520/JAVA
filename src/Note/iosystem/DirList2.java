package Note.iosystem;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class DirList2 {
    public static void main(String[] args) {
        File file = new File("./src/Note/iosystem");
        String filter = ".*\\.java";
        String [] filenames = file.list(new FilenameFilter() {
            private Pattern pattern  = Pattern.compile(filter);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
        assert filenames != null;
        for (String filename:filenames
        ) {
            System.out.println(filename);
        }
    }
}
