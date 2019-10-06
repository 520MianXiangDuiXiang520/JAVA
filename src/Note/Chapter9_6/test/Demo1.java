package Note.Chapter9_6.test;

// 适配器
class Demo1AdaptAddaptation implements MyInterfice {
    private Demo1 demo;

    Demo1AdaptAddaptation(Demo1 d1) {
        this.demo = d1;
    }

    @Override
    public String name() {
        return demo.names();
    }
}

public class Demo1 {
    String names(){
        return "Demo1";
    }

    public static void main(String[] args) {
        Adaptation ada = new Adaptation();
        ada.accept(new Demo1AdaptAddaptation(new Demo1()));
    }

}
