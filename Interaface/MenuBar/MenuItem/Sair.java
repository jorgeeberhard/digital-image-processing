package Interaface.MenuBar.MenuItem;

import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sair extends JMenuItem implements ActionListener{
    public Sair() {
        super("Sair");
        super.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Sair");
    }
}
