package mercado;

import java.util.Objects;

public class Produto {

    private String nome;
    private String codigoProduto;
    private String descricao;
    private double preco;

    public Produto(String nome, String codigoProduto, String descricao, double preco) {
        this.nome = nome;
        this.codigoProduto = codigoProduto;
        this.preco = preco;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double newPreco) throws IllegalArgumentException {
        this.preco = newPreco;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Produto outro = (Produto) obj;
        return Objects.equals(this.codigoProduto, outro.codigoProduto);
    }

}
