package MenuBar;

import MenuBar.MenuItem.Abertura;
import MenuBar.MenuItem.Dilatacao;
import MenuBar.MenuItem.Erosao;
import MenuBar.MenuItem.Fechamento;

import javax.swing.JMenu;

public class MorfologiaMatematica extends JMenu {

    private Dilatacao dilatacao = new Dilatacao();
    private Erosao erosao = new Erosao();
    private Abertura abertura = new Abertura();
    private Fechamento fechamento = new Fechamento();

    public MorfologiaMatematica(){
        super("MORFOLOGIA MATEMÁTICA");
        super.add(dilatacao);
        super.add(erosao);
        super.add(abertura);
        super.add(fechamento);
    }

}
