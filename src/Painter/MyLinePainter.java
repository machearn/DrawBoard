package Painter;

import Shapes.MyLine;
import Shapes.MyShape;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.Vector;

/**
 * Created by Specific on 16/5/29.
 **/
public class MyLinePainter extends MyPainter {
    private MyLine drawingShape;

    @Override
    public MyShape mousePressed(MouseEvent e) {
        points.add(e.getPoint());
        drawingShape = new MyLine();
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
