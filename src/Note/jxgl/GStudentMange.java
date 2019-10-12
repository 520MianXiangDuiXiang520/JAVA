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

    protected void printInfo(GraduateStudent gs, String by){
        System.out.println(gs.id + "   " + gs.name + "   " + by + gs.papers.toString());
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
