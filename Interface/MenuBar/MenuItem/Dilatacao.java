package Interface.MenuBar.MenuItem;

import Interface.MainFrame;

import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dilatacao extends JMenuItem implements ActionListener{
    private final MainFrame mainFrame;
    public Dilatacao(MainFrame mainFrame) {
        super("Dilatação");
        super.addActionListener(this);
        this.mainFrame = mainFrame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Dilatação");
    }
}
