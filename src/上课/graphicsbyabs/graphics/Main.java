package 上课.graphics;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        GraphicsInface circle = new Circle("circle");
        GraphicsInface rect = new Rect("rect");
        Triangle triangle = new Triangle("triangle");
        board.addGraphics(rect);
        board.addGraphics(circle);
        board.addGraphics(triangle);
        board.refresh();
    }
}
