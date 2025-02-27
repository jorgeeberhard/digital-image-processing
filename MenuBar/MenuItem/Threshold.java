package MenuBar.MenuItem;

import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Threshold extends JMenuItem implements ActionListener{
    public Threshold() {
        super("Threshold");
        super.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Threshold");
    }
}
