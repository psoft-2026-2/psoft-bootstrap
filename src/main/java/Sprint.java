import java.util.Date;

public class Sprint {

    private String nome;
    private Date data;
    private Produto produto;
    private Funcionario lider;

    public Sprint(String nome, Date data, Produto produto, Funcionario lider) {
        this.nome = nome;
        this.data = data;
        this.produto = produto;
        this.lider = lider;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String novo) {
        this.nome = novo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date nova) {
        this.data = nova;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto novo) {
        this.produto = novo;
    }

    public Funcionario getLider() {
        return lider;
    }

    public void setLider(Funcionario novo) {
        this.lider = novo;
    }
}
