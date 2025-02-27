import javax.swing.*;
import java.awt.*;
import MenuBar.MenuBar;

public class GUI {
    public GUI() {
        JFrame frame = new JFrame();
        MenuBar menuBar = new MenuBar();

        frame.add(menuBar, BorderLayout.PAGE_START);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Projeto de Processamento Digital de Imagem");
        frame.setVisible(true);
    }



}
