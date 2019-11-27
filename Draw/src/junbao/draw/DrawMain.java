package junbao.draw;

import junbao.shapes.Rect;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import junbao.shapes.ClassUtil;
import junbao.shapes.IShape;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

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
	// 图形上下文
	private static GC gcMain = null;
	private Board board = null;
	private int startX, startY;
	private static boolean leftButtonDown = false;
	private static int lastWidth = 0;
	private static int lastHeight = 0;
//	private static int shapeType = 1;
	private static String shapeType = "Rect";
	public static ArrayList<String> shapeTypes;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			
			List listClass = null;
			String pkg = "junbao.shapes";
			listClass = ClassUtil.getClassList(pkg, true, null);

			shapeTypes = new ArrayList<String>();
			for (Object object : listClass) {
				String name = ((Class<?>)object).getName();
				if(!name.equals("junbao.shapes.IShape")){
					shapeTypes.add(name);
				}
			}
			
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
					// 擦除
					gcMain.setForeground(shell.getBackground());
					gcMain.drawRectangle(startX, startY, lastWidth,lastHeight);
					// 画虚线
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
		// 重绘
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
				// 判断左击
				if(e.button == 1) {
					// 设置光标类型为十字
					shell.setCursor(new Cursor(null,SWT.CURSOR_ARROW));
					leftButtonDown = false;

					gcMain.setLineStyle(SWT.LINE_DOT);
					gcMain.setForeground(shell.getBackground());
					gcMain.drawRectangle(startX, startY, lastWidth, lastHeight);
					gcMain.setLineStyle(SWT.LINE_SOLID);
					Color black = new Color(null, 0, 0, 0, 0);
					gcMain.setForeground(black);
					IShape shape;
					try{
						System.out.println(shapeType);
						Class<IShape> shapeClass = (Class<IShape>) Class.forName(shapeType);
						IShape oShape = shapeClass.newInstance();
						shape = (IShape)oShape;
						shape.setTop(startX);
						shape.setLeft(startY);
						shape.setWidth(e.x - startX);
						shape.setHeight(e.y - startY);
						shape.setGcMain(gcMain);
						}
						catch (Exception ex) {
						ex.printStackTrace();
						shape = null;
					}
					if(shape != null) {

					board.insertShape(shape);
					board.refrech();
					}
				}
			}
		});
		shell.setSize(600, 450);
		shell.setText("SWT Application");
		
		int indexButton = 0;
		for (String strClass : shapeTypes) {
		Button btn = new Button(shell, SWT.NONE);
		btn.addSelectionListener(new SelectionAdapter() {
		@Override
		public void widgetSelected(SelectionEvent e) {
		shapeType = strClass;
		}
		});
		btn.setBounds(84 * indexButton, 0, 80, 27);
		indexButton++;
		try {
			Class<?> shapeClass = Class.forName(strClass);
			Method method = shapeClass.getMethod("toName");
			btn.setText(method.invoke(null, null).toString());
			btn.setData("shapeType", strClass);
		} catch (Exception e) {
			btn.setText(strClass);
			btn.setData("shapeType", strClass);
		}
		}


	}
}
