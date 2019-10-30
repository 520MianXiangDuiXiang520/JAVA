package junbao;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;

import org.eclipse.swt.widgets.Label;


class Factorial {
	
	public static int [] Multiply(int [] first, int second){
        int [] result = new int [1000000];
        int num = first.length;
        int jin = 0;
        int r;
        int j = 0;
        for(int i=num-1;i>=0;i--){
            r = ((first[i] * second) + jin) % 10;
            jin = ((first[i] * second) + jin) / 10;
            result[j] = r;
            j++;
        }
        while(jin > 10){
            r = jin % 10;
            jin = jin /10;
            result[j] = r;
            j++;
        }
        result[j] = jin;
        int [] ret = new int[j+1];
        int k = 0;
        for(int i=j;i>=0;i--){
            ret[k++] = result[i];
        }
        return ret;
    }
	
	public static String factor(String input) {
		StringBuilder sb = new StringBuilder();
		boolean iscopy = false;
		String output = "";
		int [] first = {1};
        int second = Integer.parseInt(input);
        for(int i=1;i<=second;i++){
            first = Multiply(first, i);
        }
        for(int k: first){
            output += (k + "");
        }
        for(int i = 0;i<output.length();i++) {
        	if(output.toCharArray()[i] != '0')
        		iscopy = true;
        	if(iscopy) {
        		sb.append(output.toCharArray()[i]);
        	}
        }
		return sb.toString();
	}
}

public class Main2 {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Main2 window = new Main2();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("大数阶乘");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(13, 179, 281, 48);
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(312, 179, 98, 48);
		btnNewButton.setText("计算");
		
		text_1 = new Text(shell, SWT.WRAP|SWT.V_SCROLL);
		text_1.setBounds(13, 11, 412, 105);
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(13, 133, 397, 33);
		formToolkit.adapt(label, true, true);
		label.setText("\u957F\u5EA6\uFF1A");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				Factorial factorial = new Factorial();
				try {
					String p = factorial.factor(text.getText());
					text_1.setText(p);
					label.setText("长度： " + (p.length() + ""));
				} catch(Exception error) {
					text_1.setText("输入有误！");
				}
				
				
			}
		});
	}
}
