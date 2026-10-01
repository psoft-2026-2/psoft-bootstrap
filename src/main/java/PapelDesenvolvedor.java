import java.util.List;


public final class PapelDesenvolvedor implements Papel {
    private static final List<String> RESPONSABILIDADES = List.of(
            "Desenvolver o produto de software do time.",
            "Participar das sprints de desenvolvimento.");

    @Override
    public String getNome() {
        return "Desenvolvedor";
    }

    @Override
    public List<String> getResponsabilidades() {
        return RESPONSABILIDADES;
    }
}
