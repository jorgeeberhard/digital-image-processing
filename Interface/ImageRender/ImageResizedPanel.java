package Interface.ImageRender;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ImageResizedPanel extends JPanel {
    private final Image image;
    private final int width;
    private final int height;
    private final JPanel imagePanel;

    public ImageResizedPanel(Image image, int width, int height, JPanel imagePanel) {
        this.image = image;
        this.width = width;
        this.height = height;
        this.imagePanel = imagePanel;

        this.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                new ImageScrollFrame(image);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int panelWidth = this.imagePanel.getWidth();
        int panelHeight = this.imagePanel.getHeight();
        int x = (panelWidth - this.width)/2;
        int y = (panelHeight - this.height)/2;
        g.drawImage(this.image, x, y, this.width, this.height, this);
    }


}
