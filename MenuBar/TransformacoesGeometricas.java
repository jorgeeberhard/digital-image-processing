package MenuBar;

import MenuBar.MenuItem.Transladar;
import MenuBar.MenuItem.Rotacionar;
import MenuBar.MenuItem.Espelhar;
import MenuBar.MenuItem.Aumentar;
import MenuBar.MenuItem.Diminuir;


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
