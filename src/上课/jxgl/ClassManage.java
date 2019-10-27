package 上课.jxgl;

import java.util.ArrayList;


public class ClassManage extends Manage {
    private Classes classes;

    ClassManage(Classes classes,ArrayList classesArrayList) {
        super(classesArrayList);
        this.classes = classes;
    }

    ClassManage(ArrayList classesArrayList){
        super(classesArrayList);
    }

    public void addNewStudent(Student student){
        if(student != null){
            classes.studentArrayList.add(student);
            System.out.println("增加成功");
        }
    }

    public void addNewStudent(ArrayList<Student> arrayList,String name){
        boolean isHave = false;
        for(Student student: arrayList){
            if(student.name == name){
                isHave = true;
                addNewStudent(student);
            }
        }
        if(!isHave){
            System.out.println("没有该学生！");
        }
    }

    public void deleteStudent(Student student){
        if(student != null)
            if(classes.studentArrayList.contains(student))
                classes.studentArrayList.remove(student);
            else
                System.out.println("没有这个学生");
    }

    public void addNewLeader(Teacher leader){
        classes.leader = leader;
    }

    public void addNewLeader(ArrayList<Teacher> teachers, String name){
        boolean isHave = false;
        for(Teacher teacher: teachers){
            if(teacher.name == name){
                isHave = true;
                addNewLeader(teacher);
            }
        }
        if(!isHave){
            System.out.println("没有该老师！");
        }
    }

    public void addNewCourse(Course course){
        if(course != null)
            classes.courseArrayList.add(course);
            System.out.println("添加成功");
    }

    public void deleteCourse(Course course){
        if(course != null)
            if(classes.courseArrayList.contains(course))
                classes.courseArrayList.remove(course);
            else
                System.out.println("没有这门课程");
    }

    public void printAllStudents(){
        System.out.println(classes.studentArrayList);
    }

    public void printAllCourse(){
        System.out.println(classes.courseArrayList);
    }

    public void printClassInfo(){
        System.out.println("编号： " + classes.id + "      班名：" + classes.name);
        System.out.println("班主任：" + classes.leader);
        System.out.println("学生列表:");
        System.out.println(classes.studentArrayList);
        System.out.println("课程列表：");
        System.out.println(classes.courseArrayList);
    }



    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Teacher> teachers = new ArrayList<Teacher>();
        ArrayList<Classes> classes = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();
        ClassManage classManage = new ClassManage(classes);

        Teacher t1 = new Teacher(1,"zhangsan");
        Teacher t2 = new Teacher(2, "lisi");



        TeacherManage teacherManage = new TeacherManage(teachers);
        StudentManage studentManage = new StudentManage(students);
        CourseManage courseManage = new CourseManage(courses);
        // 增加课程
        courseManage.add(new Course(1,"《Java》"));
        courseManage.add(new Course(2,"《Python》"));
        // 怎加学生
        studentManage.add("zhangSan", 1000);
        studentManage.add("liSi",1001);
        studentManage.add("wangWu", 1002);

        // 创建班级
        Classes classes1 = new Classes(1,"17070144", new ArrayList<>(), new ArrayList());
        Classes classes2 = new Classes(2,"17070043", new ArrayList<>(), new ArrayList());
        classManage.add(classes1);
        classManage.add(classes2);

        // 1班班级操作
        ClassManage classManage1 = new ClassManage(classes1, classes);

        // 为1班添加课程
        classManage1.addNewCourse((Course) courseManage.find(1));
        classManage1.addNewCourse((Course) courseManage.find("《Python》"));
        classManage1.printAllCourse();
        // 为1班添加学生
        classManage1.addNewStudent((Student)studentManage.find(1));
        classManage1.addNewStudent((Student)studentManage.find("zhangSan"));
        classManage1.addNewStudent((Student)studentManage.find("wangWu"));
        classManage1.printAllStudents();
        classManage1.deleteStudent((Student)studentManage.find(0));
        classManage1.printAllStudents();
        classManage1.printClassInfo();
        classManage.printAll();

    }
}
