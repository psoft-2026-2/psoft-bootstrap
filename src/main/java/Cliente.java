import valueobjects.CPF;
import valueobjects.Email;
import valueobjects.Telefone;

public class Cliente {
    private String nome;
    private CPF cpf;
    private Telefone telefone;
    private Email email;

    public Cliente(String nome, String cpf, String telefone, String email) {
        this.nome = nome;
        this.cpf = new CPF(cpf);
        this.telefone = new Telefone(telefone);
        this.email = new Email(email);
    }

    public String getNome() {
        return this.nome;
    }

    public CPF getCpf() {
        return this.cpf;
    }

    public Telefone getTelefone() {
        return this.telefone;
    }

    public Email getEmail() {
        return this.email;
    }

    public void setTelefone(String tel) throws Exception {
        try {
            Telefone newTel = new Telefone(tel);
            this.telefone = newTel;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
