package Interface.MenuBar.MenuItem;

import Interface.GUI;
import Interface.MainFrame;
import Utils.Transformar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Espelhar extends JMenuItem implements ActionListener{
    private final MainFrame mainFrame;
    public Espelhar(MainFrame mainFrame) {
        super("Espelhar");
        super.addActionListener(this);
        this.mainFrame = mainFrame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Espelhar");
        try {

            if(GUI.bufferedImageInput == null) {
                throw new RuntimeException("Input Image needed");
            }

            boolean validInput = false;

            boolean orientacaoHorizontal = false;


            do {
                try {
                    String[] opcoes = {"Horizontal", "Vertical"};
                    int escolha = JOptionPane.showOptionDialog(
                            null,
                            "Escolha a orientação do espelhamento:",
                            "Espelhamento",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            opcoes,
                            opcoes[0]
                    );

                    orientacaoHorizontal = (escolha == 0);

                    validInput = true;
                } catch (NumberFormatException error) {
                    JOptionPane.showMessageDialog(this, "Clique em um dos botões para escolher a orientação.");
                }
            } while (!validInput);

            double[][] matriz = {
                    {1, 0, 0},
                    {0, 1, 0},
                    {0, 0, 1}
            };

            if(orientacaoHorizontal) {
                JOptionPane.showMessageDialog(this, "Espelhamento na Horizontal.");
                matriz[0][0] = -1;
            } else {
                JOptionPane.showMessageDialog(this, "Espelhamento na Vertical.");
                matriz[1][1] = -1;
            }

            Transformar.processarMatriz(matriz);

            mainFrame.updateOutputPanel();
        } catch (RuntimeException exception) {
            JOptionPane.showMessageDialog(this,"Não foi escolhido nenhuma imagem");
            System.out.println(exception);
        }
    }
}
