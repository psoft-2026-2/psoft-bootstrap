public class Pagamento {
    private double valTotal;
    private String metodo;

    Pagamento(double valTotal, String metodo){
        this.valTotal = valTotal;
        this.metodo = metodo;
    }

    public double getValTotal(){
        return valTotal;
    }

    public String getMetodo(){
        return metodo;
    }

}
