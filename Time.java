import java.util.ArrayList;
import java.util.List;

public class Time {
    private String nome;
    private Pessoa gerente;
    private List<Pessoa> desenvolvedores;

    public Time(String nome, Pessoa gerente) {
        this.nome = nome;
        this.gerente = gerente;
        this.desenvolvedores = new ArrayList<>();
    }

    public void adicionarDesenvolvedor(Pessoa desenvolvedor) {
        desenvolvedores.add(desenvolvedor);
    }

    public void definirGerente(Pessoa gerente) {
        this.gerente = gerente;
    }

    public void iniciarSprint(Sprint sprint) {
        sprint.executar();
    }
}