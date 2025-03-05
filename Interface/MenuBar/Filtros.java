package Interface.MenuBar;

import Interface.MainFrame;
import Interface.MenuBar.MenuItem.Grayscale;
import Interface.MenuBar.MenuItem.PassaAlta;
import Interface.MenuBar.MenuItem.PassaBaixa;
import Interface.MenuBar.MenuItem.Threshold;

import javax.swing.JMenu;

public class Filtros extends JMenu {
    public Filtros(MainFrame mainFrame){
        super("FILTROS");
        super.add(new Grayscale(mainFrame));
        super.add(new PassaBaixa(mainFrame));
        super.add(new PassaAlta(mainFrame));
        super.add(new Threshold(mainFrame));
    }

}
