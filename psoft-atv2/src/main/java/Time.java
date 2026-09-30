import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Time {
    private String id;
    private Pessoa gerente;
    private List<Pessoa> desenvolvedores;

    public Time(String id, Pessoa gerente) {
        if (gerente.getCargoAtual() != Cargo.GERENTE) {
            throw new IllegalArgumentException("O responsável pelo time deve possuir o cargo de Gerente.");
        }
        this.id = id;
        this.gerente = gerente;
        this.desenvolvedores = new ArrayList<>();
    }

    public void adicionarDesenvolvedor(Pessoa dev) {
        if (dev.getCargoAtual() != Cargo.DESENVOLVEDOR) {
            throw new IllegalArgumentException("Apenas pessoas com cargo de Desenvolvedor podem entrar no time como dev.");
        }
        this.desenvolvedores.add(dev);
    }

    public String getId() {
        return id;
    }

    public Pessoa getGerente() {
        return gerente;
    }

    public List<Pessoa> getDesenvolvedores() {
        return Collections.unmodifiableList(desenvolvedores);
    }

}
