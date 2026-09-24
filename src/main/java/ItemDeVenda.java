/**
 * ItemDeVenda
 */
public class ItemDeVenda {
    private  Item item;
    private int quantidade;
    
    public ItemDeVenda(Item item, int quantidade) {
        this.item = item;
        this.quantidade = quantidade;
    } 

    public Double subTotal(){
        Double out = this.item.getValorUnitario() * quantidade; 

        if (this.quantidade >= 20) {
            out *= 0.90; 
        }
        return out; 
    }

    public Item getItem() {
        return item;
    }

    public int getQuantidade() {
        return quantidade;
    }
    

    

}
