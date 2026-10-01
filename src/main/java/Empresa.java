import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nome;
    private String cnpj;
    private List<Contato> contatos;
    private Funcionario productOwner;
    private List<Time> times;

    public Empresa(String nome, String cnpj,
                   Funcionario productOwner) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.productOwner = productOwner;
        this.contatos = new ArrayList<>();
        this.times = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Funcionario getProductOwner() {
        return productOwner;
    }

    public List<Contato> getContatos() {
        return new ArrayList<>(contatos);
    }

    public List<Time> getTimes() {
        return new ArrayList<>(times);
    }

    public void setProductOwner(Funcionario productOwner) {
        if (productOwner == null ||
            !productOwner.temFuncao(ProductOwner.class)) {
            throw new IllegalArgumentException(
                "O funcionário precisa ser Product Owner"
            );
        }

        this.productOwner = productOwner;
    }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }

    public void adicionarTime(Time time) {
        times.add(time);
    }

    public void promoverGerenteParaProductOwner(
        Funcionario gerenteAtual,
        Time time,
        Funcionario novoGerente) {
        
        if (productOwner != null && productOwner != gerenteAtual) {
            productOwner.removerFuncao(ProductOwner.class);
}
        if (time.getGerente() != gerenteAtual) {
            throw new IllegalArgumentException(
                "O funcionário não é o gerente deste time"
            );
        }

        if (!novoGerente.temFuncao(Desenvolvedor.class)
                || !time.getDesenvolvedores().contains(novoGerente)) {
            throw new IllegalArgumentException(
                "O substituto deve ser desenvolvedor deste time"
            );
        }

        // O novo gerente assume a responsabilidade pelo time.
        time.promoverDesenvolvedorParaGerente(novoGerente);

        // O gerente anterior passa a ser Product Owner.
        gerenteAtual.promoverParaProductOwner();
        this.productOwner = gerenteAtual;
    }
}