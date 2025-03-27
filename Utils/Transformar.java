package Utils;

import Interface.GUI;

import java.awt.image.BufferedImage;

public class Transformar {
    public static void processarMatriz(double[][] matriz){
        System.out.println("Processando Matriz");

        BufferedImage inputImage = GUI.bufferedImageInput;
        int imageWidth = inputImage.getWidth();
        int imageHeight = inputImage.getHeight();

        int blackRGB = 0xFF000000;
        BufferedImage newImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);

        for(int x = 0; x < imageWidth; x++) {
            for(int y = 0; y < imageHeight; y++){
                newImage.setRGB(x, y, blackRGB);
            }
        }

        int xCenter = imageWidth / 2;
        int yCenter = imageHeight / 2;

        for (int x = 0; x < imageWidth; x++) {
            for (int y = 0; y < imageHeight; y++) {
                int xRelative = x - xCenter;
                int yRelative = y - yCenter;

                int newX = (int) (matriz[0][0] * xRelative + matriz[0][1] * yRelative + 1 * matriz[0][2]);
                int newY = (int) (matriz[1][0] * xRelative + matriz[1][1] * yRelative + 1 * matriz[1][2]);

                newX += xCenter;
                newY += yCenter;

                if(newX >= 0 && newX < imageWidth && newY >= 0 && newY < imageHeight) {
                    int rgb = inputImage.getRGB(x, y);
                    newImage.setRGB(newX, newY, rgb);
                }
            }
        }
        GUI.bufferedImageOutput = newImage;
    }
}
