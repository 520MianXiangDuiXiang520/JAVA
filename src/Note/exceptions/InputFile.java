package Note.exceptions;
import java.io.*;

public class InputFile {
    private BufferedReader in;
    public InputFile(String fileName) throws Exception {
        try{
            in = new BufferedReader(new FileReader(fileName));
        }catch(FileNotFoundException e){
            System.out.println("Could not open " + fileName);
            throw e;
        }catch(Exception e){
            try{
                in.close();
            }catch(IOException e2){
                System.out.println("Unclosed file");
            }
            throw e;
        }finally {
            //....
        }
    }

    public String getLine() {
        String s;
        try{
            s = in.readLine();
        }catch(IOException e){
            throw new RuntimeException("readLine() failed");
        }
        return s;
    }

    public void dispose() {
        try{
            in.close();
            System.out.println("dispose() successful");
        }catch(IOException e2){
            throw new RuntimeException("in.close() failed");
        }
    }
}
