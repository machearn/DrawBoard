package Frame;

import javax.swing.*;

import Factory.PainterFactory;
import Shapes.*;
import Painter.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import SaveRead.*;

/**
 * Created by Specific on 16/5/5.
 **/
public class DrawComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 1200;
    private static final int DEFAULT_HEIGHT = 650;

    private ArrayList<MyShape> shapes;
    private MyShape drawingShape;
    private MyShape currentShape = null;
    private MyPainter painter;

    private Point2D[] moveVector = new Point2D[2];

    public DrawComponent() {
        shapes = new ArrayList<>();
        try {
            shapes = SaveRead.Read();
        } catch (EOFException e) {
            try {
                SaveRead.Save(shapes);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseMotionHandler());
    }

    public ArrayList<MyShape> getShapes() {
        return shapes;
    }

    public void setClassName(String g) {
        String painterName = "Painter." + g + "Painter";
        painter = PainterFactory.createPainterInstance(painterName);
    }

    public void paintComponent(Graphics g) {
        for (MyShape s : shapes) {
            s.draw(g);
        }
    }

    void clear() {
        shapes.clear();
        repaint();
    }

    public MyShape find(Point2D p) {
        for (MyShape s : shapes) {
            if (s.contains(p))
                return s;
        }
        return null;
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    private class MouseHandler extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            currentShape = find(e.getPoint());
            if (currentShape == null) {
                drawingShape = painter.mousePressed(e);
                if (drawingShape != null)
                    shapes.add(drawingShape);
                repaint();
            } else {
                setClassName(currentShape.getClassName());
                moveVector[0] = e.getPoint();
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            painter.mouseReleased(e);
        }
    }

    private class MouseMotionHandler implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {
            if (currentShape == null) {
                drawingShape = painter.mouseDragged(e);
                repaint();
            } else {
                moveVector[1] = e.getPoint();
                currentShape.move(moveVector[0], moveVector[1]);
                moveVector[0] = moveVector[1];
                repaint();
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }
}
