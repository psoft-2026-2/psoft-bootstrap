import java.util.List;
import java.util.ArrayList;

public class Venda {

        private List<ItemVenda> itens;
        private Cliente cliente;
        private Pagamento pagamento;
        private boolean finalizado;

        public Venda(Cliente cliente) {
            this.cliente = cliente;
            this.itens = new ArrayList<ItemVenda>();
            this.finalizado = false;   
            this.pagamento = null;
        }

        public void addItens(Produto produto, int quantidade) {
            ItemVenda newItens = new ItemVenda(produto, quantidade);
            itens.add(newItens);   
        }

        public void addPagamento(String metodo, double valor) {
            Pagamento pagamento = new Pagamento(metodo, valor);
            this.pagamento = pagamento;
        }

        public void finalizar() {
            finalizado = true;
        }

        public double calcularTotal() {
            double subTotal = 0;

            for (ItemVenda item : this.itens) {
                subTotal += item.calcularSubTotal(); 
            }

            return subTotal * cliente.getDesconto();

        }

        public List<ItemVenda> getItens() {
            return itens;
        }

        public Cliente getCliente() {
            return cliente;
        }

        public boolean estaFinalizado() {
            return finalizado;
        }

        public Pagamento getPagamento() {
            return pagamento;
        }

}