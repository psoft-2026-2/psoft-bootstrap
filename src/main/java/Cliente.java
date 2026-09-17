public class Cliente extends Pessoa {

    private int idCliente;

    public Cliente(String nome, int idade, String cpf,
                   String telefone, String profissao,
                   int idCliente) {

        super(nome, idade, cpf, telefone, profissao);

        this.idCliente = idCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }
}