package java;

public class EntregaModalidade {
    private Modalidade modalidade;

    public EntregaModalidade(Modalidade modalidade) {
        setModalidade(modalidade);
    }

    public void setModalidade(Modalidade modalidade) {
        if (modalidade == null) {
            throw new IllegalArgumentException("A modalidade nao pode ser nula.");
        }
        this.modalidade = modalidade;
    }

    public double calcularCusto(Pedido pedido) {
        return modalidade.calcularCusto(pedido);
    }

    public int calcularPrazo(Pedido pedido) {
        return modalidade.calcularPrazo(pedido);
    }
}
