package Note.threadstudy.test04;

public class T6 {
    private static int ticket = 100;
    public static synchronized void shell(){
        if(ticket > 0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " =====> " + ticket);
            ticket --;
        }
    }

    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run(){
                while(true){
                    shell();
                }


            }
        }.start();
        while(true){
            shell();
        }
    }
}
