package Interface.ImageRender;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

public class ImageScrollFrame extends JFrame {
    private final BufferedImage image;
    public ImageScrollFrame(BufferedImage image) {
        this.image = image;

        ImageIcon imageIcon = new ImageIcon(image);
        JScrollPane scrollPane = new JScrollPane(new JLabel(imageIcon));
        this.getContentPane().add(scrollPane);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setMinimumSize(new Dimension(this.image.getWidth(this), this.image.getHeight(this)));
        this.setLocationRelativeTo(null);
        this.setTitle("Projeto de Processamento Digital de Imagem");
        this.setVisible(true);
    }
}
