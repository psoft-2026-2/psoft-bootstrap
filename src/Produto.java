/**
 * Produto
 */
public class Produto {
    private String id;
    private String nome;
    private Double preco;

    public Produto(String id, String nome, Double preco){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public boolean temDescontoQuantidade(int quantidade){
        return quantidade >= 20;
    }

    public double calcDescontoQuantidade(int quantidade){
        Double guarda_preco = preco;
        if(temDescontoQuantidade(quantidade)){
            guarda_preco = this.preco * 0.90;
        }
        return guarda_preco; 
    }

    public String getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public Double getPreco(){
        return preco;
    }

    public int calcularPrecoUnitarioComDesconto(int quantidade) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularPrecoUnitarioComDesconto'");
    }
}
