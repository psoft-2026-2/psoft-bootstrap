import java.util.List;

public class Venda {
    private List<itemVenda> itens;

    public double total(){
        double total = 0;
        for (itemVenda item : itens) {
            total += item.subtotal();
        }
        return total;
    }

    public void addItem(itemVenda item){
        this.itens.add(item);
    }
}
