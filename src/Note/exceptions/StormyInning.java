package Note.exceptions;
import static junbao.tool.Print.*;

class BaseballException extends Exception {}
class Foul extends BaseballException {}
class Strike extends BaseballException {}

abstract class Inning {
    public Inning() throws BaseballException {}
    public void event() throws BaseballException {}
    public abstract void atBat() throws Strike, Foul;
    public void walk() {}
}

class StormException extends Exception {}
class RaineOut extends StormException {}
class PopFoul extends Foul {}

interface Storm {
    public void event() throws RaineOut;
    public void rainHard() throws RaineOut;
}

public class StormyInning extends Inning implements Storm {
    public StormyInning() throws BaseballException, RaineOut {}

    public StormyInning(String s) throws Foul, BaseballException {}

    @Override
    public void event(){

    }

    @Override
    public void atBat() throws PopFoul {

    }

    @Override
    public void rainHard() throws RaineOut {

    }

    // public void walk() throws RaineOut{}
}
