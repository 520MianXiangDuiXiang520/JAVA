package test;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import java.util.Random;   

import org.eclipse.swt.SWT;   
import org.eclipse.swt.events.SelectionAdapter;   
import org.eclipse.swt.events.SelectionEvent;   
import org.eclipse.swt.layout.GridData;   
import org.eclipse.swt.layout.GridLayout;   
import org.eclipse.swt.widgets.Button;   
import org.eclipse.swt.widgets.Display;   
import org.eclipse.swt.widgets.Group;   
import org.eclipse.swt.widgets.Label;   
import org.eclipse.swt.widgets.ProgressBar;   
import org.eclipse.swt.widgets.Scale;   
import org.eclipse.swt.widgets.Shell;   
import org.eclipse.swt.widgets.Spinner;   
   
   
public class threadtest{   
    public threadtest thisme=this ;   
    private Spinner spinner_1;   
    private Scale scale;   
    ProgressBar progressBar;   
    private Button button;    
    private Button button_2;   
    Button button_3;   
    private Button button_5;   
    private Button button_6;   

    private Group group;   
    Spinner spinner;   
    private Mythread mythread;   
    protected Shell shell;   
    /**  
     * Launch the application  
     * @param args  
     */   
    public static void main(String[] args) {   
        try {   
            threadtest window = new threadtest();   
            window.open();   
        } catch (Exception e) {   
            e.printStackTrace();   
        }   
    }   
   
    /**  
     * Open the window  
     */   
    public void open() {   
        final Display display = Display.getDefault();   
        createContents();   
        shell.open();   
        shell.layout();   
        while (!shell.isDisposed()) {   
            if (!display.readAndDispatch())   
                display.sleep();   
        }   
    }   
   
    /**  
     * Create contents of the window  
     */   
    protected void createContents() {   
        shell = new Shell();   
        shell.setLayout(new GridLayout());   
        shell.setSize(500, 375);   
        shell.setText("SWT Application");     
        oo(shell);   
    }   
   
    void oo(Shell shell2) {   
        // TODO 自动生成方法存根   
        group = new Group(shell2, SWT.NONE);   
        group.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));   
        final GridLayout gridLayout = new GridLayout();   
        gridLayout.numColumns = 8;   
        group.setLayout(gridLayout);   
        group.setText("线程一");   
        button = new Button(group, SWT.NONE);   
        button.addSelectionListener(new SelectionAdapter() {   
            public void widgetSelected(SelectionEvent arg0) {   
//              System.out.println(spinner_1);   
                mythread = new Mythread(thisme);   
                mythread.start();   
                button.setEnabled(!button.getEnabled());   
                button_2.setEnabled(!button_2.getEnabled());   
            }   
        });   
        button.setText("启动");   
   
        button_2 = new Button(group, SWT.NONE);   
        button_2.setEnabled(false);   
        button_2.setText("停止");   
        button_2.addSelectionListener(new SelectionAdapter() {   
            @SuppressWarnings("deprecation")   
            public void widgetSelected(SelectionEvent arg0) {   
                mythread.stop();   
                button.setEnabled(!button.getEnabled());   
                button_2.setEnabled(!button_2.getEnabled());   
            }   
        });   
   
  
   
   
   
        button_5 = new Button(group, SWT.NONE);   
        button_5.addSelectionListener(new SelectionAdapter() {   
            public void widgetSelected(SelectionEvent arg0) {   
                mythread.suspend();   
            }   
        });   
        button_5.setText("挂起");   
   
        button_6 = new Button(group, SWT.NONE);   
        button_6.addSelectionListener(new SelectionAdapter() {   
            public void widgetSelected(SelectionEvent arg0) {   
                mythread.resume();   
            }   
        });   
        button_6.setText("恢复");   
   
        spinner = new Spinner(group, SWT.BORDER);   
   
        button_3 = new Button(group, SWT.TOGGLE);     
        progressBar = new ProgressBar(group, SWT.NONE);   
        progressBar.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 8, 1));    
   
        scale = new Scale(group, SWT.NONE);   
        scale.setRedraw(true);   
        scale.setPageIncrement(1000);   
        scale.setIncrement(1000);   
        scale.addSelectionListener(new SelectionAdapter() {   
            public void widgetSelected(SelectionEvent arg0) {   
                spinner_1.setSelection(scale.getSelection());   
            }   
        });   
        scale.setMaximum(10000);   
        scale.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 5, 1));   
   
    }   
   
    public void sd(int ss) {   
        mythread.sd=20;   
        progressBar.setSelection(ss++);   
    }   
   
//    public void sd() {   
//        if(button_3.getSelection()){   
//            spinner.setSelection((int) (new Random().nextDouble()*100));   
//        }   
//    }   
   
}