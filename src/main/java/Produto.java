public class Produto{

    private String descricao;
    private double valor;

    public Produto(String descricao, double valor){
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public double getValor(){
        return this.valor;
    }

    public void setDescricao(String nova){
        this.descricao = nova; 
    }     
         
    public void setValor(double novo){
        this.valor = novo;   
    }   
}
