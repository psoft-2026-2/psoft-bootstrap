import java.time.LocalDateTime;

public class Economico implements ModalidadeEntrega {
    private  float reducaoPreco; // fração, ex.: 0.25 = 25%
    private  float aumentoPrazo; // fração, ex.: 0.50 = 50%

    public Economico() {
         this.reducaoPreco = 0.25f;
         this.aumentoPrazo = 0.50f; 
    }

    @Override
    public float calcularCusto(Rota rota) {
        float custoBase = 12.0f + 0.60f * rota.calcularDistancia();
        return custoBase * (1 - reducaoPreco);
    }

    @Override
    public LocalDateTime calcularPrazo(Rota rota) {
        float velocidade = 80.0f;
        float distancia = rota.calcularDistancia();

        long minutosBase = (long) Math.ceil((distancia / velocidade) * 60);

        long minutos = (long) Math.ceil(minutosBase * (1 + aumentoPrazo));

        return LocalDateTime.now().plusMinutes(minutos);
    }
}
