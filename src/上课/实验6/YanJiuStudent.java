package 上课.实验6;

public class YanJiuStudent extends Student {
    YanJiuStudent(String name, int s) {
        super(name, s);
    }

    @Override
    public boolean XueFen() {
        return this.score > 15;
    }
}
