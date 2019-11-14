package 上课.graphicsbyabs.graphics;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        GraphicsAbstract circle = new Circle("circle");
        GraphicsAbstract rect = new Rect("rect");
        Triangle triangle = new Triangle("triangle");
        board.addGraphics(rect);
        board.addGraphics(circle);
        board.addGraphics(triangle);
        board.refresh();
    }
}
