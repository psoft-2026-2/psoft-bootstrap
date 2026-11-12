package atv5;

public class ModalidadeExpressa implements Modalidade {
    private double preco;
    private double prioridade;
    private int prazo;

    public ModalidadeExpressa(double precoBase, double prioridade, int prazo) {
        this.preco = precoBase;
        this.prioridade = prioridade;
        this.prazo = prazo;
    }

    @Override
    public double calcularCusto(Pedido pedido) {
        return this.preco + this.prioridade + (pedido.getDistancia() * 0.40);
    }

    @Override
    public int estimarPrazo(Pedido pedido) {
        return this.prazo;
    }

    public double getPreco() { 
        return preco; 
    }
    public double getPrioridade() { 
        return prioridade; 
    }
    public int getPrazo() { 
        return prazo; 
    }
}

