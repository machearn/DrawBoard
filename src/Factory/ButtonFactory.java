package Factory;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

/**
 * Created by Specific on 16/5/6.
 **/
public class ButtonFactory {
    public static ArrayList<String> getClassNames() {
        ArrayList<String> classNames = new ArrayList<>();
        File dir = new File("src/Shapes");
        File[] classes = dir.listFiles(file -> (!(file.getName().equals("MyShape.java")) && !(file.getName().equals(".DS_Store"))));

        for (File f : classes) {
            classNames.add(f.getName().substring(0, f.getName().length() - 5));
        }
        return classNames;
    }
}
