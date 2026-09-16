import java.util.Date;
import java.util.List;

public class Pessoa {
    private String nome;
    private int idade;
    private String profissao;
    private CPF cpf;
    private Phone telefone;
    private List<Address> enderecos;

    public Pessoa(String nome, int idade, String cpf){
        this.nome = nome;
        this.idade = idade;
        this.cpf = new CPF(cpf);
    }

    public String getNome(){
        return this.nome;
    }

    public int getIdade(){
        return this.idade;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public String getProfissao(){
        return this.profissao;
    }

    public void setProfissao(String profissao){
        this.profissao = profissao;
    }

    public CPF getCpf(){
        return this.cpf;
    }

    public Phone getTelefone(){
        return this.telefone;
    }

    public void setTelefone(String tel) throws Exception{
        try{
            Phone newTel = new Phone(tel);
            this.telefone = newTel;
        }catch(Exception e){
            throw new Exception(e);
        }
    }

    public List<Address> getEnderecos(){
        return this.enderecos;
    }

    public Address getEndereco(int index){
        return this.enderecos.get(index);
    }

    public void addEndereco(Address address){
        this.enderecos.add(address);
    }

    public Address removeEndereco(int index){
        return this.enderecos.remove(index);
    }

    public void setEndereco(int index, Address address){
        this.enderecos.set(index, address);
    }
}
