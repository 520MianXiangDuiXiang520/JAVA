package Note.jxgl;

import java.util.ArrayList;

public class GStudentMange extends StudentManage {
    private static int paperCount = 0;
    private static int graduateStudentCount = 0;

    GStudentMange(ArrayList al) {
        super(al);
    }

    public void add(String name, int graduation){
        /**
         * 增加一个学生，覆盖基类方法，实现学号递增
         */
        super.add(new GraduateStudent(graduateStudentCount ++,name, graduation));
    }

    public void addPaper(GraduateStudent gs,String title){
        gs.papers[paperCount ++ ] = title;
    }

    public void addPaper(int id, String title){
        GraduateStudent graduateStudent = (GraduateStudent)find(id);
        if(graduateStudent != null){
            addPaper(graduateStudent, title);
        }
    }

    public void addPaper(String name, String title){
        GraduateStudent graduateStudent = (GraduateStudent) find(name);
        if(graduateStudent != null){
            addPaper(graduateStudent, title);
        }
    }

    public void getInfo(GraduateStudent graduateStudent){
        super.getInfo(graduateStudent);
        if(graduateStudent != null){
            for(String s: graduateStudent.papers){
                if(s != null)
                    System.out.print(s + "   ");
            }
            System.out.println();
        }
    }

    public void getInfo(int id){
        GraduateStudent findStudent = (GraduateStudent) find(id);
        if(findStudent != null)
            getInfo(findStudent);
    }

    public void getInfo(String name){
        GraduateStudent findStudent = (GraduateStudent) find(name);
        if(findStudent != null)
            getInfo(findStudent);
    }

    public static void main(String[] args) {
        ArrayList<GraduateStudent> graduateStudents = new ArrayList<>();
        GStudentMange gsm = new GStudentMange(graduateStudents);
        gsm.add("y1",1000);
        gsm.getInfo("y1");
        gsm.addPaper("y1","《Java为什么这么难》");
        gsm.getInfo("y1");
    }
}
