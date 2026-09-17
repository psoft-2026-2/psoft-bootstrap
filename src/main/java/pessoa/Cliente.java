package pessoa;

public class Cliente extends Pessoa {

    private int idCliente;

    public Cliente(String nome, String cpf, int idade, String telefone, String profissao, int id) {
        super(nome, cpf, idade, telefone, profissao);
        this.idCliente = id;
    }

    public int getIdCliente() {
        return idCliente;
    }
    
}