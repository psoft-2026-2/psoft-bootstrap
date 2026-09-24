/**
 * Item
 */
public class Item {

    private String nomeItem; 
    private Double valorUnitario;
    
    public Item(String nomeItem, Double valorUnitario) {
        this.nomeItem = nomeItem;
        this.valorUnitario = valorUnitario;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    
    

}
