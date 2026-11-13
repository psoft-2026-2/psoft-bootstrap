public class Pedido {
    private final Cliente cliente;
    private final String origem;
    private final String destino;
    private final float peso;
    private final float distancia;
    private float frete;
    private int prazoEstimado;
    private boolean despachado;
    private Entrega tipoEntrega;

    public Pedido(Cliente cliente, String origem, String destino, float peso, float distancia) {
        if (cliente == null) throw new IllegalArgumentException("cliente nao pode ser nulo");
        this.cliente = cliente;
        this.origem = textoValido(origem, "origem");
        this.destino = textoValido(destino, "destino");
        if (!Float.isFinite(peso) || peso <= 0) throw new IllegalArgumentException("peso deve ser finito e maior que zero");
        if (!Float.isFinite(distancia) || distancia < 0) throw new IllegalArgumentException("distancia deve ser finita e nao negativa");
        this.peso = peso;
        this.distancia = distancia;
    }

    private static String textoValido(String valor, String nome) {
        if (valor == null || valor.isBlank()) throw new IllegalArgumentException(nome + " nao pode ser vazio");
        return valor;
    }

    public float calcularFrete() {
        exigirEntrega();
        frete = tipoEntrega.calcularFrete(this);
        return frete;
    }

    public int calcularPrazo() {
        exigirEntrega();
        prazoEstimado = tipoEntrega.calcularPrazo(this);
        return prazoEstimado;
    }

    public void alterarModalidade(Entrega novaEntrega) {
        if (novaEntrega == null) throw new IllegalArgumentException("entrega nao pode ser nula");
        if (despachado) throw new IllegalStateException("nao e possivel alterar a modalidade apos o despacho");
        tipoEntrega = novaEntrega;
    }

    public void despachar() {
        exigirEntrega();
        if (despachado) throw new IllegalStateException("pedido ja foi despachado");
        despachado = true;
    }

    private void exigirEntrega() {
        if (tipoEntrega == null) throw new IllegalStateException("pedido nao possui modalidade de entrega");
    }

    public Cliente getCliente() { return cliente; }
    public String getOrigem() { return origem; }
    public String getDestino() { return destino; }
    public float getPeso() { return peso; }
    public float getDistancia() { return distancia; }
    public float getFrete() { return frete; }
    public int getPrazoEstimado() { return prazoEstimado; }
    public boolean isDespachado() { return despachado; }
    public Entrega getTipoEntrega() { return tipoEntrega; }
}
