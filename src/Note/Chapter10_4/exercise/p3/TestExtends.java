package Note.Chapter10_4.exercise.p3;
import Note.Chapter10_4.exercise.p2.TestOuter;
import Note.Chapter10_4.exercise.p1.TestInterface;
import static junbao.tool.Print.*;

public class TestExtends extends TestOuter {
    public TestInterface returnProtected(String s){
        TestOuter to = new TestOuter();
        return to.getTestInner(s);
    }

    public static void main(String[] args) {
        TestExtends te = new TestExtends();
        TestInterface tif = te.returnProtected("inner");
        coutln(tif);
    }
}
