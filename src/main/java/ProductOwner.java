import java.util.ArrayList;
import java.util.List;

public class ProductOwner implements Papel {

    private String nome;
    private List<Produto> produtos;
    
    public ProductOwner(String nome) {
        this.nome = nome;
        this.produtos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    @Override
    public void executarTarefa() {
        System.out.println("Product Owner executando tarefa.");
    }
    
}
