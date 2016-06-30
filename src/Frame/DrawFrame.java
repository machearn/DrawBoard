package Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringJoiner;

import Factory.ButtonFactory;
import Factory.ShapeFactory;
import SaveRead.*;

/**
 * Created by Specific on 16/5/5.
 **/
public class DrawFrame extends JFrame {
    private DrawComponent drawComponent;
    private static final int DEFAULT_WIDTH = 1200;
    private static final int DEFAULT_HEIGHT = 700;

    public DrawFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        drawComponent = new DrawComponent();
        JPanel buttonPanel = new JPanel();
        ArrayList<String> classNames = ButtonFactory.getClassNames();

        for (String className : classNames) {
            String graphClassName = "Shapes." + className;
            addButton(buttonPanel, ShapeFactory.createShapeInstance(graphClassName).getButtonName(), e -> drawComponent.setClassName(className));
        }

        addButton(buttonPanel, "保存", e -> {
            try {
                SaveRead.Save(drawComponent.getShapes());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        addButton(buttonPanel, "清除", e -> drawComponent.clear());

        add(buttonPanel, BorderLayout.NORTH);
        add(drawComponent, BorderLayout.CENTER);
        pack();
    }

    private void addButton(Container c, String title, ActionListener listener) {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }
}
