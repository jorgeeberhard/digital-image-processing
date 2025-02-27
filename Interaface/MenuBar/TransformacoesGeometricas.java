package Interaface.MenuBar;

import Interaface.MenuBar.MenuItem.Transladar;
import Interaface.MenuBar.MenuItem.Rotacionar;
import Interaface.MenuBar.MenuItem.Espelhar;
import Interaface.MenuBar.MenuItem.Aumentar;
import Interaface.MenuBar.MenuItem.Diminuir;


import javax.swing.*;

public class TransformacoesGeometricas extends JMenu {

    private Transladar transladar = new Transladar();
    private Rotacionar rotacionar = new Rotacionar();
    private Espelhar espelhar = new Espelhar();
    private Aumentar aumentar = new Aumentar();
    private Diminuir diminuir = new Diminuir();

    public TransformacoesGeometricas(){
        super("TRANSFORMAÇÕES GEOMÉTRICAS");
        super.add(transladar);
        super.add(rotacionar);
        super.add(espelhar);
        super.add(aumentar);
        super.add(diminuir);
    }

}
