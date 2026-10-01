import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Time {
    private List<Funcionario> desenvolvedores;
    private Funcionario gerente;
    private Produto produto;

    public Time(Produto produto) {
        this.produto = produto;
        this.desenvolvedores = new ArrayList<>();
    }

    public void definirGerente(Funcionario gerente) {
        this.gerente = gerente;
    }

    public void adicionarDesenvolvedor(Funcionario dev) {
        this.desenvolvedores.add(dev);
    }
}