package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venda {

    private static int contadorId = 1;
    private static int contadorPagamento = 1;

    private int idVenda;
    private Cliente cliente;
    private List<ItemVenda> itens;
    private Date dataVenda;
    private Pagamento pagamento;

    public Venda(Cliente cliente) {
        this.idVenda = contadorId++;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.dataVenda = new Date();
    }

    public void adicionarItem(Produto produto, int quantidade) {
        ItemVenda item = new ItemVenda(produto, quantidade);
        itens.add(item);
    }

    public double calcularTotal() {
        double totalItens = 0.0;
        for (ItemVenda item : itens) {
            totalItens += item.calcularSubtotal();
        }
        double descontoCliente = cliente.getDesconto();
        return totalItens - (totalItens * descontoCliente);
    }

    public boolean temDesconto() {
        if (cliente.getDesconto() > 0) {
            return true;
        }
        for (ItemVenda item : itens) {
            if (item.temDesconto()) {
                return true;
            }
        }
        return false;
    }

    public Pagamento gerarPagamento(double valorRecebido) {
        this.pagamento = new Pagamento(contadorPagamento++, calcularTotal(), valorRecebido);
        return this.pagamento;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }
}   
