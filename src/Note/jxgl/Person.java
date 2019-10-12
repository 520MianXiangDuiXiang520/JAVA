package Note.jxgl;

import java.util.ArrayList;

public class Person {
    protected String name;
    protected int id;
    Person(int id, String name){
        this.id = id;
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
