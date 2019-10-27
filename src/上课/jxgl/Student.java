package 上课.jxgl;
import static junbao.tool.Print.*;

public class Student extends Things {
    public int graduation;
    Student(int id, String name, int graduation){
        super(id, name);
        this.graduation = graduation;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Student)obj).name.equals(this.name);
    }

    public static void main(String[] args) {
        Student a = new Student(1,"张三",1);
        Student b = new Student(2, "张三", 2);
        cout(a.equals(b));
    }
}
