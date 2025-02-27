package MenuBar.MenuItem;

import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Diminuir extends JMenuItem implements ActionListener{
    public Diminuir() {
        super("Diminuir");
        super.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Diminuir");
    }
}
