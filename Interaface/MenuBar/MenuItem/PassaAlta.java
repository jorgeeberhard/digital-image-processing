package Interaface.MenuBar.MenuItem;

import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PassaAlta extends JMenuItem implements ActionListener{
    public PassaAlta() {
        super("Passa Alta");
        super.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Passa Alta");
    }
}
