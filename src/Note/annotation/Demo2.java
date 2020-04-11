package Note.annotation;

@AnnDemo(name="liSi")
public class Demo2  {


    public static void main(String[] args) throws NoSuchMethodException {
        Class<Demo2> demo2Class = Demo2.class;
        AnnDemo annotation = demo2Class.getAnnotation(AnnDemo.class);
        String name = annotation.name();
        System.out.println(name);
    }
}
