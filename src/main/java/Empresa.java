import java.util.List;

public class Empresa {
    private String nome;
    private String cnpj;
    private List<Time> times;
    private List<Funcionario> funcionarios;
    private List<Produto> produtos;
    private Funcionario productOwner;

    public Empresa(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public List<Time> getTimes() {
        return times;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void adicionaFuncionario(String nome, String cpf, String telefone) {
        Funcionario func = new Funcionario(nome, cpf, telefone);
        funcionarios.add(func);
    }

    public void adicionaTime(Produto produto, Funcionario gerente) {
        Time time = new Time(produto, gerente);
        times.add(time);
    }

    public void adicionaProd(String nome, String id) {
        Produto produto = new Produto(nome, id);
        produtos.add(produto);
    }

    public boolean removeFuncionario(String cpf) {
        for(Funcionario f: funcionarios){
            if(f.getCpf().equals(cpf)){
                funcionarios.remove(f);
                return true;
            }
        }
        return false;
    }

    public void defineProductOwner(Funcionario po) {
        this.productOwner = po;
    }
}