package Interaface.MenuBar.MenuItem;

import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Desafio extends JMenuItem implements ActionListener{
    public Desafio() {
        super("Desafio");
        super.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Desafio");
    }
}
