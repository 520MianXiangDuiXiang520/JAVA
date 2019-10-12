package Note.Chapter10_4;

class Egg {
    private Yolk yolk;
    class Yolk {
        public Yolk(){
            System.out.println("Egg.Yolk()");
        }
    }

    public Egg(){
        System.out.println("new Egg");
    yolk = new Yolk();
}
}

public class BigEgg extends Egg{
    public class Yolk {
        public Yolk(){
            System.out.println("BigEgg.Yolk()");
        }
    }

    public static void main(String[] args) {
        new BigEgg();
    }
}
