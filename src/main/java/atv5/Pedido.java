package atv5;

public class Pedido {

    private int idPedido;
    private int idCliente;
    private Endereco enderecoIni;
    private Endereco enderecoFim;
    private double peso;
    private double distancia;
    private Modalidade modalidade;

    // esqueci de colocar na modelagem
    private boolean despachado;

    public Pedido(int idPedido, int idCliente, Endereco enderecoOrigem, Endereco enderecoDestino,
                  double peso, double distancia, Modalidade modalidade) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.enderecoIni = enderecoOrigem;
        this.enderecoFim = enderecoDestino;
        this.peso = peso;
        this.distancia = distancia;
        this.modalidade = modalidade;
        this.despachado = false;
    }

    public void setModalidade(Modalidade novaModalidade) {
        if (despachado) {
            throw new IllegalStateException("Não é possível alterar a modalidade após o pedido ser despachado.");
        }
        this.modalidade = novaModalidade;
    }

    // esqueci de colocar na modelagem
    public void despachar() {
        this.despachado = true;
    }

    public double calcularCustoEntrega() {
        return modalidade.calcularCusto(this);
    }

    public int estimarPrazoEntrega() {
        return modalidade.estimarPrazo(this);
    }

    public int getIdPedido() { 
        return idPedido; 
    }
    public int getIdCliente() { 
        return idCliente; 
    }
    public Endereco getEnderecoOrigem() { 
        return enderecoIni; 
    }
    public Endereco getEnderecoDestino() { 
        return enderecoFim; 
    }
    public double getPeso() { 
        return peso; 
    }
    public double getDistancia() { 
        return distancia; 
    }
    public Modalidade getModalidade() { 
        return modalidade; 
    }
    // esqueci de colocar na modelagem
    public boolean isDespachado() { 
        return despachado; 
    }
}
