package modelo;

public class Cliente extends Pessoa{
    private String codigoCliente;

    

    public Cliente(String nome, String cpf, String telefone, String cargo, String codigoCliente) {
        super(nome, cpf, telefone, cargo);
        this.codigoCliente = codigoCliente;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    } 
    
}