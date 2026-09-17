import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private String nome;
    private String  cpf;
    private String telefone;
    private String profissao;
    private TipoPessoa tipo; 
    private List<Endereço> endereco = new ArrayList<>();


    public Pessoa(String nome, String cpf, String telefone, String profissao, TipoPessoa tipo){
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.profissao = profissao;
        this.tipo = tipo;

    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void adicionarEndereco(Endereço endereco) {
        this.endereco.add(endereco);
    }

    public void removerEndereco(Endereço endereco) {
        this.endereco.remove(endereco);
    }

    public String getProfissao() {
        return profissao;
    }

    public TipoPessoa getTipo() {
        return tipo;
    }

    public List<Endereço> getEndereco() {
        return endereco;
    }

    public TipoPessoa setTipo() {
        return tipo;
    } 

     public String setProfissao() {
        return profissao;
    }  


  




    







    

    


    




}
