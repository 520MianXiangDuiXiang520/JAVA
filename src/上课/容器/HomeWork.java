package 上课.容器;

import java.util.*;

class Student {
    private String name;
    private int id;

    public Student(String name){
        this.name = name;
    }

    public String toString(){
        return this.name;
    }
}

public class HomeWork {
    public static void main(String[] args) {
        /**
         * List 是一个接口，arrayList实现了这个接口，按插入顺序存储对象
         * HashSet是实现了接口Set的一个类，按哈希索引存储数据，重复对象不重复存储（会丢失插入时的顺序）
         * HashMap是实现了接口Map的一个类，按键值对的方式存储，按键建立哈希索引进行存储。
         */
        Student student = new Student("张三");
        Student student1 = new Student("李四");
        Student student2 = new Student("王五");
        List<Student> studentList = new ArrayList<>(Arrays.asList(student, student1, student1, student2));
        Set<Student> studentSet = new HashSet<>(Arrays.asList(student, student1, student1, student2));
        Map<Integer, Student> studentMap = new HashMap<>();
        studentMap.put(10, student);
        studentMap.put(1, student);
        studentMap.put(2, student1);
        studentMap.put(3, student2);
        System.out.println(studentList);
        System.out.println(studentSet);
        System.out.println(studentMap);
    }
}
