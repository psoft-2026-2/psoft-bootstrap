import java.util.List;


public final class PapelLider implements Papel {
    private static final List<String> RESPONSABILIDADES = List.of(
            "Liderar temporariamente a equipe durante uma sprint.",
            "Continuar exercendo as funções de desenvolvedor.");

    @Override
    public String getNome() {
        return "Líder";
    }

    @Override
    public List<String> getResponsabilidades() {
        return RESPONSABILIDADES;
    }
}
