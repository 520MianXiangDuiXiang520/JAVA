package 上课.graphicsbyabs.graphics;

        import java.util.ArrayList;
        import java.util.List;

public class Board {
    public List<GraphicsAbstract> graphics;

    public Board(){
        graphics = new ArrayList<>();
    }

    public void addGraphics(GraphicsAbstract graphic){
        graphics.add(graphic);
    }

    public void refresh(){
        for(GraphicsAbstract graphics: graphics) {
            graphics.draw();
        }
    }
}
