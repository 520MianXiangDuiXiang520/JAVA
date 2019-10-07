package Note.Chapter10_1;
import static junbao.tool.Print.*;

public class Outer {
    private String outer_name;
    private int i = 0;
    private Inner inner = getInner("get");
    Outer(String name){
        this.outer_name = name;
    }

    class Inner {
        Inner(String name){
            coutln("Outer name :" + outer_name);
            coutln("init Inner" + name);
        }
        public void useI(){
            i ++;
        }

        Outer getOuter(){
            Outer o = Outer.this;
            Outer o2 = Outer.this;
            o.i ++;
            o2.i ++;
            coutln(o.i);
            coutln(o2.i);
            return Outer.this;
        }

    }

    private void printOuter(){
        coutln("printOuter");
    }

    public void innerUseOuter(){
//        Inner inner = new Inner("innerUserOuter");
//        inner.printOuter();
    }

    public Inner getInner(String s){
        return new Inner(s);
    }

    public static void main(String[] args) {
        Outer out = new Outer("outer");
        out.i += 5;
        Outer.Inner inner = out.getInner("Inner");
        Outer.Inner inner2 = out.new Inner("new inner");
        inner2.getOuter();
    }
}
