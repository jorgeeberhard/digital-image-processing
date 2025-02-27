package MenuBar.MenuItem;

import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Grayscale extends JMenuItem implements ActionListener{
    public Grayscale() {
        super("Grayscale");
        super.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Grayscale");
    }
}
