package Note.threadstudy.test03;

public class T4 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("llll" + i);
                }
            }
        }).start();

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("aaaa" + i);
                }
            }
        }.start();
    }
}
