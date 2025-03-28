package Interface;

import Interface.ImageRender.ImageResizedPanel;
import Interface.MenuBar.MenuBar;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {
    private JPanel inputPanelFrame = new JPanel(new BorderLayout());
    private JPanel inputImageFrame = new JPanel();
    private JPanel outputPanelFrame = new JPanel(new BorderLayout());
    private JPanel outputImageFrame = new JPanel();
    public MainFrame() {
        System.out.println("Renderizando Mainframe");
        JPanel subFrame = new JPanel();
        subFrame.setBorder(BorderFactory.createEmptyBorder(20,15,20,15));
        subFrame.setLayout(new GridLayout(1, 2, 10, 0));

        // Input Panel
        JLabel inputLabel = new JLabel("Input", SwingConstants.CENTER);
        inputLabel.setFont(new Font("Arial", Font.PLAIN, 32));
        this.inputPanelFrame.add(inputLabel, BorderLayout.NORTH);
        this.inputPanelFrame.add(this.inputImageFrame, BorderLayout.CENTER);



        // Right Side Panel
        JLabel outputLabel = new JLabel("Output", SwingConstants.CENTER);
        outputLabel.setFont(new Font("Arial", Font.PLAIN, 32));
        this.outputPanelFrame.add(outputLabel, BorderLayout.NORTH);
        this.outputPanelFrame.add(this.outputImageFrame, BorderLayout.CENTER);

        // Add panels to subframe
        subFrame.add(this.inputPanelFrame);
        subFrame.add(this.outputPanelFrame);

        // Create Main Frame and add information
        Interface.MenuBar.MenuBar menuBar = new MenuBar(this);
        this.add(menuBar, BorderLayout.PAGE_START);
        this.add(subFrame);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1900, 900));
        this.setLocationRelativeTo(null);
        this.setTitle("Projeto de Processamento Digital de Imagem");
        this.setVisible(true);
    }

    public void updateInputPanel() {
        this.inputImageFrame.removeAll();
        this.inputImageFrame.setLayout(new BorderLayout());
        if (GUI.bufferedImageInput != null) {
            System.out.println("Adicionando Imagem no Input");
            Dimension imageResizeDimensions = this.getAspectRationDimensions(GUI.bufferedImageInput.getWidth(this), GUI.bufferedImageInput.getHeight(this), 621, 1000);
            ImageResizedPanel image = new ImageResizedPanel(GUI.bufferedImageInput, imageResizeDimensions.width, imageResizeDimensions.height, this.inputImageFrame);

            this.inputImageFrame.add(image, BorderLayout.CENTER);
        }
        System.out.println("Revalidando UI do Input");
        this.inputImageFrame.updateUI();
        this.updateOutputPanel();
    }

    public void updateOutputPanel() {
        this.outputImageFrame.removeAll();
        this.outputImageFrame.setLayout(new BorderLayout());
        if (GUI.bufferedImageOutput != null) {
            System.out.println("Adicionando Imagem no Output");
            Dimension imageResizeDimensions = this.getAspectRationDimensions(GUI.bufferedImageOutput.getWidth(this), GUI.bufferedImageOutput.getHeight(this), 621, 600);
            ImageResizedPanel image = new ImageResizedPanel(GUI.bufferedImageOutput, imageResizeDimensions.width, imageResizeDimensions.height, this.outputImageFrame);

            this.outputImageFrame.add(image, BorderLayout.CENTER);
        }
        System.out.println("Revalidando UI do Output");
        this.outputImageFrame.updateUI();
    }


    private Dimension getAspectRationDimensions(final int currentWidth, final int currentHeight, final int desiredWidth, final int desiredHeight) {
        int original_width = currentWidth;
        int original_height = currentHeight;
        int bound_width = desiredWidth;
        int bound_height = desiredHeight;
        int new_width = original_width;
        int new_height = original_height;

        if (original_width > bound_width) {
            //scale width to fit
            new_width = bound_width;
            //scale height to maintain aspect ratio
            new_height = (new_width * original_height) / original_width;
        }

        if (new_height > bound_height) {
            //scale height to fit instead
            new_height = bound_height;
            //scale width to maintain aspect ratio
            new_width = (new_height * original_width) / original_height;
        }

        return new Dimension(new_width, new_height);
    }

}
