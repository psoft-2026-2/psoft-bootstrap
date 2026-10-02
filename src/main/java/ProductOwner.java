public class ProductOwner implements Papel{
    private int nivel;
    
    public ProductOwner(){
        this.nivel = 1;
    }

    public String toString(){
        return "PRODUCTOWNER";
    }

    public int getNivel() {
        return nivel;
    }
}
