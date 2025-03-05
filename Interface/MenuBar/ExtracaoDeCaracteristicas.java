package Interface.MenuBar;

import Interface.MainFrame;
import Interface.MenuBar.MenuItem.Desafio;

import javax.swing.JMenu;

public class ExtracaoDeCaracteristicas extends JMenu {

    public ExtracaoDeCaracteristicas(MainFrame mainFrame){
        super("EXTRAÇÃO DE CARACTERÍSTICAS");
        super.add(new Desafio(mainFrame));
    }

}
