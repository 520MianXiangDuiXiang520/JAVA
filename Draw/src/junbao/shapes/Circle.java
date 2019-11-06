package junbao.shapes;

import org.eclipse.swt.graphics.GC;

public class Circle implements IShape {
	private int top;
	private int left;
	private int width;
	private int height;
	private GC gcMain;
	
	public Circle(int top, int left, int width, int height, GC gc) {
		this.top = top;
		this.left = left;
		this.width = width;
		this.height = height;
		this.gcMain = gc;
	}
	
	@Override
	public void draw() {
		gcMain.drawOval(top,left,width,height);
	}

}
