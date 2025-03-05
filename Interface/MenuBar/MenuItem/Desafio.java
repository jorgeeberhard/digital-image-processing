package Interface.MenuBar.MenuItem;

import Interface.MainFrame;

import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Desafio extends JMenuItem implements ActionListener{
    private final MainFrame mainFrame;
    public Desafio(MainFrame mainframe) {
        super("Desafio");
        super.addActionListener(this);
        this.mainFrame = mainframe;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Desafio");
    }
}
