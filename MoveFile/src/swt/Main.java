package swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import movefile.TextFile;

public class Main {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private static String courseFilePath = "E:\\DjangoTestvir\\Projec\\FamilyPropertyMS\\README.md";
	private static String copyPath = "test.txt";
	private int lines;
	public ProgressBar progressBar;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Main window = new Main();
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
		shell.setSize(773, 491);
		shell.setText("SWT Application");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(65, 37, 632, 58);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(65, 148, 632, 58);
		progressBar = new ProgressBar(shell, SWT.NONE);
		progressBar.setBounds(65, 411, 632, 21);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				lines = TextFile.getLines(courseFilePath);
				progressBar.setMaximum(lines);
				Main.courseFilePath = text.getText();
				Main.copyPath = text_1.getText();
				String file = TextFile.read(courseFilePath);
		        TextFile.write(copyPath, file);
			}
		});
		btnNewButton.setBounds(65, 297, 632, 47);
		btnNewButton.setText("New Button");
		
		

	}
}
