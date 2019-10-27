package 上课.graphics;

public class Rect extends Graphics {
    Rect(String text){
        super(text);
    }

    @Override
    public void draw(){
        System.out.println("Rect: " +  this.name);
    }
}
