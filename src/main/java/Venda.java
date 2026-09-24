import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Venda {
    private final String idVenda;
    private final Cliente cliente;
    private final List<ItemDeVenda> itens;

    public Venda(String idVenda, Cliente cliente) {
        if (idVenda == null || idVenda.trim().isEmpty()) {
            throw new IllegalArgumentException("id da venda invalido");
        }
        if (cliente == null) {
            throw new IllegalArgumentException("cliente invalido");
        }

        this.idVenda = idVenda.trim();
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public String getIdVenda() {
        return idVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void AdicionaItem(ItemDeVenda item) {
        if (item == null) {
            throw new IllegalArgumentException("item invalido");
        }
        itens.add(item);
    }

    public List<ItemDeVenda> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public double CalculaPrecoBruto() {
        double total = 0.0;

        for (ItemDeVenda item : itens) {
            total += item.CalculaPrecoBruto();
        }

        return total;
    }

    public double CalculaPrecoFinal() {
        double totalComDescontoDosItens = 0.0;

        for (ItemDeVenda item : itens) {
            totalComDescontoDosItens += item.CalculaPreco();
        }

        return totalComDescontoDosItens * (1.0 - cliente.CalculaDescontoAssinatura());
    }
}
