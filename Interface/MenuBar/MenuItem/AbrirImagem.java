package Interface.MenuBar.MenuItem;

import Interface.GUI;
import Interface.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class AbrirImagem extends JMenuItem implements ActionListener{
    private final MainFrame mainFrame;
    public AbrirImagem(MainFrame mainFrame) {
        super("Abrir Imagem");
        super.addActionListener(this);
        this.mainFrame = mainFrame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Abrir Imagem");
        FileFilter fileFilter = new FileNameExtensionFilter("Image Files", ImageIO.getReaderFileSuffixes());
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(fileFilter);
        fileChooser.setAcceptAllFileFilterUsed(false);
        int result = fileChooser.showOpenDialog(this.mainFrame);

        File imageSelected = fileChooser.getSelectedFile();

        if (result == JFileChooser.APPROVE_OPTION) {
            System.out.println("File selected: " + imageSelected.getAbsolutePath());
            GUI.imagePath = imageSelected.getAbsolutePath();
            try {
                Image image = ImageIO.read(imageSelected.getAbsoluteFile());
                GUI.imageInput = image;
                GUI.imageOutput = image;
                mainFrame.updateInputPanel();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
