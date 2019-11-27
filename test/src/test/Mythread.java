package test;

import org.eclipse.swt.widgets.Display;


 
   
   
 class Mythread extends Thread{   
    int sd=0;   
    private int i=0;   
    public threadtest thisme;   
    int sleeptime=0;   
    boolean taskrun=true;   
    public boolean sleeptrue=false;   
   
   
   
    public Mythread(threadtest thisme) {   
        this.thisme=thisme;   
    }   
    public void run() {   
        while (true) {   
            if(i>100|i==0){   
                i=0;   
                sd1();   
            }   
            i++;   
            if(sleeptrue){   
                try {   
                    Thread.sleep(sleeptime);   
                    sleeptrue=false;   
                } catch (InterruptedException e) {    
                    e.printStackTrace();   
                }   
                   
            }   
            sds();   
            try {   
                Thread.sleep(100-sd);   
            } catch (InterruptedException e) {   
                e.printStackTrace();   
            }   
        }          
       
           
    }   
//    private void sd1() {   
//        Display.getDefault().syncExec(new Runnable() {   
//            public void run() {   
//                thisme.sd();   
//            }   
//        });   
//    }   
    private void sds() {   
        Display.getDefault().syncExec(new Runnable() {   
            public void run() {   
                thisme.sd(i);   
            }   
        });   
    }   
   
}
