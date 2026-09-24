import java.util.List;

public class Venda {
    private List<Produto> itens;

    public int total(){
        for (Produto item : itens) {
            
        }
        return 0;
    }

    public void addItem(Produto produto){
        this.itens.add(produto);
        
    }
}
