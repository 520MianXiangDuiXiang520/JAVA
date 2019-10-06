package Note.Chapter9_9;
import static junbao.tool.Print.*;

interface Cycle {
    String name();
    int wheel_num();
}

interface CycleFactor{
    Cycle getCycle();
}

class Unicycle implements Cycle{
    @Override
    public String name() {
        return "独轮车";
    }

    @Override
    public int wheel_num() {
        return 1;
    }
}

class UnicycleFactor implements CycleFactor{
    @Override
    public Cycle getCycle() {
        return new Unicycle();
    }
}

class Bicycle implements Cycle{
    @Override
    public String name() {
        return "自行车";
    }

    @Override
    public int wheel_num() {
        return 2;
    }
}

class BicycleFactor implements CycleFactor{
    @Override
    public Cycle getCycle() {
        return new Bicycle();
    }
}

class Tricycle implements Cycle{
    @Override
    public String name() {
        return "三轮车";
    }

    @Override
    public int wheel_num() {
        return 3;
    }
}

class TricycleFactor implements CycleFactor{
    @Override
    public Cycle getCycle() {
        return new Tricycle();
    }
}

public class Cycles{
    public static void theCycle(CycleFactor cycleFactor){
        // 这里如果是特别复杂的代码，需要有多个Cycle的实例
        Cycle cycle = cycleFactor.getCycle();
        coutln(cycle.name() + "有" + cycle.wheel_num() + "个轮子");
    }
    public static void withoutFactor(Cycle cycle){
        coutln(cycle.name() + "有" + cycle.wheel_num() + "个轮子");
    }

    public static void main(String[] args) {
        theCycle(new UnicycleFactor());
        theCycle(new BicycleFactor());
        theCycle(new TricycleFactor());
        // 单例模式，之所以不直接传递接口的实现的对象，应为这样在theCycle中就只有一个对象了，
        // 有时候需要实例化很多次，所以传递工厂对象是最佳的选择
        withoutFactor(new Tricycle());
    }
}