package Painter;

import Shapes.MyShape;
import Shapes.MySquare;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.Vector;

/**
 * Created by Specific on 16/9/5.
 **/
public class MySquarePainter extends MyPainter{
    private MySquare drawingShape;

    @Override
    public MyShape mousePressed(MouseEvent e) {
        points.add(e.getPoint());
        drawingShape = new MySquare();
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
