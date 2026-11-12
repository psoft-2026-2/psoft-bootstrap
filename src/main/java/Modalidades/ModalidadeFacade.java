package Modalidades;
/**
 * ModalidadeFacade
 */
public class ModalidadeFacade {

    private Modalidade modalidade;

    public ModalidadeFacade() {
        this.modalidade = new ModalidadeConvencional();
    }

    public void setModalidadeConvencional() {
        this.modalidade = new ModalidadeConvencional();
    }

    public void setModalidadeExpressa() {
        this.modalidade = new ModalidadeExpressa();
    }

    public void setModalidadeEconomica() {
        this.modalidade = new ModalidadeEconomica();
    }

    public Modalidade getModalidade() {
        return this.modalidade;
    }

}
