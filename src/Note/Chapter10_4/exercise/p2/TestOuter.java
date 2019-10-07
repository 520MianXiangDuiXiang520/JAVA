package Note.Chapter10_4.exercise.p2;
import Note.Chapter10_4.exercise.p1.TestInterface;

public class TestOuter {
    protected class TestInner implements TestInterface{
        private String name;
        private int count = 0;

        TestInner(String name){
            this.name = name;
        }

        @Override
        public String name() {
            return name;
        }

        @Override
        public int count() {
            return count;
        }

        public String toString(){
            return name;
        }
    }

    public TestInterface getTestInner(String s){
        return new TestInner(s);
    }
}
