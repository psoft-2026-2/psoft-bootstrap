import java.time.LocalDate;

public class Funcionario extends Pessoa {
    private String cargo;

    public Funcionario(String nome, LocalDate dataNascimento, String cpf, String cargo) {
        super(nome, dataNascimento, cpf);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }
}
