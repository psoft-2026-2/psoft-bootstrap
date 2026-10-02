package sprint;

import java.util.ArrayList;
import java.util.List;

public class Time {
    private String id;
    private String nome;
    private List<Funcionario> desenvolvedores;
    private Funcionario gerente;
    private Funcionario liderAtual;

    public Time(String id, String nome) {
        this.id = id;
        this.nome = nome;
        this.desenvolvedores = new ArrayList<>();
    }

    public void adicionarDesenvolvedor(Funcionario dev) {
        desenvolvedores.add(dev);
    }

    public void definirGerente(Funcionario gerente) {
        this.gerente = gerente;
    }

    public void definirLider(Funcionario lider) {
        if (this.liderAtual != null) {
            this.liderAtual.encerrarLiderancaSprint();
        }
        this.liderAtual = lider;
        this.liderAtual.assumirLiderancaSprint();
    }

    public String getNome() { return nome; }
    public Funcionario getLiderAtual() { return liderAtual; }
    public List<Funcionario> getDesenvolvedores() { return desenvolvedores; }
}
