package SaveRead;

import Shapes.MyShape;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Specific on 16/5/6.
 **/
public class SaveRead {
    public static void Save(ArrayList<MyShape> a) throws IOException {
        FileOutputStream file;
        file = new FileOutputStream("ShapeList");
        ObjectOutputStream outObj = new ObjectOutputStream(file);
        outObj.writeObject(a);
        outObj.close();
    }

    public static ArrayList<MyShape> Read() throws IOException, ClassNotFoundException {
        ArrayList<MyShape> shapes;
        FileInputStream file;
        file = new FileInputStream("ShapeList");
        ObjectInputStream inObj = new ObjectInputStream(file);
        shapes = (ArrayList<MyShape>) inObj.readObject();
        inObj.close();
        return shapes;
    }
}
