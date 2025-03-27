package Interface.MenuBar.MenuItem;

import Interface.GUI;
import Interface.MainFrame;
import Utils.Transformar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aumentar extends JMenuItem implements ActionListener{
    private final MainFrame mainFrame;
    public Aumentar(MainFrame mainFrame) {
        super("Aumentar");
        super.addActionListener(this);
        this.mainFrame = mainFrame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Aumentar");
        try {

            if(GUI.bufferedImageInput == null) {
                throw new RuntimeException("Input Image needed");
            }

            boolean validInput = false;
            double multiplicadorTamanho = 0;

            do {
                try {
                    String xInputString = JOptionPane.showInputDialog("Valor para modificar o tamanho da imagem:");
                    multiplicadorTamanho = Double.parseDouble(xInputString);
                    if(!(multiplicadorTamanho >= 1)) {
                        throw new NumberFormatException();
                    };
                    validInput = true;

                } catch (NumberFormatException error) {
                    JOptionPane.showMessageDialog(this, "Valor precisa ser um número positivo acima de 1");
                }
            } while (!validInput);

            JOptionPane.showMessageDialog(this, "Aumenta em " + multiplicadorTamanho + " vezes.");

            double[][] matriz = {
                    {multiplicadorTamanho, 0, 0},
                    {0, multiplicadorTamanho, 0},
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
