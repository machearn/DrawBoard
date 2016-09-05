package Shapes;

import util.Mover;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Specific on 16/5/6.
 **/
public class MySquare extends MyShape implements Serializable {
    private Rectangle2D square = new Rectangle2D.Double();
    private Point2D[] points = new Point2D[2];

    @Override
    public void setPoints(Vector<Point2D> p) {
        p.toArray(points);
    }

    @Override
    public void init() {
        double centerX = (points[0].getX() + points[0].getX()) / 2;
        double centerY = (points[1].getY() + points[1].getY()) / 2;
        double RadiusOfCircle = (points[0].distance(points[1])) / 2;
        square.setFrameFromCenter(centerX, centerY, centerX + RadiusOfCircle, centerY + RadiusOfCircle);
    }

    @Override
    public String getButtonName() {
        return "正方形";
    }

    @Override
    public String getClassName() {
        return "MySquare";
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.draw(square);
    }

    @Override
    public boolean contains(Point2D p) {
        return square.contains(p);
    }

    public double getLength() {
        return square.getWidth();
    }

    @Override
    public void move(Point2D p1, Point2D p2) {
        Mover.mover(p1, p2, points);
        init();
    }
}
