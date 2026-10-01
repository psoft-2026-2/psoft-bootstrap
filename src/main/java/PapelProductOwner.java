import java.util.List;


public final class PapelProductOwner implements Papel {
    private static final List<String> RESPONSABILIDADES = List.of(
            "Supervisionar todos os produtos de software da empresa.",
            "Acompanhar o desenvolvimento dos produtos de software.");

    @Override
    public String getNome() {
        return "Product Owner";
    }

    @Override
    public List<String> getResponsabilidades() {
        return RESPONSABILIDADES;
    }
}
