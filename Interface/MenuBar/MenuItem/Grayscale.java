package Interface.MenuBar.MenuItem;

import Interface.MainFrame;

import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Grayscale extends JMenuItem implements ActionListener{
    private final MainFrame mainFrame;
    public Grayscale(MainFrame mainFrame) {
        super("Grayscale");
        super.addActionListener(this);
        this.mainFrame = mainFrame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Grayscale");
    }
}
