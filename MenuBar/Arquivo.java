package MenuBar;
import MenuBar.MenuItem.AbrirImagem;
import MenuBar.MenuItem.Sair;
import MenuBar.MenuItem.SalvarImagem;
import MenuBar.MenuItem.Sobre;

import javax.swing.*;

public class Arquivo extends JMenu {

    private AbrirImagem abrirImagem = new AbrirImagem();
    private SalvarImagem salvarImagem = new SalvarImagem();
    private Sobre sobre = new Sobre();
    private Sair sair = new Sair();

    public Arquivo(){
        super("ARQUIVO");
        super.add(abrirImagem);
        super.add(salvarImagem);
        super.add(sobre);
        super.add(sair);
    }

}
