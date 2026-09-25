public class Produto {
    private int estoque;
    private final String nome;
    private final double preço;

    public double getPreço() {
        return this.preço;
    }

    public String getNome() {
        return this.nome;
    }

    public int getEstoque(){
        return estoque;
    }

    public void setQnt(int qnt){
        this.estoque = qnt;
    }

    public Produto(int qnt, String nome, double preço) {
        this.estoque = qnt;
        this.nome = nome;
        this.preço = preço;
    }
    
}
