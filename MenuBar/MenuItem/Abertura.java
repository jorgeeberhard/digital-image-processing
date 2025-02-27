package MenuBar.MenuItem;

import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Abertura extends JMenuItem implements ActionListener{
    public Abertura() {
        super("Abertura");
        super.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Abertura");
    }
}
