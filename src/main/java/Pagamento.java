package main.java;
public class Pagamento {

    private double valor;

    public Pagamento(double valor) {
        this.valor = valor;
    }

    public boolean processar() {
        return valor > 0;
    }

    public double getValor() {
        return valor;
    }
}