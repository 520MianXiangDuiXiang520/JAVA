package Note.holding;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static junbao.tool.Print.*;

public class CrossContainerIteration {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "a", "b", "c");
        cout(strings.iterator());
        String [] s = {"d", "e", "f"};
        cout(s, false);
    }
}
