package Note.strings;

import java.util.ArrayList;
import java.util.List;

public class InfiniteRecursion {
    public String toString(){
        return "InfiniteRecursion address: " + super.toString() + "\n";
    }

    public static void main(String[] args) {
        List<InfiniteRecursion> infiniteRecursionList = new ArrayList<>();
        for(int i=0;i<10;i++){
            infiniteRecursionList.add(new InfiniteRecursion());
        }
        System.out.println(infiniteRecursionList);
    }
}
