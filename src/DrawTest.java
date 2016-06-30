import javax.swing.*;
import java.awt.*;

import Frame.DrawFrame;

/**
 * Created by Specific on 16/5/5.
 **/
public class DrawTest {
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new DrawFrame();
                frame.setTitle("画板");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
