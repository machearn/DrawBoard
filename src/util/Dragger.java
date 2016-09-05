package util;

import Shapes.MyShape;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.Vector;

/**
 * Created by Specific on 16/9/5.
 **/
public class Dragger {
    public static void dragged(MouseEvent e, Vector<Point2D> points, MyShape drawingShape) {
        points.add(e.getPoint());
        drawingShape.setPoints(points);
        drawingShape.init();
        points.remove(1);
    }
}
