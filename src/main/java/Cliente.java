public class Cliente extends Pessoa {

    private int ID;

    public Cliente(int ID, String nome, int idade, String cpf, String telefone, Endereco endereco, Profissao profissao){
        super(nome, idade, cpf, telefone, endereco, profissao);
        this.ID = ID;
    }

    public int getID(){
        return this.ID;
    }

    public void setID(int novoID){
        this.ID = novoID;
    }

}