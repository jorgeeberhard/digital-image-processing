package Interface.MenuBar;

import Interface.MainFrame;
import Interface.MenuBar.MenuItem.Transladar;
import Interface.MenuBar.MenuItem.Rotacionar;
import Interface.MenuBar.MenuItem.Espelhar;
import Interface.MenuBar.MenuItem.Aumentar;
import Interface.MenuBar.MenuItem.Diminuir;


import javax.swing.*;

public class TransformacoesGeometricas extends JMenu {


    public TransformacoesGeometricas(MainFrame mainFrame){
        super("TRANSFORMAÇÕES GEOMÉTRICAS");
        super.add(new Transladar(mainFrame));
        super.add(new Rotacionar(mainFrame));
        super.add(new Espelhar(mainFrame));
        super.add(new Aumentar(mainFrame));
        super.add(new Diminuir(mainFrame));
    }


}
