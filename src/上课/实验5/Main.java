package 上课.实验5;

public class Main {
    public static void main(String[] args) {
        Student [] students = {
                new BenKeStudent("张三", 10),
                new BenKeStudent("李四", 30),
                new YanJiuStudent("王五", 15),
                new YanJiuStudent("赵六",20)
        };
        for(Student student: students){
            System.out.println(student);
        }
    }
}
