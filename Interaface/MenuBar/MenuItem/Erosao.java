package Interaface.MenuBar.MenuItem;

import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Erosao extends JMenuItem implements ActionListener{
    public Erosao() {
        super("Erosão");
        super.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Erosão");
    }
}
