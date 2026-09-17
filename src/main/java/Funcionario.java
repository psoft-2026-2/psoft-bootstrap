import java.util.ArrayList;

public class Funcionario extends Pessoa {
    private String cargo;

    public Funcionario(String nome, int idade, String cpf, ArrayList<Endereco> enderecos, String telefone, String profissao, String cargo) {
        super(nome, idade, cpf, enderecos, telefone, profissao);
        validarCargo(cargo);
        this.cargo = cargo;
    }

    private void validarCargo(String cargo) {
        if (cargo == null || cargo.trim().isEmpty()) {
            throw new IllegalArgumentException("cargo nao pode ser nulo ou vazio");
        }
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        validarCargo(cargo);
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCargo: " + cargo + ".";
    }
}
