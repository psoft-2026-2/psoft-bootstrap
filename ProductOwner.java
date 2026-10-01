import java.util.List;
import java.util.ArrayList;

public class ProductOwner implements Papel {
    private List<Produto> produtos;

    public ProductOwner() {
        this.produtos = new ArrayList<>();
    }

    public void adicionaProduto(Produto produto) {
        if (!this.produtos.contains(produto)) {
            this.produtos.add(produto);
        }
    }

    @Override
    public void realizarTrabalho() { 
        System.out.println("Supervisionando produtos"); 
    }

    @Override
    public boolean equals(Object obj) { 
        return obj != null && this.getClass() == obj.getClass(); 
    }
    
    @Override
    public int hashCode() { 
        return this.getClass().hashCode(); 
    }
}
