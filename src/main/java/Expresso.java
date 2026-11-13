import java.time.LocalDateTime;

public class Expresso implements ModalidadeEntrega {
    private  float custo;

    public Expresso() { 
        this.custo = 25.0f; //valor simualado
    }


    @Override
    public float calcularCusto(Rota rota) {
        float custoBase = 12.0f + 0.60f * rota.calcularDistancia();
        return custoBase + custo;
    }

    @Override
    public LocalDateTime calcularPrazo(Rota rota) {
        float velocidade = 120.0f; // pensando que e expresso entao nao deve ser um caminhao
        float distancia = rota.calcularDistancia();

        long minutos = (long) Math.ceil((distancia / velocidade) * 60);

        return LocalDateTime.now().plusMinutes(minutos);
    }
}
