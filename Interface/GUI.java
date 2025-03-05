package Interface;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class GUI{

    public static JPanel inputPanel = new JPanel(new BorderLayout());
    public static JPanel outputPanel = new JPanel(new BorderLayout());
    public static String imagePath;
    public static File fileInput;
    public static Image imageInput;
    public static Image imageOutput;


    public GUI() {
        new MainFrame();
    }



}
