package Shapes;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.Vector;

/**
 * Created by Specific on 16/5/4.
 **/

public abstract class MyShape implements Serializable{

    public abstract String getButtonName();

    public abstract String getClassName();

    public abstract void setPoints(Vector<Point2D> p);

    public abstract boolean contains(Point2D p);

    public abstract void draw(Graphics g);

    public abstract void move(Point2D p1, Point2D p2);

    public abstract void init();
}
