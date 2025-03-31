package Interface.MenuBar.MenuItem;

import Interface.GUI;
import Interface.MainFrame;
import Utils.Transformar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Rotacionar extends JMenuItem implements ActionListener{
    private final MainFrame mainFrame;
    record RotatedDimensions(double width, double height) {};
    public Rotacionar(MainFrame mainFrame) {
        super("Rotacionar");
        super.addActionListener(this);
        this.mainFrame = mainFrame;

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Rotacionar");
        try {

            int angle = 0;
            boolean validInput = false;

            do {
                try {
                    String anguloString = JOptionPane.showInputDialog("Insira um angulo de 0º até 360º");
                    angle = Integer.parseInt(anguloString);
                    validInput = true;
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(this, "Valor inválido");
                }
            } while (!validInput);

            double[][] matriz = {
                    {Math.cos(Math.toRadians(angle)), -Math.sin(Math.toRadians(angle)), 0},
                    {Math.sin(Math.toRadians(angle)), Math.cos(Math.toRadians(angle)), 0},
                    {0, 0, 1}
            };
            Transformar.processarMatriz(matriz);
            mainFrame.updateOutputPanel();
        } catch (RuntimeException exception) {
            System.out.println(exception);
        }
    }
}
