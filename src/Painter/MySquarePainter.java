package Painter;

import Shapes.MyShape;
import Shapes.MySquare;
import util.Dragger;

import java.awt.event.MouseEvent;

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
        Dragger.dragged(e, points, drawingShape);
        return drawingShape;
    }
}
