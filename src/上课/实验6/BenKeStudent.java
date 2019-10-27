package 上课.实验6;

public class BenKeStudent extends Student {
    BenKeStudent(String n,int s){
        super(n,s);
    }
    @Override
    public boolean XueFen() {
        return this.score > 26;
    }
}
