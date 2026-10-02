package br.edu.ufcg.psoft.mercado;

import java.util.ArrayList;
import java.util.List;

public class Venda {

    private Cliente cliente;
    private List<ItemVenda> itens;

    public Venda(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void adicionarItemVenda(Produto produto, int quantidade) {
        itens.add(new ItemVenda(produto, quantidade));
    }

    public double total() {
        double total = 0;
        for (ItemVenda item : itens) {
            total += item.getSubTotal();
        }
        double totalVenda = total - total * cliente.getDescontoAssinatura();
        return totalVenda;
    }
}