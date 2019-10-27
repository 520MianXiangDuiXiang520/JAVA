package 上课.jxgl;

public class Things{
    protected String name;
    protected int id;
    Things(int id, String name){
        this.id = id;
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
