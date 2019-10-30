package junbao.draw;

import java.util.ArrayList;
import java.util.List;

import junbao.shapes.IShape;

public class Board {
	private List<IShape> shapes;
	public Board() {
		shapes = new ArrayList<IShape>();
	}
	
	public void insertShape(IShape shape) {
		/**
		 * 添加一个图形
		 */
		shapes.add(shape);
	}
	
	public void refrech() {
		/**
		 * 刷新
		 */
		for(IShape shape:shapes) {
			shape.draw();
		}
	}

}
