public class Pedido {

    private String enderecoOrigem;
    private String enderecoChegada;
    private double peso;
    private int distancia;
    private boolean despachado;
    private ModalidadeEntrega modalidade;
    private String nomeProduto;
    private String clienteCPF;

    public Pedido(String cpfCliente, String item, String saida, String destino) {
        this.clienteCPF = cpfCliente;
        this.nomeProduto = item;
        this.enderecoOrigem = saida;
        this.enderecoChegada = destino;
        this.despachado = false;
    }

    public void setModalidade(ModalidadeEntrega modalidade) {
        this.modalidade = modalidade;
    }

    public void setDespachar(boolean despachado) {
        this.despachado = despachado;
    }

    public double calcularFrete() {
        if (modalidade == null) {
            throw new IllegalStateException("Pedido sem modalidade de entrega definida");
        }
        return modalidade.calcularCusto();
    }
}
