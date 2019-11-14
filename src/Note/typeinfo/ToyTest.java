package Note.typeinfo;
import static junbao.tool.Print.*;

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

class Toy {
    Toy() {}
    Toy(int i) {}
}

class FancyToy extends Toy
        implements HasBatteries, Shoots, Waterproof{
    FancyToy(int i) {
        super(i);
    }
}

public class ToyTest {
    static void printInfo(Class cc) {
        coutln("Class name:" + cc.getName() + " is interface?  [" + cc.isInterface() + "]");
        coutln("Simple name: " + cc.getSimpleName());
        coutln("Canonical name: " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class cc = null;
        try {
            cc = Class.forName("Note.typeinfo.FancyToy");
        } catch (ClassNotFoundException e) {
            coutln("class not found");
            System.exit(1);
        }
        printInfo(cc);
        coutln();
        for(Class face : cc.getInterfaces()) {
            printInfo(face);
        }

        Class up = cc.getSuperclass();
        Object obj = null;
        try {
            obj = up.newInstance();
        } catch(IllegalAccessException e) {
            coutln("can't access");
            System.exit(1);
        } catch (InstantiationException e) {
            coutln("can't instance");
            System.exit(1);
        }
        printInfo(obj.getClass());

    }
}
