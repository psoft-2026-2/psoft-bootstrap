public class Pedido {
    private Cliente cliente;
    private Endereco endOrigem;
    private Endereco endDestino;
    private int peso;
    private int distancia;
    private Frete frete;
    private boolean despachado;

    public Pedido(Cliente cliente, Endereco endOrigem, Endereco endDestino,
                  int peso, int distancia) {
        this.cliente = cliente;
        this.endOrigem = endOrigem;
        this.endDestino = endDestino;
        this.peso = peso;
        this.distancia = distancia;
        this.despachado = false;
    }

    public void despachar() {
        if (frete == null) {
            throw new IllegalStateException("Escolha o frete antes");
        }
        this.despachado = true;
    }

    public boolean isDespachado() { 
        return despachado; 
    }

    public Frete getFrete() { 
        return frete; 

    }

    public void setFrete(Frete frete) {
        if (despachado) {
            throw new IllegalStateException("Pedido já foi despachado");
        }
        this.frete = frete;
    }

    public Cliente getCliente() { 
        return cliente; 

    }

    public void setCliente(Cliente cliente) { 
        this.cliente = cliente; 
    }

    public Endereco getEndOrigem() {
         return endOrigem; 
    }

    public void setEndOrigem(Endereco endOrigem) { 
        this.endOrigem = endOrigem; 
    }

    public Endereco getEndDestino() { return endDestino; }
    public void setEndDestino(Endereco endDestino) { 
        this.endDestino = endDestino; 
    }

    public int getPeso() { 
        return peso; 
    }

    public void setPeso(int peso) { 
        this.peso = peso; 
    }

    public int getDistancia() { 
        return distancia; 
    }

    public void setDistancia(int distancia) { 
        this.distancia = distancia; 
    }
}
