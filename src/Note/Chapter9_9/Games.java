package Note.Chapter9_9;
import static junbao.tool.Print.*;

interface Game{
    boolean move();
}

interface GameFactory{
    Game getGame();
}

class Checkers implements Game{
    private int moves = 0;
    private static final int MOVES = 3;

    @Override
    public boolean move() {
        coutln("checkers moves " + moves);
        return ++moves != MOVES;
    }
}

class CheckersFactory implements GameFactory{
    @Override
    public Game getGame() {
        return new Checkers();
    }
}

class Chess implements Game{
    private int moves = 0;
    private static final int MOVES = 4;

    @Override
    public boolean move() {
        coutln("chess moves " + moves);
        return ++moves != MOVES;
    }
}

class ChesssFactory implements GameFactory{
    @Override
    public Game getGame() {
        return new Chess();
    }
}

public class Games {
    // 策略模式
    public static void playGame(GameFactory gf){
        Game s = gf.getGame();
        while(s.move())
            ;
    }

    public static void main(String[] args) {
        playGame(new CheckersFactory());
        playGame(new ChesssFactory());
    }
}
