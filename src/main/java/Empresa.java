import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Empresa {
    private String nome;
    private String cnpj;
    private HashMap<String, Funcionario> funcionarios;
    private List<Sprint> sprints;
    private List<Produto> produtos;

    public Empresa(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.funcionarios = new HashMap<>();
        this.sprints = new ArrayList<>();
        this.produtos = new ArrayList<>();
    }

    public void criarFuncionario(String codigo, Funcionario funcionario) {
        funcionarios.put(codigo, funcionario);
    }

    public void criarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void criarSprint(Sprint sprint) {
        sprints.add(sprint);
    }

    public void promover(String codigoFuncionario) {
        Funcionario funcionario = funcionarios.get(codigoFuncionario);
        if (funcionario != null) {
            int participacoes = funcionario.getNumeroParticipacoes();
            // Promoção ocorre a cada sprint
            if (participacoes > 0 && participacoes % sprints.size() == 0) {
                funcionario.promover();
            }
        }
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public HashMap<String, Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public List<Sprint> getSprints() {
        return sprints;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
