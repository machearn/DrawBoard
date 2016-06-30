package Painter;

import Shapes.MyShape;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

/**
 * Created by Specific on 16/5/25.
 **/
public abstract class MyPainter {
    public abstract MyShape mousePressed(MouseEvent e);
    public abstract void mouseReleased(MouseEvent e);
    public abstract MyShape mouseDragged(MouseEvent e);
}
