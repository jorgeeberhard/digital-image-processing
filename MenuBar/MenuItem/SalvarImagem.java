package MenuBar.MenuItem;

import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalvarImagem extends JMenuItem implements ActionListener{
    public SalvarImagem() {
        super("Salvar Imagem");
        super.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Salvar Imagem");
    }
}
