package Interaface.MenuBar.MenuItem;

import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PassaBaixa extends JMenuItem implements ActionListener{
    public PassaBaixa() {
        super("Passa Baixa");
        super.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Passa Baixa");
    }
}
