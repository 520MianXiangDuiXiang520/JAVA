package Note.threadstudy.test04;

public class T5 {
    private static int ticket = 100;
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run(){
                while(true){
                    synchronized (T5.class){
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
        }.start();

        while(true){
            synchronized (T5.class){
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
}
