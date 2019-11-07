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
	
	public Circle() {}
	
	@Override
	public void draw() {
		gcMain.drawOval(top,left,width,height);
	}
	
	@Override
	public void setWidth(int i) {
		this.width = i;
	}



	@Override
	public void setHeight(int i) {
		this.height = i;	
	}



	@Override
	public void setGcMain(GC gcMain) {
		this.gcMain = gcMain;
	}



	@Override
	public int getWidth() {
		return this.width;
	}



	@Override
	public void setTop(int i) {
		this.top = i;
	}



	@Override
	public void setLeft(int i) {
		this.left = i;
	}



	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return this.height;
	}



	@Override
	public int getTop() {
		// TODO Auto-generated method stub
		return this.top;
	}



	@Override
	public int getLeft() {
		// TODO Auto-generated method stub
		return this.left;
	}


	public static String toName() {
		return "Circle";
	}

}
