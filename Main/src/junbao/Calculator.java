package junbao;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class Calculator {
//	private static String expression = "";
	private StringBuilder expression = new StringBuilder();

	protected Shell shlCalculator;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Calculator window = new Calculator();
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
		shlCalculator.open();
		shlCalculator.layout();
		while (!shlCalculator.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlCalculator = new Shell();
		shlCalculator.setSize(450, 558);
		shlCalculator.setText("Calculator");
		
		text = new Text(shlCalculator, SWT.BORDER);
		text.setBounds(10, 22, 422, 76);
		
		Button btnNewButton = new Button(shlCalculator, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				expression.append("+");
				text.setText(expression.toString());
			}
		});
		btnNewButton.setBounds(369, 135, 63, 30);
		btnNewButton.setText("+");
		
		Button button = new Button(shlCalculator, SWT.NONE);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				expression.append("-");
				text.setText(expression.toString());
			}
			
		});
		button.setBounds(369, 191, 63, 30);
		button.setText("-");
		
		Button button_1 = new Button(shlCalculator, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				expression.append("*");
				text.setText(expression.toString());
			}
		});
		button_1.setBounds(369, 250, 63, 30);
		button_1.setText("*");
		
		Button button_2 = new Button(shlCalculator, SWT.NONE);
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				expression.append("/");
				text.setText(expression.toString());
			}
		});
		
		button_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		button_2.setBounds(369, 309, 63, 30);
		button_2.setText("/");
		
		Button button_3 = new Button(shlCalculator, SWT.NONE);
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				expression.append("%");
				text.setText(expression.toString());
			}
		});
		button_3.setBounds(369, 371, 63, 30);
		button_3.setText("%");
		
		Button btnNewButton_1 = new Button(shlCalculator, SWT.NONE);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				expression.append("^");
				text.setText(expression.toString());
			}
		});
		btnNewButton_1.setBounds(369, 433, 63, 30);
		btnNewButton_1.setText("^");
		
		Button btnNewButton_2 = new Button(shlCalculator, SWT.NONE);
		btnNewButton_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				expression.append("7");
				text.setText(expression.toString());
			}
		});
		btnNewButton_2.setBounds(10, 191, 98, 51);
		btnNewButton_2.setText("7");
		
		Button btnNewButton_3 = new Button(shlCalculator, SWT.NONE);
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				expression.append("8");
				text.setText(expression.toString());
			}
		});
		btnNewButton_3.setBounds(128, 191, 98, 51);
		btnNewButton_3.setText("8");
		
		Button btnNewButton_4 = new Button(shlCalculator, SWT.NONE);
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				expression.append("9");
				text.setText(expression.toString());
			}
		});
		btnNewButton_4.setBounds(244, 191, 98, 51);
		btnNewButton_4.setText("9");
		
		Button btnNewButton_5 = new Button(shlCalculator, SWT.NONE);
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				expression.append("4");
				text.setText(expression.toString());
			}
		});
		btnNewButton_5.setBounds(10, 271, 98, 51);
		btnNewButton_5.setText("4");
		
		Button button_4 = new Button(shlCalculator, SWT.NONE);
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				expression.append("1");
				text.setText(expression.toString());
			}
		});
		button_4.setText("1");
		button_4.setBounds(10, 350, 98, 51);
		
		Button button_5 = new Button(shlCalculator, SWT.NONE);
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				expression.append(".");
				text.setText(expression.toString());
			}
		});
		button_5.setText(".");
		button_5.setBounds(10, 423, 98, 51);
		
		Button button_6 = new Button(shlCalculator, SWT.NONE);
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				expression.append("5");
				text.setText(expression.toString());
			}
		});
		button_6.setText("5");
		button_6.setBounds(128, 271, 98, 51);
		
		Button button_7 = new Button(shlCalculator, SWT.NONE);
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				expression.append("6");
				text.setText(expression.toString());
			}
		});
		button_7.setText("6");
		button_7.setBounds(244, 271, 98, 51);
		
		Button button_8 = new Button(shlCalculator, SWT.NONE);
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				expression.append("2");
				text.setText(expression.toString());
			}
		});
		button_8.setText("2");
		button_8.setBounds(128, 350, 98, 51);
		
		Button button_9 = new Button(shlCalculator, SWT.NONE);
		button_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				expression.append("3");
				text.setText(expression.toString());
			}
		});
		button_9.setText("3");
		button_9.setBounds(244, 350, 98, 51);
		
		Button button_10 = new Button(shlCalculator, SWT.NONE);
		button_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				expression.append("0");
				text.setText(expression.toString());
			}
		});
		button_10.setText("0");
		button_10.setBounds(128, 423, 98, 51);
		
		Button button_11 = new Button(shlCalculator, SWT.NONE);
		button_11.setText("=");
		button_11.setBounds(244, 423, 98, 51);
		
		Button button_12 = new Button(shlCalculator, SWT.NONE);
		button_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				expression.append("(");
				text.setText(expression.toString());
			}
		});
		button_12.setText("(");
		button_12.setBounds(10, 125, 98, 51);
		
		Button button_13 = new Button(shlCalculator, SWT.NONE);
		button_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				expression.append(")");
				text.setText(expression.toString());
			}
		});
		button_13.setText(")");
		button_13.setBounds(128, 125, 98, 51);
		
		Button button_14 = new Button(shlCalculator, SWT.NONE);
		button_14.setText("<--");
		button_14.setBounds(244, 125, 98, 51);

	}
}
