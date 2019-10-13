package Note.jxgl;

import java.util.ArrayList;

public class Course extends Things{

    Course(int id, String name) {
        super(id, name);
    }

    public String toString(){
        return this.name;
    }
}
