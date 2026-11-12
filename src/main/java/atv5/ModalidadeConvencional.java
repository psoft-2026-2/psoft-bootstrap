package atv5;

public class ModalidadeConvencional implements Modalidade {
    
    private double tarifa;
    private double valor;
    private double preco;
    private int prazo;

    public ModalidadeConvencional(double tarifaFixa, double valorPorKm, int prazoBase) {
        this.tarifa = tarifaFixa;
        this.valor = valorPorKm;
        this.prazo = prazoBase;
    }

    @Override
    public double calcularCusto(Pedido pedido) {
        this.preco = tarifa + (valor * pedido.getDistancia());
        return this.preco;
    }

    @Override
    public int estimarPrazo(Pedido pedido) {
        this.prazo = this.prazo + (int) Math.ceil(pedido.getDistancia() / 200.0);
        return this.prazo;
    }

    public double getPreco() { 
        return preco; 
    }
    public int getPrazo() { 
        return prazo; 
    }
}
