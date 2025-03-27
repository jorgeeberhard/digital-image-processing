package Interface.MenuBar.MenuItem;

import Interface.GUI;
import Interface.MainFrame;
import Utils.Transformar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Transladar extends JMenuItem implements ActionListener{
    private final MainFrame mainFrame;
    public Transladar(MainFrame mainFrame) {
        super("Transladar");
        super.addActionListener(this);
        this.mainFrame = mainFrame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Transladar");
        try {

            if(GUI.bufferedImageInput == null) {
                throw new RuntimeException("Input Image needed");
            }

            boolean validInput = false;
            int xInput = 0;
            int yInput = 0;

            do {
                try {
                    String xInputString = JOptionPane.showInputDialog("Valor em X para Transladar:");
                    xInput = Integer.parseInt(xInputString);
                    String yInputString = JOptionPane.showInputDialog("Valor em Y para Transladar:");
                    yInput = Integer.parseInt(yInputString);
                    validInput = true;
                } catch (NumberFormatException error) {
                    JOptionPane.showMessageDialog(this, "Valor precisa ser um número inteiro");
                }
            } while (!validInput);

            JOptionPane.showMessageDialog(this, "Translação em X: " + xInput + "\nTranslação em Y: " + yInput);

            double[][] matriz = {
                    {1, 0, xInput},
                    {0, 1, yInput},
                    {0, 0, 1}
            };

            Transformar.processarMatriz(matriz);

            mainFrame.updateOutputPanel();
        } catch (RuntimeException exception) {
            JOptionPane.showMessageDialog(this,"Não foi escolhido nenhuma imagem");
            System.out.println(exception);
        }

    }
}
