package Note.holding;
import java.util.*;
import static junbao.tool.Range.*;

// 简单迭代器类
public class SimpleIteration {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        Collections.addAll(stringList, "a", "b", "c");
        Iterator<String> it = stringList.iterator();
//        while(it.hasNext()){
//            String p = it.next();
//            System.out.println(p);
//        }
        for(int i=0;i<1;i++){
            it.next();
            it.remove();
        }
        System.out.println(stringList);
    }

}
