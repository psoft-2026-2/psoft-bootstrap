import java.util.*;

public class Controller {
    private Map<String, Pessoa> pessoas;

    public Controller(){
        this.pessoas = new HashMap<String, Pessoa>();
    }

    public void cadastraCliente(String nome, String cpf, int idade, String telefone, String profissao){
        Cliente c = new Cliente(nome, cpf, idade, telefone, profissao);
        pessoas.put(cpf,c);
    }

    public void cadastraFuncionario(String nome, String cpf, int idade, String telefone, String profissao){
        Funcionario f = new Funcionario(nome, cpf, idade, telefone, profissao);
        pessoas.put(cpf,f);
    }

    public void cadastraEndereco(String cpf, String rua, String bairro, String cep, String cidade, int numero, String complemento){
        pessoas.get(cpf).cadastraEndereco(rua, bairro, cep, cidade, numero, complemento);
    }

    public void removeEndereco(String cpf, String rua, String bairro, String cep, String cidade, int numero, String complemento){
        pessoas.get(cpf).removeEndereco(rua, bairro, cep, cidade, numero, complemento);
    }

    public void removePessoa(String cpf){
        if (pessoas.containsKey(cpf)){
            pessoas.remove(cpf);
        }
    }

    public String atualizaEndereco(String cpf, int idEndereco, String rua, String bairro, String cep, String cidade, int numero, String complemento){
        return pessoas.get(cpf).atualizaEndereco(idEndereco, rua, bairro, cep, cidade, numero, complemento);
    }

}
