public class Produto {
    private int qnt;
    private final String  nome;
    private double preço;

    public double getPreço() {
        return this.preço;
    }

    public String getNome() {
        return this.nome;
    }

    public void setQnt(int qnt){
        this.qnt = qnt;
    }

    public Produto(int qnt, String nome, double preço) {
        this.qnt = qnt;
        this.nome = nome;
        this.preço = preço;
    }
    
}
