package junbao.shapes;

import org.eclipse.swt.graphics.GC;


public class Pentagon implements IShape {
    private int top;
    private int left;
    private int width;
    private int height;
    private GC gcMain;

    public Pentagon(int top, int left, int width, int height, GC gc) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
        this.gcMain = gc;




    }

    public Pentagon() {}

    @Override
    public void draw() {
        float x1,y1,x2,y2,x3,y3,x4,y4,x5,y5, w;
        w = (float)width/2;
        double sin72 = 0.9510565163;
        double cos72 = 0.3090169944;
        double cos54 = 0.5877852523;
        double sin54 = 0.8090169944;
        int x = top;
        int y = left;
        x1 = (float)w + x;
        y1 = (float)y;
        x2 = (float)(x + (w - (w * sin72 * sin72)));
        System.out.println("x2 = " + x2);
        y2 = (float)(y + (w - (w * sin72 * cos72)));
        x3 = (float)(x + w + (w * sin72 * sin72));
        y3 = y2;
        x4 = (float)(x + (w - (w * cos54)));
        y4 = (float)(y + w + w * sin54);
        x5 = (float)(x + w + (w * cos54));
        y5 = y4;
        gcMain.drawLine((int)x1,(int)y1,(int) x2,(int) y2);
        gcMain.drawLine((int)x1,(int)y1,(int) x3,(int) y3);
        gcMain.drawLine((int)x2,(int)y2,(int) x4,(int) y4);
        gcMain.drawLine((int)x4,(int)y4,(int) x5,(int) y5);
        gcMain.drawLine((int)x5,(int)y5,(int) x3,(int) y3);
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
        return "Pentagon";
    }
}
