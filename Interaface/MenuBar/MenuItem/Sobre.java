package Interaface.MenuBar.MenuItem;

import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sobre extends JMenuItem implements ActionListener{
    public Sobre() {
        super("Sobre");
        super.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Sobre");
    }
}
