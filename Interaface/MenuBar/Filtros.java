package Interaface.MenuBar;

import Interaface.MenuBar.MenuItem.Grayscale;
import Interaface.MenuBar.MenuItem.PassaAlta;
import Interaface.MenuBar.MenuItem.PassaBaixa;
import Interaface.MenuBar.MenuItem.Threshold;

import javax.swing.JMenu;

public class Filtros extends JMenu {

    private Grayscale grayscale = new Grayscale();
    private PassaBaixa passaBaixa = new PassaBaixa();
    private PassaAlta passaAlta = new PassaAlta();
    private Threshold threshold = new Threshold();

    public Filtros(){
        super("FILTROS");
        super.add(grayscale);
        super.add(passaBaixa);
        super.add(passaAlta);
        super.add(threshold);
    }

}
