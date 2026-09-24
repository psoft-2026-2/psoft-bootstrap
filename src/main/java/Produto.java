public class Produto{
    private double preco;
    private String nome;


    public Produto(double preco, String nome){
        this.nome = nome;
        this.preco = preco;
    }

    public double getPreco(){
        return this.preco;
    }

    public String getNome(){
        return this.nome;
    }

    public void setPreco(double p){
        this.preco = p;
    }

    @Override
    public String toString(){
        return this.nome;
    }
}