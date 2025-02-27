package MenuBar;

import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar {
    public MenuBar() {
        super();
        super.add(new Arquivo());
        super.add(new TransformacoesGeometricas());
        super.add(new Filtros());
        super.add(new MorfologiaMatematica());
        super.add(new ExtracaoDeCaracteristicas());
    }
}
