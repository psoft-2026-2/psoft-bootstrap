import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private List<Time> times;
    private List<Funcionario> funcionarios;
    private List<Produto> produtos;
    private ProductOwner productOwner;

    public Empresa() {
        this.times = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        this.produtos = new ArrayList<>();
        this.productOwner = null;
    }
    
    public void criarTime(Gerente gerente, Desenvolvedor lider, Produto produto) {
        Time time = new Time(gerente, lider, produto);
        times.add(time);
    }

    public void cadastrarFuncionario(String nome, String cpf, String telefone, Papel papel) {
        Funcionario funcionario = new Funcionario(nome, cpf, telefone, papel);
        funcionarios.add(funcionario);
    }

    public void cadastrarProduto(String nome, String descricao) {
        Produto produto = new Produto(nome, descricao);
        produtos.add(produto);
    }

    public void sprint() {
        for (Time time: times) {
            time.tornarLider();
        }
    }

    public void tornarProductOwner(Funcionario funcionario) {
        if (funcionario.getPapel() instanceof Gerente) {
            promoverFuncionario(funcionario, new ProductOwner(funcionario.getNome()));
        }
    }

    public void setProductOwner(ProductOwner productOwner) {
        this.productOwner = productOwner;
    }

    public void promoverFuncionario(Funcionario funcionario, Papel novoPapel) {
        funcionario.setPapel(novoPapel);
    }
}
