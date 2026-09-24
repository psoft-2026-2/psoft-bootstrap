public class VendaProduto {
    private int quantidade;
    private Produto produto;

    public void items(){
        
    }

    public double subtotal(){
        return quantidade * produto.getPreço();
    }
}   
