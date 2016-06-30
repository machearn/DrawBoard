package Shapes;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.Vector;

/**
 * Created by Specific on 16/5/25.
 **/
public class MyPolygon extends MyShape implements Serializable{
    private Vector<Point2D> points;
    private Polygon polygon;
    private int x[];
    private int y[];

    @Override
    public String getButtonName() {
        return "多边形";
    }

    @Override
    public String getClassName() {
        return "MyPolygon";
    }

    public int getNumberOfPoints() {
        return points.size();
    }

    @Override
    public void setPoints(Vector<Point2D> p) {
        points = new Vector<>(p);
    }

    @Override
    public boolean contains(Point2D p) {
        return polygon.contains(p);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawPolygon(polygon);
    }

    @Override
    public void move(Point2D p1, Point2D p2) {
        double dx = p2.getX() - p1.getX();
        double dy = p2.getY() - p1.getY();
        for (Point2D p : points) {
            Point2D point = new Point2D.Double(p.getX() + dx, p.getY() + dy);
            p.setLocation(point);
        }
        init();
    }

    @Override
    public void init() {
        int n = points.size();
        int x[] = new int[n];
        int y[] = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = (int) points.elementAt(i).getX();
            y[i] = (int) points.elementAt(i).getY();
        }
        polygon = new Polygon(x, y, n);
    }
}
