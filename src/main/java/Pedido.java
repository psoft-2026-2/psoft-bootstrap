public class Pedido {
    private Integer id;
    private String nomeCliente;
    private Endereco origem;
    private Endereco destino;
    private double peso;
    private double distanciakm;
    private Entrega modalidade;
    private boolean estado;

    public Pedido(Integer id, String nomeCliente, Endereco origem, Endereco destino, double peso, double distanciakm,
            boolean estado) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
        this.distanciakm = distanciakm;
        this.estado = estado;
    }

    public Endereco getOrigem() {
        return origem;
    }

    public void setOrigem(Endereco origem) {
        this.origem = origem;
    }

    public Endereco getDestino() {
        return destino;
    }

    public void setDestino(Endereco destino) {
        this.destino = destino;
    }

    public Entrega getModalidade() {
        return modalidade;
    }

    public void setModalidade(Entrega modalidade) {
        this.modalidade = modalidade;
    }

    public void setModalidadeEconomica(double distanciakm) {
        this.modalidade = new EntregaEconomica(distanciakm);
    }

    public void setModalidadeExpressa(int prioridade, double distanciakm) {
        this.modalidade = new EntregaExpressa(prioridade, distanciakm);
    }

    public void setModalidadeConvencional(double tarifa, double distanciakm) {
        this.modalidade = new EntregaConvencional(tarifa, distanciakm);
    }

    public boolean getEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getPrazo() {
        if (this.modalidade == null) {
            return "Sem modalidade definida";
        }
        return modalidade.calculaPrazo();
    }

    public double getPreco() {
        if (this.modalidade == null) {
            return 0.0;
        }
        return modalidade.calculaCusto();
    }

    public Integer getId() {
        return id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public double getDistanciakm() {
        return distanciakm;
    }

    public void setDistanciakm(double distanciakm) {
        this.distanciakm = distanciakm;
    }

}