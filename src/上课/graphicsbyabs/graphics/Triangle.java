package 上课.graphicsbyabs.graphics;

public class Triangle extends Graphics {
    Triangle(String text) {
        super(text);
    }

    @Override
    public void draw(){
        System.out.println("Triangle: " +  this.name);
    }
}
