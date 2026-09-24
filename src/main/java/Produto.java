public class Produto {
    
    private double valor;
    private String id;

    public Produto(double valor, String id) {
        if (valor < 0) {
            throw new IllegalArgumentException("Erro: Valor negativo!");
        }
    
        this.valor = valor;
        this.id = id;
    }

    public double getValor() {
        return this.valor;
    }

}