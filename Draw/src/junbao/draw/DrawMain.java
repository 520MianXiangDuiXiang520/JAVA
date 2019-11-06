package junbao.draw;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import junbao.shapes.Circle;
import junbao.shapes.IShape;
import junbao.shapes.Rect;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class DrawMain {

	protected Shell shell;
	// Í¼ÐÎÉÏÏÂÎÄ
	private static GC gcMain = null;
	private Board board = null;
	private int startX, startY;
	private static boolean leftButtonDown = false;
	private static int lastWidth = 0;
	private static int lastHeight = 0;
	private static int shapeType = 1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DrawMain window = new DrawMain();
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
		shell.addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(MouseEvent arg0) {
				if(leftButtonDown) {
					gcMain.setLineStyle(SWT.LINE_DOT);
					// ²Á³ý
					gcMain.setForeground(shell.getBackground());
					gcMain.drawRectangle(startX, startY, lastWidth,lastHeight);
					// »­ÐéÏß
					Color blue = new Color(null, 0, 0, 255, 0);
					gcMain.setForeground(blue);
					lastWidth = arg0.x-startX;
					lastHeight = arg0.y-startY;
					gcMain.drawRectangle(startX, startY, lastWidth, lastHeight);
					gcMain.setLineStyle(SWT.LINE_SOLID);
				}
			}
		});
		board = new Board();
		// ÖØ»æ
		shell.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent arg0) {
				board.refrech();
			}
		});
		gcMain = new GC(shell);
		shell.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.setCursor(new Cursor(null,SWT.CURSOR_CROSS));
				startX = e.x;
				startY = e.y;
				leftButtonDown = true;
			}
			
			@Override
			public void mouseUp(MouseEvent e) {
				// ÅÐ¶Ï×ó»÷
				if(e.button == 1) {
					shell.setCursor(new Cursor(null,SWT.CURSOR_ARROW));
					leftButtonDown = false;
					gcMain.setLineStyle(SWT.LINE_DOT);
					gcMain.setForeground(shell.getBackground());
					gcMain.drawRectangle(startX, startY, lastWidth, lastHeight);
					gcMain.setLineStyle(SWT.LINE_SOLID);
					Color black = new Color(null, 0, 0, 0, 0);
					gcMain.setForeground(black);
					IShape shape;
					switch (shapeType) {
					case 1:
						shape = new Rect(startX, startY, lastWidth, lastHeight, gcMain);
						break;
					case 2:
						shape = new Circle(startX, startY, lastWidth, lastHeight, gcMain);
						break;
					default:
						shape = new Rect(startX, startY, lastWidth, lastHeight, gcMain);
						break;
					}
					board.insertShape(shape);
					board.refrech();
				}
			}
		});
		shell.setSize(600, 450);
		shell.setText("SWT Application");
		
		Button btnRect = new Button(shell, SWT.NONE);
		btnRect.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shapeType = 1;
			}
		});
		btnRect.setBounds(0, 25, 98, 30);
		btnRect.setText("Rect");
		
		Button btnCircle = new Button(shell, SWT.NONE);
		btnCircle.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shapeType = 2;
			}
		});
		btnCircle.setBounds(124, 25, 98, 30);
		btnCircle.setText("Circle");

	}
}
