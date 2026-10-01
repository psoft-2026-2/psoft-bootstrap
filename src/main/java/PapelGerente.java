import java.util.List;


public final class PapelGerente implements Papel {
    private static final List<String> RESPONSABILIDADES = List.of(
            "Gerenciar o time responsável por um produto de software.",
            "Exercer exclusivamente a função de gerente.");

    @Override
    public String getNome() {
        return "Gerente";
    }

    @Override
    public List<String> getResponsabilidades() {
        return RESPONSABILIDADES;
    }
}
