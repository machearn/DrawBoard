package util;

import java.awt.geom.Point2D;

/**
 * Created by Specific on 16/9/5.
 **/
public class Mover {
    public static void mover(Point2D p1, Point2D p2, Point2D[] points) {
        double dx = p2.getX() - p1.getX();
        double dy = p2.getY() - p1.getY();
        Point2D newPoint1 = new Point2D.Double(points[0].getX() + dx, points[0].getY() + dy);
        Point2D newPoint2 = new Point2D.Double(points[1].getX() + dx, points[1].getY() + dy);
        points[0].setLocation(newPoint1);
        points[1].setLocation(newPoint2);
    }
}
