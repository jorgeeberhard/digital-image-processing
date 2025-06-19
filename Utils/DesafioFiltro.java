package Utils;

import Interface.GUI;
import Interface.MainFrame;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class DesafioFiltro {
    public static void calcularComprimidos(MainFrame mainFrame) {
       Filtros.passaAlta(100);
       GUI.bufferedImageInput = GUI.bufferedImageOutput;
       MorfologiaMatematicaFiltro.erosao();
       GUI.bufferedImageInput = GUI.bufferedImageOutput;
       MorfologiaMatematicaFiltro.erosao();
       mainFrame.updateOutputPanel();
       mainFrame.updateInputPanel();

       BufferedImage imagem = GUI.bufferedImageOutput;
       int height = imagem.getHeight();
       int width = imagem.getWidth();
       boolean preenchido = false;
       int pixeisPreenchidos = 0;
       int comprimidosRedondos = 0;
       int comprimidosCapsulas = 0;
       int comprimidosQuebrados = 0;
        for (int y = 0; y < height && !preenchido; y++) {
            for (int x = 0; x < width && !preenchido; x++) {
                if (isWhite(imagem, x, y)) {
                    pixeisPreenchidos = floodFill(imagem, x, y);
                    if(pixeisPreenchidos > 11000) {
                        comprimidosCapsulas++;
                    } else if (pixeisPreenchidos < 5000) {
                        comprimidosQuebrados++;
                    } else {
                        comprimidosRedondos++;
                    }
                }
            }
        }

        mainFrame.updateOutputPanel();
        String textoMensagem = "Capsulas: " + comprimidosCapsulas + "\n" + "Comprimidos: " + comprimidosRedondos + "\n" + "Quebrados: " + comprimidosQuebrados + "\n" + "Total: " + (comprimidosCapsulas + comprimidosRedondos + comprimidosQuebrados);
        JOptionPane.showMessageDialog(null, textoMensagem);
    }

    private static int floodFill(BufferedImage img, int startX, int startY) {
        int width = img.getWidth();
        int height = img.getHeight();

        int contador = 0;

        Queue<int[]> fila = new LinkedList<>();
        fila.add(new int[]{startX, startY});

        while (!fila.isEmpty()) {
            int[] pixel = fila.poll();
            int x = pixel[0];
            int y = pixel[1];

            if (x < 0 || x >= width || y < 0 || y >= height) continue;
            if (!isWhite(img, x, y)) continue;

            img.setRGB(x, y, 0xFF000000);  // Preto
            contador++;

            fila.add(new int[]{x + 1, y});
            fila.add(new int[]{x - 1, y});
            fila.add(new int[]{x, y + 1});
            fila.add(new int[]{x, y - 1});
        }
        return contador;
    }

    private static boolean isWhite(BufferedImage img, int x, int y) {
        int rgb = img.getRGB(x, y);
        int r = (rgb >> 16) & 0xFF;
        int g = (rgb >> 8) & 0xFF;
        int b = rgb & 0xFF;
        return r > 200 && g > 200 && b > 200;  // Considerando pixels quase brancos como branco
    }



}
