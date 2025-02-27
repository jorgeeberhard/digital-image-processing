package MenuBar.MenuItem;

import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fechamento extends JMenuItem implements ActionListener{
    public Fechamento() {
        super("Fechamento");
        super.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Fechamento");
    }
}
