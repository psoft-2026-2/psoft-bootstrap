package model;
import java.util.Date;

public class Produto {

    private String nome;
    private int idProduto;
    private Date validade;
    private double preco;

    public Produto(int idProduto, String nome, double preco, Date validade) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.preco = preco;
        this.validade = validade;
    }

    public double getPreco() {
        return preco;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public Date getValidade() {
        return validade;
    }

    public String getNome() {
        return nome;
    }
}