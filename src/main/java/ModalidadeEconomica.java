/** Alias para manter compatibilidade com o nome do projeto-base. */
public class ModalidadeEconomica extends EntregaEconomica implements ModalidadeEntrega {
    public ModalidadeEconomica() {
        super();
    }

    public ModalidadeEconomica(double taxaBase, double desconto) {
        super(taxaBase, desconto);
    }
}
