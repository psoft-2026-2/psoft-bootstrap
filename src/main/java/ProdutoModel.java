public class ProdutoModel {
    private String id;
    private String nomeProduto;
    private float valor;

    public ProdutoModel(String id, String nomeProduto, float valor){
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.valor = valor;
    }

    public String getId(){
        return this.id;  
    }

    public float getValor() {
        return this.valor;
    }
}
