package Interaface.MenuBar.MenuItem;

import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Interaface.GUI;

public class AbrirImagem extends JMenuItem implements ActionListener{
    public AbrirImagem() {
        super("Abrir Imagem");
        super.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        GUI.buttonDefault.setText("Abrir Imagem");
        System.out.println("Abrir Imagem");
    }
}
