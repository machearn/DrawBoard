package Painter;

import Shapes.MyPolygon;
import Shapes.MyShape;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.Vector;

/**
 * Created by Specific on 16/5/27.
 **/
public class MyPolygonPainter extends MyPainter {
    private Vector<Point2D> points = new Vector<Point2D>();
    private MyPolygon drawingShape = null;

    @Override
    public MyShape mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            points.add(e.getPoint());
        }
        if (e.getButton() == MouseEvent.BUTTON3) {
            drawingShape = new MyPolygon();
            drawingShape.setPoints(points);
            drawingShape.init();
            points.clear();
        }
        return drawingShape;
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public MyShape mouseDragged(MouseEvent e) {
        return null;
    }
}
