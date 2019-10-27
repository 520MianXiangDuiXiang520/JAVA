package 上课.jxgl;

import java.util.ArrayList;

public class TeacherManage extends Manage{
    TeacherManage(ArrayList al) {
        super(al);
    }


    public static void main(String[] args) {
        ArrayList<Teacher> teachers = new ArrayList<Teacher>();
        TeacherManage tm = new TeacherManage(teachers);
        Teacher t1 = new Teacher(1,"zhangsan");
        Teacher t2 = new Teacher(2, "lisi");
        tm.add(t1);
        tm.add(t2);
        tm.printAll();
        tm.delete("1111");
        tm.alert(t1, "wangwu");
        tm.printAll();
    }
}
