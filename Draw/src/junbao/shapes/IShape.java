package junbao.shapes;

import org.eclipse.swt.graphics.GC;

public interface IShape {
	void draw();

	void setTop(int i);

	void setLeft(int i);

	void setWidth(int i);

	void setHeight(int i);

	void setGcMain(GC gcMain);

	int getWidth();
	
	int getHeight();
	
	int getTop();
	
	int getLeft();

}
