package Interface.MenuBar.MenuItem;

import Interface.GUI;
import Interface.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Utils.DesafioFiltro;
import Utils.Filtros;

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
        try {

            if(GUI.bufferedImageInput == null) {
                throw new RuntimeException("Input Image needed");
            }

            DesafioFiltro.calcularComprimidos(mainFrame);

            mainFrame.updateOutputPanel();
        } catch (RuntimeException exception) {
            JOptionPane.showMessageDialog(this,"Um erro aconteceu!");
            System.out.println(exception);
        }
    }
}
