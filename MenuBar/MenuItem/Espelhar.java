package MenuBar.MenuItem;

import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Espelhar extends JMenuItem implements ActionListener{
    public Espelhar() {
        super("Espelhar");
        super.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Espelhar");
    }
}
