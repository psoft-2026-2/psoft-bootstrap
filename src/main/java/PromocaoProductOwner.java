import java.util.Objects;

public final class PromocaoProductOwner implements Promocao {
    @Override
    public void aplicar(Funcionario funcionario) {
        Objects.requireNonNull(funcionario, "Funcionário obrigatório.");
        if (!funcionario.possuiPapel(PapelGerente.class)) {
            throw new IllegalArgumentException("Somente um gerente pode ser promovido a Product Owner.");
        }
        if (funcionario.getTime() != null) {
            throw new IllegalStateException("Defina um novo gerente para o time antes desta promoção.");
        }
        funcionario.substituirPapeis(new PapelProductOwner());
    }
}
