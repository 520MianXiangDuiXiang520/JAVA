package Note.typeinfo;

class Test {
    Test() {
        System.out.println("test() init");
    }
}

public class ClassTest {
    public static void main(String[] args) {
        Class<Test> testClass = Test.class;
        Class<Test> testClass2;
        Test test1,test3;
        try{
            testClass2 = (Class<Test>) Class.forName("Note.typeinfo.Test");
            System.out.println(testClass2);
            System.out.println(testClass.equals(testClass2));
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
        try{
            test1 = testClass.newInstance();
            test3 = testClass2.newInstance();
        }catch(Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(testClass);
    }
}
