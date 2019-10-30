package junbao.draw;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import junbao.shapes.IShape;
import junbao.shapes.Rect;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.MouseMoveListener;

public class DrawMain {

	protected Shell shell;
	// Í¼ÐÎÉÏÏÂÎÄ
	private static GC gcMain = null;
	private Board board = null;
	private int startX, startY;
	private static boolean leftButtonDown = false;
	private static int lastWidth = 0;
	private static int lastHeight = 0;

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
				startX = e.x;
				startY = e.y;
				leftButtonDown = true;
			}
			
			@Override
			public void mouseUp(MouseEvent e) {
				// ÅÐ¶Ï×ó»÷
				if(e.button == 1) {
					leftButtonDown = false;
					IShape rect = new Rect(startX,startY,e.x-startX,e.y-startY,gcMain);
					rect.draw();
					board.insertShape(rect);
				}
			}
		});
		shell.setSize(600, 450);
		shell.setText("SWT Application");

	}

}
