package Interface.MenuBar.MenuItem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Interface.GUI;
import Interface.MainFrame;

public class Sobre extends JMenuItem implements ActionListener{
    private final MainFrame mainFrame;
    public Sobre(MainFrame mainFrame) {
        super("Sobre");
        super.addActionListener(this);
        this.mainFrame = mainFrame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this.mainFrame, "Este é um projeto desenvolvido no curso de Ciência da Computação na Universidade Feevale, na cadeira de Processamento Digital de Imagem.");
        System.out.println("Sobre");
    }
}
