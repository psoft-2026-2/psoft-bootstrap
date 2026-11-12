package atv5;

public class ModalidadeEconomica implements Modalidade {
    private double preco;
    private int prazo;

    public ModalidadeEconomica(double precoBase, int prazo) {
        this.preco = precoBase;
        this.prazo = prazo;
    }

    @Override
    public double calcularCusto(Pedido pedido) {
        return this.preco + (pedido.getDistancia() * 0.20);
    }

    @Override
    public int estimarPrazo(Pedido pedido) {
        return this.prazo + (int) Math.ceil(pedido.getDistancia() / 100.0);
    }

    public double getPreco() { 
        return preco; 
    }
    public int getPrazo() { 
        return prazo; 
    }
}