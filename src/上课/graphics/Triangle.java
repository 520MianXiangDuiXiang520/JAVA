package 上课.graphics;

public class Triangle extends Graphics {
    Triangle(String text) {
        super(text);
    }

    @Override
    public void draw(){
        System.out.println("Triangle: " +  this.name);
    }
}
