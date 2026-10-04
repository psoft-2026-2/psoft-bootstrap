import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Venda {
    private Cliente cliente;
    private List<ItemVenda> itensVenda;
    private double totalVenda;

    public Venda(Cliente cliente) {
        this.cliente = cliente;
        this.itensVenda = new ArrayList<>();
        this.totalVenda = 0.0;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        ItemVenda item = new ItemVenda(quantidade, produto);
        this.itensVenda.add(item);
        calculaTotal();
    }

    private void calculaTotal() {
        double soma = 0.0;
        for (ItemVenda item : itensVenda) {
            soma += item.getSubtotal();
        }

        if (this.cliente != null && this.cliente.getPerfil() == PerfilCliente.PREMIUM) {
            soma = soma * 0.95; // 5% de desconto adicional
        }

        this.totalVenda = soma;
    }

    public double getTotalVenda() {
        return totalVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemVenda> getItensVenda() {
        return Collections.unmodifiableList(itensVenda);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Venda)) return false;
        Venda venda = (Venda) o;
        return Objects.equals(cliente, venda.cliente) && Objects.equals(itensVenda, venda.itensVenda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cliente, itensVenda);
    }

    @Override
    public String toString() {
        return "Venda{" +
                "cliente=" + cliente.getNome() +
                ", totalVenda=" + totalVenda +
                ", qtdItens=" + itensVenda.size() +
                '}';
    }
}
