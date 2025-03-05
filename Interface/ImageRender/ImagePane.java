package Interface.ImageRender;

import javax.swing.JPanel;
import java.awt.*;

public class ImagePane extends JPanel {
    private final Image image;
    public ImagePane(Image image) {
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawImage(this.image, 0, 0, this.image.getWidth(this), this.image.getHeight(this), this);
    }

}
