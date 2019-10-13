package Note.jxgl;

import java.util.ArrayList;

public class Classes extends Things {

    ArrayList<Student> studentArrayList;
    ArrayList<Course> courseArrayList;
    Teacher leader;

    Classes(int id, String name, ArrayList studentArrayList, ArrayList courseArrayList) {
        super(id, name);
        this.courseArrayList = courseArrayList;
        this.studentArrayList = studentArrayList;
    }
}
