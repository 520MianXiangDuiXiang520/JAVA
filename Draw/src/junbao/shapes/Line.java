package junbao.shapes;

import org.eclipse.swt.graphics.GC;

public class Line implements IShape {
	private GC gcMain;
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	
	public Line(int x1,int y1,int x2,int y2,GC gc) {
		this.x1 = x1;
	}
	
	@Override
	public void draw() {
		gcMain.drawLine(x1, y1, x2, y2);
	}

}
