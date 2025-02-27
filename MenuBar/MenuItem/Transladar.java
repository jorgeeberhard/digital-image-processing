package MenuBar.MenuItem;

import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transladar extends JMenuItem implements ActionListener{
    public Transladar() {
        super("Transladar");
        super.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Transladar");
    }
}
