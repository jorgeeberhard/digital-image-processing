package Interface.MenuBar.MenuItem;

import Interface.GUI;
import Interface.MainFrame;
import Utils.Filtros;
import Utils.MorfologiaMatematicaFiltro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Erosao extends JMenuItem implements ActionListener{
    private final MainFrame mainFrame;
    public Erosao(MainFrame mainFrame) {
        super("Erosão");
        super.addActionListener(this);
        this.mainFrame = mainFrame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Erosão");
        try {

            if(GUI.bufferedImageInput == null) {
                throw new RuntimeException("Input Image needed");
            }

            MorfologiaMatematicaFiltro.erosao();


            mainFrame.updateOutputPanel();
        } catch (RuntimeException exception) {
            JOptionPane.showMessageDialog(this,"Um erro aconteceu!");
            System.out.println(exception);
        }
    }
}
