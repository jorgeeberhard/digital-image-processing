package MenuBar.MenuItem;

import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rotacionar extends JMenuItem implements ActionListener{
    public Rotacionar() {
        super("Rotacionar");
        super.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Rotacionar");
    }
}
