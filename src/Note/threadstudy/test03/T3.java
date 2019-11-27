package Note.threadstudy.test03;

public class T3 {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run(){
                for (int i = 0; i < 20; i++) {
                    System.out.println("llll" + i);
                }
            }
        }.start();
        for (int i = 0; i < 20; i++) {
            System.out.println("aaaaa" + i);
        }
    }
}
