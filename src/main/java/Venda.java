public class Venda {
    private double valor;
    private ArrayList<ItemVenda> itens;
    private Cliente cliente;
    private Pagamento pagamento;

    public Venda(Cliente cliente){
        this.itens = new ArrayList<>();
        this.cliente = cliente;
    }

    public void criaItens(int quantidade, Produto p){
        ItemVenda i = new ItemVenda(quantidade, p);
        itens.add(i);
    }

    public double calculaValor(){
        double total = 0;
        for (ItemVenda i : itens){
            total += i.calcularPreco();
        }
        return total;
    }

    public double calculaValorDesconto(){
        double total = calculaValor();
        if(cliente.getAssinatura() == Tipo.PREMIUM) {
            this.valor = total * 0.95; 
        } else {
            this.valor = total;
        }
        return valor;
    }

    public void criarPagamento(String metodo, double valor){
        this.pagamento = new Pagamento(metodo, valor);
    }

    public String getCliente(){
        return this.cliente.toString();
    }

    public double getValor(){
        return this.valor;
    }

    @Override
    public String toString(){
        return "venda do cliente: " + this.cliente.getNome();
    }
}