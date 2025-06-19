package Interface.MenuBar.MenuItem;

import Interface.GUI;
import Interface.MainFrame;
import Utils.Filtros;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PassaAlta extends JMenuItem implements ActionListener{
    private final MainFrame mainFrame;
    public PassaAlta(MainFrame mainFrame) {
        super("Passa Alta");
        super.addActionListener(this);
        this.mainFrame = mainFrame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Passa Alta");
        try {

            if(GUI.bufferedImageInput == null) {
                throw new RuntimeException("Input Image needed");
            }
            boolean inputValido = false;

            int treshold = 0;
            do {
                try {
                    String numberInput = JOptionPane.showInputDialog("Informe um número de Treshold");
                    treshold = Integer.parseInt(numberInput);
                    inputValido = true;
                } catch (Exception exce) {
                    System.out.println(exce);
                    JOptionPane.showMessageDialog( null,"Um erro aconteceu. Insira um número válido!");
                }
            } while (!inputValido);

            Filtros.passaAlta(treshold);

            mainFrame.updateOutputPanel();
        } catch (RuntimeException exception) {
            JOptionPane.showMessageDialog(this,"Um erro aconteceu!");
            System.out.println(exception);
        }
    }
}
