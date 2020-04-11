package Note.threadstudy.test04;


public class T4 {
    private static int ticket = 100;
    static class M1 implements Runnable{
        @Override
        public void run() {
            while(true){
                if(ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("M1 =====> " + ticket);
                    ticket --;
                }else
                    break;
            }

        }
    }

    public static void main(String[] args) {
        M1 m1 = new M1();
        Thread thread = new Thread(m1);
        thread.start();
        while(true){
            if(ticket > 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Main =====> " + ticket);
                ticket --;
            }else
                break;
        }
    }

}
