/** Alias para manter compatibilidade com o nome do projeto-base. */
public class ModalidadeExpressa extends EntregaExpressa implements ModalidadeEntrega {
    public ModalidadeExpressa() {
        super();
    }

    public ModalidadeExpressa(double taxaBase, double taxaPrioridade) {
        super(taxaBase, taxaPrioridade);
    }
}
