import java.util.List;
import java.util.ArrayList;

public class Time {
    private List<Funcionario> funcionarios;
    private Produto produto;

    public Time(Produto produto) {
        this.produto = produto;
        this.funcionarios = new ArrayList<>();
    }

    public void adicionaFuncionario(Funcionario funcionario) {
        if (funcionario == null || this.funcionarios.contains(funcionario)) return;

        if (funcionario.temPapel(ProductOwner.class)) {
            throw new IllegalArgumentException("O Product Owner não pode ser alocado como membro de um time.");
        }

        if (funcionario.temPapel(Gerente.class)) {
            boolean jaPossuiGerente = funcionarios.stream().anyMatch(f -> f.temPapel(Gerente.class));
            
            if (jaPossuiGerente) {
                throw new IllegalArgumentException("Apenas 1 gerente é permitido por time.");
            }
        }

        this.funcionarios.add(funcionario);
    }
}
