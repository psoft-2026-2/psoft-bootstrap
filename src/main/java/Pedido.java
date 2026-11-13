public class Pedido {
    private String infoCliente;
    private String origem;
    private String destino;
    private int peso;
    private int distancia;
    private int prioridade;

    public Pedido(String infoCliente, String origem, String destino, int peso,
                  int distancia, int prioridade) {
        setInfoCliente(infoCliente);
        setOrigem(origem);
        setDestino(destino);
        setPeso(peso);
        setDistancia(distancia);
        setPrioridade(prioridade);
    }

    public String getInfoCliente() { return infoCliente; }
    public String getOrigem() { return origem; }
    public String getDestino() { return destino; }
    public int getPeso() { return peso; }
    public int getDistancia() { return distancia; }
    public int getPrioridade() { return prioridade; }

    public void setInfoCliente(String infoCliente) {
        validarTexto(infoCliente);
        this.infoCliente = infoCliente;
    }

    public void setOrigem(String origem) {
        validarTexto(origem);
        this.origem = origem;
    }

    public void setDestino(String destino) {
        validarTexto(destino);
        this.destino = destino;
    }

    public void setPeso(int peso) {
        if (peso <= 0) throw new IllegalArgumentException("Peso deve ser positivo.");
        this.peso = peso;
    }

    public void setDistancia(int distancia) {
        if (distancia < 0) throw new IllegalArgumentException("Distância não pode ser negativa.");
        this.distancia = distancia;
    }

    public void setPrioridade(int prioridade) {
        if (prioridade < 0) throw new IllegalArgumentException("Prioridade não pode ser negativa.");
        this.prioridade = prioridade;
    }

    private void validarTexto(String texto) {
        if (texto == null || texto.isBlank()) {
            throw new IllegalArgumentException("Informação do cliente e endereços são obrigatórios.");
        }
    }
}
