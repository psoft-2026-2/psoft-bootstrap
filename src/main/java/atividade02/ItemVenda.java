package atividade02;

import java.util.ArrayList;

public class ItemVenda {

    private int qtdProdutos;
    private ArrayList<Produto> produto = new ArrayList<>();

    public ItemVenda(Produto produto, int qtdProdutos) {
        this.produto.add(produto);
        this.qtdProdutos = qtdProdutos;
    }

    public float calculaSubtotal(float preco) {
        float subtotal = preco * qtdProdutos;
        if (calculaDescontoQtd()) {
            subtotal = subtotal * 0.9f;
        }
        return subtotal;
    }

    public int getQtdProdutos() {
        return qtdProdutos;
    }

    public boolean calculaDescontoQtd() {
        return qtdProdutos >= 20;
    }

    public ArrayList<Produto> getProduto() {
        return produto;
    }
}