package Note.jxgl;

import java.util.ArrayList;

public class JXGL {

    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    private ArrayList<Classes> classesList = new ArrayList<>();
    private ArrayList<Course> courses = new ArrayList<>();

    public static JXGL jxgl = new JXGL();
    static ClassManage classManage = new ClassManage(jxgl.classesList);
    static StudentManage studentManage = new StudentManage(jxgl.students);
    static TeacherManage teacherManage = new TeacherManage(jxgl.teachers);
    static CourseManage courseManage = new CourseManage(jxgl.courses);

    private JXGL(){ }

    public static ClassManage creatNewClass(int id, String name){
        Classes classes = new Classes(id,name, new ArrayList<Student>(), new ArrayList<Teacher>());
        classManage.add(classes);
        return new ClassManage(classes, jxgl.classesList);
    }

    public static void addStudentToClass(ClassManage classManage, String name){
        classManage.addNewStudent(jxgl.students, name);
    }

    public static void addNewStudent(String name, int graduation){
        studentManage.add(name,graduation);
    }

    public static void addNewTeacher(int id, String name){
        teacherManage.add(new Teacher(id,name));
    }

    public static void addLeader(ClassManage classManage, String name){
        classManage.addNewLeader(jxgl.teachers, name);
    }


    public static void main(String[] args) {
        ClassManage c1 = creatNewClass(1, "17070141");
        ClassManage c2 = creatNewClass(2, "17070142");
        ClassManage c3 = creatNewClass(3, "17070143");

        Teacher t1 = new Teacher(1, "zhang");
        Teacher t2 = new Teacher(2, "wang");

        addNewStudent("zhangsan", 1000);
        addNewStudent("lisi", 1001);
        addNewStudent("wangwu",1002);
        addNewStudent("zhaoliu", 1000);

        addNewTeacher(1,"zhang");
        addNewTeacher(2,"wang");

        addLeader(c1, "zhang");
        teacherManage.alert(1,"li");

        addStudentToClass(c1, "zhangsan");

        c1.printClassInfo();
    }
}
