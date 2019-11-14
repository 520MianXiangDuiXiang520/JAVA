package Note.typeinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Student {
    private String privateVar = null;
    public String publicVar = null;
    String protectedVar = null;
    private String privateVar1 = null;
    public String publicVar1 = null;
    String protectedVar1 = null;

    private Student() {}
    public Student(String s) {}
    Student(int s) {}

    public void publicMethod1(){}
    public void publicMethod2(){}

    void protectedMethod1() {}
    void protectedMethod2() {}

    private void privateMethod1() {}
    private void privateMethod2() {}
}

public class StudentClassObject {
    public static Class getClassByName(String name) throws ClassNotFoundException {
        return Class.forName(name);
    }

    public static Class getClassByObject(Object obj) {
        return obj.getClass();
    }

    public static Class getClassByClass() {
        return Student.class;
    }
    public static void main(String[] args) throws Exception {
        Student student = new Student("111");
        Class c1 = getClassByClass();
        Class c2 = getClassByName("Note.typeinfo.Student");
        Class c3 = getClassByObject(new Student(""));
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        Field[] field = c1.getFields();

        Method[] methods = c2.getMethods();
        Constructor[] constructors = c3.getConstructors();
//        setAccessible(true);
        Field var1 = c1.getField("publicVar");
        var1.set(student, "111");
        Field var2 = c1.getDeclaredField("privateVar");
        var2.setAccessible(true);
        var2.set(student,"222");
        System.out.println(student.publicVar);
        System.out.println(var1);
        for (Field f:field
             ) {
            System.out.println(f.getName());
            f.set(student, "11");
        }
//        System.out.println(field);
    }
}
