package Painter;

import Shapes.MyRectangle;
import Shapes.MyShape;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.Vector;

/**
 * Created by Specific on 16/5/27.
 **/
public class MyRectanglePainter extends MyPainter {
    private Vector<Point2D> points = new Vector<Point2D>();
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
        points.add(e.getPoint());
        drawingShape.setPoints(points);
        drawingShape.init();
        points.remove(1);
        return drawingShape;
    }
}
