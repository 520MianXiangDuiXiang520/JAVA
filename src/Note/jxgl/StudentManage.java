package Note.jxgl;

import java.util.ArrayList;

public class StudentManage extends Manage {
    // 学生个数计数器，实现学号递增
    private static int studentCount = 0;

    StudentManage(ArrayList al) {
        super(al);
    }

    public void add(String name, int graduation){
        /**
         * 增加一个学生，覆盖基类方法，实现学号递增
         */
        super.add(new Student(studentCount ++,name, graduation));
    }

    public void getInfo(Student student){
        String by;
        Student findStudent = (Student) find(student);
        if(findStudent != null) {
            if(findStudent.graduation == 1001)
                by = "已毕业";
            else if(findStudent.graduation == 1002)
                by = "已肄业";
            else
                by = "未毕业";
            System.out.println(student.id + "   " + student.name + "   " + by);
        }
        else
            System.out.println("没找到");
    }

    public void getInfo(int id){
        Student findStudent = (Student) find(id);
        if(findStudent != null)
            getInfo(findStudent);
    }

    public void getInfo(String name){
        Student findStudent = (Student) find(name);
        if(findStudent != null)
            getInfo(findStudent);
    }

    // 重载基类alter方法，实现修改

    public void alter(Student person, int newGrad){
        /**
         * 通过对象修改信息（修改graduation）
         */
        if(list.contains(person)){
            int index = list.indexOf(person);
            Student student = (Student) list.get(index);
            student.graduation = newGrad;
        }
    }

    public void alert(int id,int newGrad){
        /**
         * 通过id修改信息（修改graduation）
         */
        Student findStudent = (Student)find(id);
        if(findStudent != null)
            alter(findStudent, newGrad);
    }

    public void alert(String name, int newGrad){
        /**
         * 通过name修改信息（修改graduation）
         */
        Student findStudent = (Student)find(name);
        if(findStudent != null)
            alter(findStudent, newGrad);
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        StudentManage sm = new StudentManage(students);

        sm.add("zhangsan", 1001);
        sm.add("xiaohong", 1001);
        sm.printAll();
        sm.getInfo("zhangsan");
        sm.delete(1);
        sm.printAll();
    }
}
