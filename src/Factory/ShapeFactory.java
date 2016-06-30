package Factory;

import Shapes.MyShape;

/**
 * Created by Specific on 16/5/5.
 **/
public class ShapeFactory {
    public static MyShape createShapeInstance(String ClassName) {
        MyShape s = null;
        try {
            s = (MyShape) Class.forName(ClassName).newInstance();
        } catch (InstantiationException | ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return s;
    }
}
