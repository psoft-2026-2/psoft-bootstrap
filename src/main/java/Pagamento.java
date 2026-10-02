public class Pagamento {
    private String metodo;
    public double valor;

    public Pagamento(String metodo, double valor){
        this.metodo = metodo;
        this.valor = valor;
    }

    public String getMetodo(){
        return this.metodo;
    }

    public double getValor(){
        return this.valor;
    }

    @Override
    public String toString(){
        return "pagamento de " + this.valor + "no " + this.metodo; 
    }
}