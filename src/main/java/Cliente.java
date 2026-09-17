import java.time.LocalDate;

public class Cliente extends Pessoa {
    private String numCartao;

    public Cliente(String nome, LocalDate dataNascimento, String cpf, String numCartao) {
        super(nome, dataNascimento, cpf);
        this.numCartao = numCartao;
    }

    public String getCartao() {
        return numCartao;
    }
}
