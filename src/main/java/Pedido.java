public class Pedido {
    private int numPedido;
    private String cpfCliente;
    private String enderecoOrigem;
    private String enderecoDestino;
    private float dist;
    private float peso;

    public Pedido(int numPedido, String cpfCliente, String enderecoOrigem, String enderecoDestino, float dist, float peso) {
        this.numPedido = numPedido;
        this.cpfCliente = cpfCliente;
        this.enderecoOrigem = enderecoOrigem;
        this.enderecoDestino = enderecoDestino;
        this.dist = dist;
        this.peso = peso;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public String getEnderecoOrigem() {
        return enderecoOrigem;
    }

    public String getEnderecoDestino() {
        return enderecoDestino;
    }

    public float getDist() {
        return dist;
    }

    public float getPeso() {
        return peso;
    }
}
