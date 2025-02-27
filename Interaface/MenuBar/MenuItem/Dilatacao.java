package Interaface.MenuBar.MenuItem;

import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dilatacao extends JMenuItem implements ActionListener{
    public Dilatacao() {
        super("Dilatação");
        super.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Dilatação");
    }
}
