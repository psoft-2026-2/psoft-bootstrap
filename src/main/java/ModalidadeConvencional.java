public class ModalidadeConvencional extends EntregaConvencional implements ModalidadeEntrega {
    public ModalidadeConvencional() {
        super();
    }

    public ModalidadeConvencional(double taxaFixa, double valorPorKm) {
        super(taxaFixa, valorPorKm);
    }
}
