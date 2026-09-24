public class Produto {
    private String nome;
    private int idProduto;
    private double preco;
    
    public Produto(String nome, int idProduto, double preco) {
        this.nome = nome;
        this.idProduto = idProduto;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto [nome=" + nome + ", idProduto=" + idProduto + ", preco=" + preco + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idProduto;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Produto other = (Produto) obj;
        if (idProduto != other.idProduto)
            return false;
        return true;
    }
}