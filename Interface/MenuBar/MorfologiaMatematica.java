package Interface.MenuBar;

import Interface.MainFrame;
import Interface.MenuBar.MenuItem.Abertura;
import Interface.MenuBar.MenuItem.Dilatacao;
import Interface.MenuBar.MenuItem.Erosao;
import Interface.MenuBar.MenuItem.Fechamento;

import javax.swing.JMenu;

public class MorfologiaMatematica extends JMenu {
    public MorfologiaMatematica(MainFrame mainFrame){
        super("MORFOLOGIA MATEMÁTICA");
        super.add(new Dilatacao(mainFrame));
        super.add(new Erosao(mainFrame));
        super.add(new Abertura(mainFrame));
        super.add(new Fechamento(mainFrame));
    }

}
