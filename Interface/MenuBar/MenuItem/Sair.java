package Interface.MenuBar.MenuItem;

import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Interface.GUI;
import Interface.MainFrame;

public class Sair extends JMenuItem implements ActionListener{
    private final MainFrame mainFrame;
    public Sair(MainFrame mainFrame) {
        super("Sair");
        super.addActionListener(this);
        this.mainFrame = mainFrame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        this.mainFrame.dispose();
    }
}
