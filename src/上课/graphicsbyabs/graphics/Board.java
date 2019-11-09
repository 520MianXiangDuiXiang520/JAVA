package 上课.graphics;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public List<GraphicsInface> graphics;

    public Board(){
        graphics = new ArrayList<>();
    }

    public void addGraphics(GraphicsInface graphic){
        graphics.add(graphic);
    }

    public void refresh(){
        for(GraphicsInface graphics: graphics) {
            graphics.draw();
        }
    }
}
