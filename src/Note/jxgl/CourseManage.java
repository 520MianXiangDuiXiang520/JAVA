package Note.jxgl;

import java.util.ArrayList;

public class CourseManage extends Manage {

    CourseManage(ArrayList al) {
        super(al);
    }

    public static void main(String[] args) {
        ArrayList<Course> courseArrayList = new ArrayList<>();
        CourseManage courseManage = new CourseManage(courseArrayList);

        courseManage.add(new Course(1,"《Java》"));
        courseManage.add(new Course(2,"《Python》"));
        courseManage.printAll();
        courseManage.alert(2,"《C#》");
        courseManage.printAll();
        courseManage.delete(1);
        courseManage.printAll();
    }
}
