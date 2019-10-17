package Note.experiment6;

// 静态变量会最先被初始化，并且只会被初始化一次
// 会先执行变量赋值操作（如果在本类中实例化本类的非静态对象，就会造成死循环）
// 在构造器中使用this调用构造器，但需要作为第一条语句

class Test{
    Test(){
        System.out.println("TEST");
    }
}

public class Student {
    private String name;
    static int count;

    // 在main之前被执行
    static Student sj = new Student();

    Student(){
        count ++;
        System.out.println("默认构造器");
    }

    Student (String name){
        this(1);
        this.name = name;
        count ++;
        Student s1 = new Student(2);
        s1.name = name;
        System.out.println("带参构造器");
    }

    Student(int s){
        Student s2 = new Student();
        System.out.println("通过构造器内部调用" + s);
    }

    public static void f(){
        System.out.println("llll");
    }

    Test test = new Test();

    public static void main(String[] args) {
        System.out.println("main");
        Student s1 = new Student("");
        System.out.println(s1.count);
    }
}

//TEST
//默认构造器
//main
//TEST
//TEST
//默认构造器
//通过构造器内部调用1
//TEST
//TEST
//默认构造器
//通过构造器内部调用2
//带参构造器
//4