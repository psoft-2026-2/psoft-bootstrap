import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Funcionario {

    private String nome;
    private String cpf;
    private List<Funcao> cargos;

    public Funcionario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.cargos = new ArrayList<>();
    }

    public void adicionarCargo(Funcao funcao) {

        if (funcao == null) {
            throw new IllegalArgumentException(
                    "A função não pode ser nula."
            );
        }

        if (!temCargo(funcao)) {
            cargos.add(funcao);
        }
    }

    public void removerCargo(Funcao funcao) {

        if (funcao == null) {
            return;
        }

        cargos.removeIf(
                cargo -> cargo.getClass().equals(funcao.getClass())
        );
    }

    public boolean temCargo(Funcao funcao) {

        if (funcao == null) {
            return false;
        }

        return cargos.stream()
                .anyMatch(
                        cargo ->
                                cargo.getClass()
                                     .equals(funcao.getClass())
                );
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public List<Funcao> getCargos() {
        return Collections.unmodifiableList(cargos);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Funcionario)) {
            return false;
        }

        Funcionario outro = (Funcionario) obj;

        return cpf.equals(outro.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}