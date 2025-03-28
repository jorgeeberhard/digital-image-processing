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
        int newImageWidth = (int) ((imageWidth + matriz[0][2]) * matriz[0][0]);
        int newImageHeight = (int) ((imageHeight + matriz[1][2]) * matriz[1][1]);

        if(newImageHeight < 0) {
            newImageHeight = -newImageHeight;
        }

        if(newImageWidth < 0) {
            newImageWidth = -newImageWidth;
        }

        if((matriz[0][1] != 0) || (matriz[1][0] != 0)) {
            double angle = Math.atan2(matriz[1][0], matriz[0][0]); // Extraindo o ângulo de rotação
            double cosTheta = Math.cos(angle);
            double sinTheta = Math.sin(angle);

            // Definir os 4 vértices da imagem original
            int[][] originalCorners = {
                    {0, 0}, {imageWidth, 0}, {0, imageHeight}, {imageWidth, imageHeight}
            };

            // Variáveis para armazenar os novos extremos
            double minX = Double.MAX_VALUE, maxX = Double.MIN_VALUE;
            double minY = Double.MAX_VALUE, maxY = Double.MIN_VALUE;

            // Aplicar a transformação em cada canto
            for (int[] corner : originalCorners) {
                double x = corner[0], y = corner[1];

                // Aplicar rotação
                double newX = x * cosTheta - y * sinTheta;
                double newY = x * sinTheta + y * cosTheta;

                // Atualizar os limites
                minX = Math.min(minX, newX);
                maxX = Math.max(maxX, newX);
                minY = Math.min(minY, newY);
                maxY = Math.max(maxY, newY);
            }

            // Calcular o novo tamanho da imagem
            newImageWidth = (int) Math.ceil(maxX - minX);
            newImageHeight = (int) Math.ceil(maxY - minY);

        }

        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[i].length; j++) {
                System.out.printf("{%s} ", matriz[i][j]);
            }
            System.out.printf("\n");
        }

        BufferedImage newImage = new BufferedImage(newImageWidth, newImageHeight, BufferedImage.TYPE_INT_ARGB);


        for(int x = 0; x < newImageWidth; x++) {
            for(int y = 0; y < newImageHeight; y++){
                newImage.setRGB(x, y, blackRGB);
            }
        }

        int xCenter = newImageWidth / 2;
        int yCenter = newImageHeight / 2;
        int xOldCenter = imageWidth / 2;
        int yOldCenter = imageHeight / 2;

        for (int x = 0; x < newImageWidth; x++) {
            for (int y = 0; y < newImageHeight; y++) {
                int xRelative = x - xCenter;
                int yRelative = y - yCenter;


                double a = matriz[0][0], b = matriz[0][1], tx = matriz[0][2];
                double c = matriz[1][0], d = matriz[1][1], ty = matriz[1][2];

                // Determinante da matriz
                double det = a * d - b * c;
                if (det == 0) {
                    System.out.println("Erro: Matriz de transformação não é inversível!");
                    return;
                }

                // Inversão da matriz de transformação
                double invA = d / det, invB = -b / det;
                double invC = -c / det, invD = a / det;
                double invTx = (b * ty - d * tx) / det;
                double invTy = (c * tx - a * ty) / det;

                // Aplicação da inversão
                int origemX = (int) (invA * xRelative + invB * yRelative + invTx);
                int origemY = (int) (invC * xRelative + invD * yRelative + invTy);


                origemX += xOldCenter;
                origemY += yOldCenter;

                if(origemX >= 0 && origemX < imageWidth && origemY >= 0 && origemY < imageHeight) {
                    int rgb = inputImage.getRGB(origemX, origemY);
                    newImage.setRGB(x, y, rgb);
                }
            }
        }
        GUI.bufferedImageOutput = newImage;
    }
}
