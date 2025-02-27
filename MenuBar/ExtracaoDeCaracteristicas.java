package MenuBar;

import MenuBar.MenuItem.Desafio;

import javax.swing.JMenu;

public class ExtracaoDeCaracteristicas extends JMenu {

    public ExtracaoDeCaracteristicas(){
        super("EXTRAÇÃO DE CARACTERÍSTICAS");
        super.add(new Desafio());
    }

}
