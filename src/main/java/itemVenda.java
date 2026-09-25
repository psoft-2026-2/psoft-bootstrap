public class itemVenda {
    private int quantidade;
    private Produto produto;

    public double subtotal(){
        if (quantidade >= 20){
            return (quantidade * produto.getPreço())* 0.80;
        }
        return quantidade * produto.getPreço();
    }
}   
