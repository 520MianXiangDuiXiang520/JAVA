package Note.iosystem.serialization;

import java.io.*;

public class ObjectOSDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String outputPath = "./src/Note/iosystem/objectOutput";
        Person person = new Person("zhangSan", 17);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputPath));
        oos.writeObject(person);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(outputPath));
        Person p = (Person) ois.readObject();
        System.out.println(p);
    }
}
