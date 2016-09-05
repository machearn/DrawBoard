package Shapes;

import util.Mover;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Specific on 16/5/4.
 **/
public class MyRectangle extends MyShape implements Serializable {
    private Rectangle2D rectangle2D = new Rectangle2D.Double();
    private Point2D[] points = new Point2D[2];

    @Override
    public String getButtonName() {
        return "长方形";
    }

    @Override
    public String getClassName() {
        return "MyRectangle";
    }

    @Override
    public void init() {
        rectangle2D.setFrameFromDiagonal(points[0], points[1]);
    }

    public double getWidth() {
        return rectangle2D.getWidth();
    }

    public double getHeight() {
        return rectangle2D.getHeight();
    }

    @Override
    public void setPoints(Vector<Point2D> p) {
        p.toArray(points);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.draw(rectangle2D);
    }

    @Override
    public boolean contains(Point2D p) {
        return rectangle2D.contains(p);
    }

    @Override
    public void move(Point2D p1, Point2D p2) {
        Mover.mover(p1, p2, points);
        init();
    }
}
