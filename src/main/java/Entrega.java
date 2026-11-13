import java.util.Objects;

public final class Entrega {
    private ModalidadeEntrega modalidade;
    private boolean despachada;

    public Entrega(ModalidadeEntrega modalidade) {
        this.modalidade = Objects.requireNonNull(modalidade);
    }

    public void alterarModalidade(ModalidadeEntrega modalidade) {
        if (despachada) {
            throw new IllegalStateException("Não é possível alterar a modalidade após o despacho");
        }
        this.modalidade = Objects.requireNonNull(modalidade);
    }

    public double calcularCusto(Pedido pedido) {
        return modalidade.calcularCusto(pedido);
    }

    public int calcularPrazo(Pedido pedido) {
        return modalidade.calcularPrazo(pedido);
    }

    public void despachar() {
        despachada = true;
    }

    public boolean isDespachada() {
        return despachada;
    }
}
