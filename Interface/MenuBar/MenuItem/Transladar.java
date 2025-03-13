package Interface.MenuBar.MenuItem;

import Interface.GUI;
import Interface.MainFrame;

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


            BufferedImage inputImage = GUI.bufferedImageInput;
            int imageWidth = inputImage.getWidth();
            int imageHeight = inputImage.getHeight();
            int blackRGB = 0xFF000000;

            BufferedImage newImage = new BufferedImage(imageWidth + xInput, imageHeight + yInput, BufferedImage.TYPE_INT_ARGB);

            for(int x = 0; x < newImage.getWidth(); x++) {
                for(int y = 0; y < newImage.getHeight(); y++){
                    newImage.setRGB(x, y, blackRGB);
                }
            }

            for(int x = 0; x < imageWidth; x++) {
                for(int y = 0; y < imageHeight; y++){
                    int newX = x + xInput;
                    int newY = y + yInput;

                    if(newX >= 0 && newY >= 0) {
                        int rgb = inputImage.getRGB(x, y);

                        newImage.setRGB(newX, newY, rgb);
                        GUI.bufferedImageOutput = newImage;
                    }
                }
            }

            mainFrame.updateOutputPanel();
        } catch (RuntimeException exception) {
            JOptionPane.showMessageDialog(this,"Não foi escolhido nenhuma imagem");
            System.out.println(exception);
        }

    }
}
