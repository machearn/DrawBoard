package Painter;

import Shapes.MyRectangle;
import Shapes.MyShape;
import util.Dragger;

import java.awt.event.MouseEvent;

/**
 * Created by Specific on 16/5/27.
 **/
public class MyRectanglePainter extends MyPainter {
    private MyRectangle drawingShape;

    @Override
    public MyShape mousePressed(MouseEvent e) {
        points.add(e.getPoint());
        drawingShape = new MyRectangle();
        return drawingShape;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        points.clear();
    }

    @Override
    public MyShape mouseDragged(MouseEvent e) {
        Dragger.dragged(e, points, drawingShape);
        return drawingShape;
    }
}
