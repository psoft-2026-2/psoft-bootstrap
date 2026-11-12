public class Pedido {

    private String nome;
    private String cpf;
    private String enderecoOrigem;
    private String enderecoDestino;
    private double peso;
    private double distancia;
    private Entrega entrega;
    private boolean despachado;

    public Pedido(String nome, String cpf,
                  String enderecoOrigem, String enderecoDestino,
                  double peso, double distancia, Entrega entrega) {

        if (entrega == null) {
            throw new IllegalArgumentException("A entrega não pode ser nula.");
        }

        if (peso <= 0 || distancia <= 0) {
            throw new IllegalArgumentException("Peso e distância devem ser positivos.");
        }

        this.nome = nome;
        this.cpf = cpf;
        this.enderecoOrigem = enderecoOrigem;
        this.enderecoDestino = enderecoDestino;
        this.peso = peso;
        this.distancia = distancia;
        this.entrega = entrega;
        this.despachado = false;
    }

    public double calcularCustoEntrega() {
        return entrega.calcularCustoEntrega(distancia);
    }

    public String calcularPrazoEntrega() {
        return entrega.calcularPrazoEntrega();
    }

    public void alterarEntrega(Entrega entrega) {
        if (despachado) {
            throw new IllegalStateException(
                "Não é possível alterar a entrega após o despacho."
            );
        }

        if (entrega == null) {
            throw new IllegalArgumentException("A entrega não pode ser nula.");
        }

        this.entrega = entrega;
    }

    public void despachar() {
        if (despachado) {
            throw new IllegalStateException("O pedido já foi despachado.");
        }

        despachado = true;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEnderecoOrigem() {
        return enderecoOrigem;
    }

    public String getEnderecoDestino() {
        return enderecoDestino;
    }

    public double getPeso() {
        return peso;
    }

    public double getDistancia() {
        return distancia;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public boolean isDespachado() {
        return despachado;
    }
}