package Note.jxgl;

public class Student extends Person {
    public int graduation;
    Student(int id, String name, int graduation){
        super(id, name);
        this.graduation = graduation;
    }
}
