package Interface.MenuBar.MenuItem;

import Interface.GUI;
import Interface.MainFrame;
import Utils.Filtros;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PassaBaixa extends JMenuItem implements ActionListener{
    private final MainFrame mainFrame;
    public PassaBaixa(MainFrame mainFrame) {
        super("Passa Baixa");
        super.addActionListener(this);
        this.mainFrame = mainFrame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Passa Baixa");
        try {

            if(GUI.bufferedImageInput == null) {
                throw new RuntimeException("Input Image needed");
            }

            Filtros.passaBaixa();

            mainFrame.updateOutputPanel();
        } catch (RuntimeException exception) {
            JOptionPane.showMessageDialog(this,"Um erro aconteceu!");
            System.out.println(exception);
        }
    }
}
