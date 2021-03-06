package Note.iosystem;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

class DirFilter implements FilenameFilter {
    private Pattern pattern;
    DirFilter (String regex){
        pattern = Pattern.compile(regex);
    }
    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
// File的简单用法
public class DirList {
    public static void main(String[] args) {
        File file = new File("./src/Note/iosystem");
        String filter = ".*\\.java";
        String [] filenames = file.list(new DirFilter(filter));
        assert filenames != null;
        for (String filename:filenames
             ) {
            System.out.println(filename);
        }
    }
}
