package Note.iosystem.serialization;

import java.io.Serializable;

public class Person implements Serializable {
    private final static long serialVersionUID = 1L;
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person(String n, int a) {
        this.age = a;
        this.name = n;
    }
}
