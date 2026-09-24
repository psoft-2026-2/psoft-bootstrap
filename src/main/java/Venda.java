import java.util.List;

public class Venda {
    private Pagamento pagamento;
    private Cliente cliente;
    private List<ItemVenda> items;
    private boolean finalizado;

    public Venda(Pagamento pagamento, Cliente cliente, List<ItemVenda> itens) {
        this.pagamento = pagamento;
        this.cliente = cliente;
        this.items = items;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public double calculaValorIni(){
        int cont = 0;
        for(ItemVenda item : items){
            cont += item.CalculaVal();
        }
        return cont;
    }

    public double calculaValorFim(){
        double val = calculaValorIni();
        if(cliente.getPapel() == Papel.PREMIUM){
            val -= val * 0.05;
        }
            return val;
    }

    public void criarItemVenda(Produto produto, int quantidade){
        ItemVenda ivenda = new ItemVenda(produto, quantidade);
        items.add(ivenda);
    }
}
