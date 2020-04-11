package Note.iosystem;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertyDemo {
    public static void main(String[] args) throws IOException {
        String filePath = "./src/Note/iosystem/properties.properties";
        Properties properties = new Properties();
        properties.setProperty("name", "zhangsan");
        properties.setProperty("age", "19");
        properties.store(new FileOutputStream(filePath), "");
        properties.load(new FileReader(filePath));
        Set<String> result = properties.stringPropertyNames();
        for (String res: result
             ) {
            System.out.println(properties.getProperty(res));
        }
    }
}
