public class Pedido {
    private Cliente cliente;
    private String enderecoOrigem;
    private String enderecoEntrega;
    private double peso;
    private double distancia;
    private boolean despachado;
    private ModalidadeEntrega modalidade;

    public Pedido(Cliente cliente, String enderecoOrigem, String enderecoEntrega,
                  double peso, double distancia, ModalidadeEntrega modalidade) {
        this.cliente = cliente;
        this.enderecoOrigem = enderecoOrigem;
        this.enderecoEntrega = enderecoEntrega;
        this.peso = peso;
        this.distancia = distancia;
        this.modalidade = modalidade;
        this.despachado = false;
    }

    public void alterarModalidade(ModalidadeEntrega nova) {
        if (despachado) {
            throw new IllegalStateException("Pedido ja despachado: nao e possivel alterar a modalidade.");
        }
        this.modalidade = nova;
    }

    public double calcularCusto() {
        return modalidade.calcularCusto(this);
    }

    public int calcularPrazo() {
        return modalidade.calcularPrazo(this);
    }

    public void despachar() {
        this.despachado = true;
    }

    public Cliente getCliente() { return cliente; }
    public String getEnderecoOrigem() { return enderecoOrigem; }
    public String getEnderecoEntrega() { return enderecoEntrega; }
    public double getPeso() { return peso; }
    public double getDistancia() { return distancia; }
    public boolean isDespachado() { return despachado; }
    public ModalidadeEntrega getModalidade() { return modalidade; }
}
