package Shapes;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.Vector;

/**
 * Created by Specific on 16/5/6.
 **/
public class MyLine extends MyShape implements Serializable {
    private Line2D line2D = new Line2D.Double();
    private Point2D[] points = new Point2D[2];

    @Override
    public void setPoints(Vector<Point2D> p) {
        p.toArray(points);
    }

    @Override
    public String getButtonName() {
        return "直线";
    }

    @Override
    public String getClassName() {
        return "MyLine";
    }

    @Override
    public void init() {
        line2D.setLine(points[0], points[1]);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.draw(line2D);
    }

    @Override
    public boolean contains(Point2D p) {
        return (line2D.ptLineDist(p) < 2.0);
    }

    @Override
    public void move(Point2D p1, Point2D p2) {
        double dx = p2.getX() - p1.getX();
        double dy = p2.getY() - p1.getY();
        Point2D newPoint1 = new Point2D.Double(points[0].getX() + dx, points[0].getY() + dy);
        Point2D newPoint2 = new Point2D.Double(points[1].getX() + dx, points[1].getY() + dy);
        points[0].setLocation(newPoint1);
        points[1].setLocation(newPoint2);
        init();
    }
}
