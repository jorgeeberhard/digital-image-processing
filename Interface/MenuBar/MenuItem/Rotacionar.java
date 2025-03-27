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
            BufferedImage inputImage = GUI.bufferedImageInput;
            int imageWidth = GUI.bufferedImageInput.getWidth();
            int imageHeight = GUI.bufferedImageInput.getHeight();
            int blackRGB = 0xFF000000;

            do {
                try {
                    String anguloString = JOptionPane.showInputDialog("Insira um angulo de 0º até 360º");
                    angle = Integer.parseInt(anguloString);
                    validInput = true;
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(this, "Valor inválido");
                }
            } while (!validInput);

            /*
            BufferedImage newImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);

            for(int x = 0; x < imageWidth; x++) {
                for(int y = 0; y < imageHeight; y++){
                    newImage.setRGB(x, y, blackRGB);
                }
            }

            double radians = Math.toRadians(angle);
            double cosTheta = Math.cos(radians);
            double sinTheta = Math.sin(radians);

            int xCenter = imageWidth / 2;
            int yCenter = imageHeight / 2;
            for(int x = 0; x < imageWidth; x++) {
                for(int y = 0; y < imageHeight; y++){
                    int xRelative = x - xCenter;
                    int yRelative = y - yCenter;

                    int newX = (int) (cosTheta * xRelative - sinTheta * yRelative + xCenter);
                    int newY = (int) (sinTheta * xRelative + cosTheta * yRelative + yCenter);

                    if(newX >= 0 && newX < imageWidth && newY >= 0 && newY < imageHeight) {
                        int rgb = inputImage.getRGB(x, y);
                        newImage.setRGB(newX, newY, rgb);
                    }
                }
            }
            GUI.bufferedImageOutput = newImage;
             */

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
