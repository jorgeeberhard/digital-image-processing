package Interface.MenuBar;

import Interface.MainFrame;

import javax.swing.*;

public class MenuBar extends JMenuBar {
    public MenuBar(MainFrame mainFrame) {
        super();
        super.add(new Arquivo(mainFrame));
        super.add(new TransformacoesGeometricas(mainFrame));
        super.add(new Filtros(mainFrame));
        super.add(new MorfologiaMatematica(mainFrame));
        super.add(new ExtracaoDeCaracteristicas(mainFrame));
    }
}
