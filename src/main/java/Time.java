import java.util.*;

public class Time {
    private Produto produto;
    private String nome;
    private Funcionario liderTemporario;
    private List<Funcionario> desenvolvedores;

    public Time(String nome, Produto produto, Funcionario liderTemporario) {
        this.nome = nome;
        this.produto = produto;
        this.liderTemporario = liderTemporario;
        this.desenvolvedores = new ArrayList<>();
    }

    public void addDesenvolvedor(Funcionario desenvolvedor) {
        if (desenvolvedor.getPapel() instanceof Desenvolvedor) {
            desenvolvedores.add(desenvolvedor);
        }
    }

    public String listaDesenvolvedores() {
        StringBuilder sb = new StringBuilder();
        for (Funcionario f : desenvolvedores) {
            sb.append(f.toString()).append("\n");
        }
        return sb.toString();
    }

    public String getNome() {
        return nome;
    }

    public Produto getProduto() {
        return produto;
    }

    public Funcionario getLiderTemporario() {
        return liderTemporario;
    }

    public void setLiderTemporario(Funcionario liderTemporario) {
        this.liderTemporario = liderTemporario;
    }

}
