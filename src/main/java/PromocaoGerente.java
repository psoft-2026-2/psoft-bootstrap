import java.util.Objects;

public final class PromocaoGerente implements Promocao {
    @Override
    public void aplicar(Funcionario funcionario) {
        Objects.requireNonNull(funcionario, "Funcionário obrigatório.");
        if (!funcionario.possuiPapel(PapelDesenvolvedor.class)) {
            throw new IllegalArgumentException("Somente um desenvolvedor pode ser promovido a gerente.");
        }
        if (funcionario.getTime() != null) {
            funcionario.getTime().promoverAGerente(funcionario);
        } else {
            funcionario.substituirPapeis(new PapelGerente());
        }
    }
}
