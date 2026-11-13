import java.time.LocalDateTime;

public class Pedido {
    private Long id;
    private float peso;
    private  Rota rota;
    private ModalidadeEntrega tipoEntrega;

    private boolean despachado;

    public Pedido(Long id, float peso, String origem, String destino) {
        this.id = id;
        this.peso = peso;
        this.rota = new Rota(origem, destino);
        this.tipoEntrega = new Convencional();

        this.despachado = false;
    }

    public void setModalidade(ModalidadeEntrega modalidade) {
        if(!despachado){
            this.tipoEntrega = modalidade;
        }else{
            throw new IllegalStateException("Pedido ja despachado");
        }
    }

    public float getCustoEntrega() {
        return tipoEntrega.calcularCusto(this.rota);
    }

    public LocalDateTime getPrazoEntrega() {
        return tipoEntrega.calcularPrazo(this.rota);
    }

    public void despachar() {
        if (despachado) throw new IllegalStateException("Pedido já despachado.");
       
        despachado = true;
    }

    public String relatorio() {
        return "Pedido #" + id
            + " | Peso: " + peso + " kg"
            + " | Origem: " + rota.getOrigem()
            + " | Destino: " + rota.getDestino()
            + " | Modalidade: " + tipoEntrega.getClass().getSimpleName()
            + " | Custo: R$ " + getCustoEntrega()
            + " | Prazo estimado: " + getPrazoEntrega()
            + " | Despachado: " + despachado;
    }

    public Long getId() { return id; }
    public Rota getRota() { return rota; }
}
