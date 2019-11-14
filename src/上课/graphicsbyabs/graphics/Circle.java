package 上课.graphicsbyabs.graphics;

public class Circle extends Graphics {

    Circle(String text) {
        super(text);
    }

    @Override
    public void draw(){
        System.out.println("Circle: " +  this.name);
    }
}
