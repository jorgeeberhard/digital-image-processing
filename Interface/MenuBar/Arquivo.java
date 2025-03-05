package Interface.MenuBar;
import Interface.MainFrame;
import Interface.MenuBar.MenuItem.AbrirImagem;
import Interface.MenuBar.MenuItem.Sair;
import Interface.MenuBar.MenuItem.SalvarImagem;
import Interface.MenuBar.MenuItem.Sobre;

import javax.swing.*;

public class Arquivo extends JMenu {


    public Arquivo(MainFrame mainFrame){
        super("ARQUIVO");
        super.add(new AbrirImagem(mainFrame));
        super.add(new SalvarImagem(mainFrame));
        super.add(new Sobre(mainFrame));
        super.add(new Sair(mainFrame));
    }

}
