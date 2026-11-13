import java.time.LocalDateTime;

public interface ModalidadeEntrega {
    public float calcularCusto(Rota rota);
    public LocalDateTime calcularPrazo(Rota rota);
}
