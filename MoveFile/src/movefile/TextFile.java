package movefile;
import java.io.*;
import swt.Main;
import org.eclipse.swt.widgets.ProgressBar;
import java.util.*;

public class TextFile extends ArrayList<String> {
	
	
	public static StringBuilder getBuilder(String fileName) {
		StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in= new BufferedReader(new FileReader(
                    new File(fileName).getAbsoluteFile()));
            try {
                String s;
                while((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        return sb;
	}
	
    public static String read(String fileName) {
        return getBuilder(fileName).toString();
    }
    
    public static int getLines(String fileName) {
    	return getBuilder(fileName).length();
    }
    
    public static void write(String fileName, String text) {
    	System.out.print("aaa");
        try {
            PrintWriter out = new PrintWriter(
                    new File(fileName).getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    public TextFile(String fileName, String splitter) {
        super(Arrays.asList(read(fileName).split(splitter)));
        if(get(0).equals("")) remove(0);
    }
    public TextFile(String fileName) {
        this(fileName, "\n");
    }
    public void write(String fileName) {
        try {
            PrintWriter out = new PrintWriter(
                    new File(fileName).getAbsoluteFile());
            try {
                for(String item : this)
                	progressBar.setSelection (progress Bar.getSelection() + 1);
                    out.println(item);
            } finally {
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        String file = read("E:\\DjangoTestvir\\Project\\FamilyPropertyMS\\README.md");
        write("test.txt", file);
        TextFile text = new TextFile("test.txt");
        text.write("test2.txt");
    }
}

