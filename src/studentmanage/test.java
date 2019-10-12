package studentmanage;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class test {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String second = input.nextLine();
        int id =  Integer.valueOf(second);
        System.out.println(id);
        System.out.println(second.length());
    }
}
