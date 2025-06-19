package Utils;

import Interface.GUI;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Filtros {
    public static void grayscale() {
        BufferedImage inputImage = GUI.bufferedImageInput;
        int imageWidth = inputImage.getWidth();
        int imageHeight = inputImage.getHeight();

        for(int x = 0; x < imageWidth; x++) {
            for(int y = 0; y < imageHeight; y++) {
                int inputRGB = inputImage.getRGB(x, y);

                int alpha = (inputRGB >> 24) & 0xFF;
                int red   = (inputRGB >> 16) & 0xFF;
                int green = (inputRGB >> 8)  & 0xFF;
                int blue  = inputRGB & 0xFF;

                int gray = (red + green + blue)/3;

                int newRGB = (alpha << 24) | (gray << 16) | (gray << 8) | gray;

                GUI.bufferedImageOutput.setRGB(x, y, newRGB);
            }
        }
    }

    public static void passaBaixa() {
        BufferedImage inputImage = GUI.bufferedImageInput;
        int imageWidth = GUI.bufferedImageInput.getWidth();
        int imageHeight = GUI.bufferedImageInput.getHeight();

        BufferedImage newImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);

        double[][] kernel = {
                {1/16.0, 2/16.0, 1/16.0},
                {2/16.0, 4/16.0, 2/16.0},
                {1/16.0, 2/16.0, 1/16.0}
        };

        int raio = 1;

        for(int y = raio; y < imageHeight - raio; y++) {
            for(int x = raio; x < imageWidth - raio; x++) {
                double somaR = 0;
                double somaG = 0;
                double somaB = 0;

                for(int ky = -raio; ky <= raio; ky++) {
                    for(int kx = -raio; kx <= raio; kx++) {
                        Color cor = new Color(inputImage.getRGB(x + kx, y + ky));

                        double peso = kernel[ky + raio][kx + raio];
                        somaR += cor.getRed() * peso;
                        somaG += cor.getGreen() * peso;
                        somaB += cor.getBlue() * peso;
                    }
                }

                int novoR = Math.min(255, Math.max(0, (int) somaR));
                int novoG = Math.min(255, Math.max(0, (int) somaG));
                int novoB = Math.min(255, Math.max(0, (int) somaB));

                Color novaCor = new Color(novoR, novoG, novoB);
                newImage.setRGB(x, y, novaCor.getRGB());
            }
        }

        GUI.bufferedImageOutput = newImage;

    }

    public static void passaAlta(int threshold) {
        grayscale();
        double[][] xKernel = {
                {1, 0, -1},
                {2, 0, -2},
                {1, 0, -1}
        };

        double[][] yKernel = {
                {1, 2, 1},
                {0, 0, 0},
                {-1, -2, 1}
        };

        BufferedImage inputImage = GUI.bufferedImageOutput;
        int imageWidth = inputImage.getWidth();
        int imageHeight = inputImage.getHeight();

        int imageWidth1 = imageWidth - 1;
        int imageHeight1 = imageHeight - 1;


        BufferedImage newImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        double v, gx, gy, g = 0;

        for(int y = 1; y < imageHeight1; y++) {
            for(int x = 1; x < imageWidth1; x++) {
                gx = gy = 0;
                for(int i = 0; i < 3; i++) {
                    for(int j = 0; j < 3; j++) {
                        v = new Color(inputImage.getRGB(x + (i - 1), y + (j - 1))).getRed();

                        gx += v * xKernel[i][j];
                        gy += v * yKernel[i][j];
                    }
                }

                g = Math.sqrt((gx * gx) + (gy * gy));
                int p = 0;
                if(g > threshold){
                    p = 255;
                }
                newImage.setRGB(x, y, new Color(p, p, p).getRGB());
            }
        }
        GUI.bufferedImageOutput = newImage;

    }

    public static void treshold(int thresholdMax, int thresholdMin) {
        grayscale();
        
    }

}
