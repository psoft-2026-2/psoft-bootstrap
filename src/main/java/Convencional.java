import java.time.LocalDateTime;

public class Convencional implements ModalidadeEntrega {
    private float tarifaFixa;
    private float valorKM;

    public Convencional() {
        this.tarifaFixa = 12.0f;
        this.valorKM =  0.60f;
        // valores simulados, deve ser passado pela empressea
    }

    @Override
    public float calcularCusto(Rota rota) {
        return tarifaFixa + valorKM * rota.calcularDistancia();
    }

    @Override
    public LocalDateTime calcularPrazo(Rota rota) {
        float velocidade = 80.0f; // velocidade media de um caminhao = 80km/h
        float distancia = rota.calcularDistancia();

        long minutos = (long) Math.ceil((distancia / velocidade) * 60); 

        return LocalDateTime.now().plusMinutes(minutos);
    }
}
