import java.util.Objects;

public class Entrega {
    private final Pedido pedido;
    private Modalidade modalidade;
    private int custo;
    private int prazo;
    private boolean despachada;

    public Entrega(Pedido pedido, Modalidade modalidade, int custo, int prazo) {
        this.pedido = Objects.requireNonNull(pedido, "Pedido obrigatório.");
        this.modalidade = Objects.requireNonNull(modalidade, "Modalidade obrigatória.");
        if (custo < 0 || prazo <= 0) throw new IllegalArgumentException("Custo ou prazo inválido.");
        this.custo = custo;
        this.prazo = prazo;
    }

    public Pedido getPedido() { return pedido; }
    public Modalidade getModalidade() { return modalidade; }
    public int getCusto() { return custo; }
    public int getPrazo() { return prazo; }
    public boolean isDespachada() { return despachada; }

    public void alterarModalidade(Modalidade modalidade) {
        if (despachada) throw new IllegalStateException("Entrega já despachada.");
        Objects.requireNonNull(modalidade, "Modalidade obrigatória.");
        int novoCusto = modalidade.custo(pedido);
        int novoPrazo = modalidade.prazo(pedido);
        if (novoCusto < 0 || novoPrazo <= 0) throw new IllegalArgumentException("Custo ou prazo inválido.");
        this.modalidade = modalidade;
        this.custo = novoCusto;
        this.prazo = novoPrazo;
    }

    public void despachar() {
        if (despachada) throw new IllegalStateException("Entrega já despachada.");
        despachada = true;
    }
}
