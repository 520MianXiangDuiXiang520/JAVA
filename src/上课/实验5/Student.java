package 上课.实验5;

public class Student implements StudentInterface {
    protected String name;
    protected int score;
    Student(String name,int s){
        this.name = name;
        this.score = s;
    }

    @Override
    public boolean XueFen() {
        return false;
    }


    public String toString(){
        if (this.XueFen()){
            return this.name + " 能毕业";
        }else
            return this.name + " 不能毕业";
    }
}
