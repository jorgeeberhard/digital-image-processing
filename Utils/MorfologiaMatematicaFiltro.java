package Utils;

import Interface.GUI;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MorfologiaMatematicaFiltro {
    public static void erosao() {
        BufferedImage inputImage = GUI.bufferedImageInput;
        int largura = inputImage.getWidth();
        int altura = inputImage.getHeight();

        BufferedImage output = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_ARGB);

        int[][] estruturaErosao = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };

        int eAltura = estruturaErosao.length;
        int eLargura = estruturaErosao[0].length;
        int eCentroY = eAltura / 2;
        int eCentroX = eLargura / 2;

        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                boolean match = true;

                for(int i = 0; i < eAltura; i++) {
                    for (int j = 0; j < eLargura; j++) {
                        int yy = y + i - eCentroY;
                        int xx = x + j - eCentroX;

                        if(yy < 0 || yy >= altura || xx < 0 || xx >= largura) {
                            match = false;
                            break;
                        }

                        int pixel = new Color(inputImage.getRGB(xx, yy)).getRed();
                        if(estruturaErosao[i][j] == 1 && pixel == 0) {
                            match = false;
                            break;
                        }
                    }
                    if(!match) break;
                }

                int novoValor = match ? 255 : 0;
                output.setRGB(x, y, new Color(novoValor, novoValor, novoValor).getRGB());
            }
        }
        GUI.bufferedImageOutput = output;

    }
}
