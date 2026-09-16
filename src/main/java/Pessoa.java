import java.util.List;
import java.util.ArrayList;

public class Pessoa {
    private String nome;
    private int idade;
    private String cpf;
    private String telefone;
    private String profissao;
    private boolean cliente;
    private boolean funcionario;
    private List<String> enderecos;

    public Pessoa(String nome, int idade,String cpf, String telefone, String profissao) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.telefone = telefone;
        this.profissao = profissao;
        this.cliente = false;
        this.funcionario = false;
        this.enderecos = new ArrayList<>();
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String novoTel) {
        this.telefone = novoTel;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int novaIdade) {
        this.idade = novaIdade;
    }

    public String getProfissao() {
        return this.profissao;
    }

    public void setProfissao(String novaProf) {
        this.profissao = novaProf;
    }

    public boolean isCliente() {
        return this.cliente;
    }

    public boolean isFuncionario() {
        return this.funcionario;
    }

    public boolean atribuirPapelCliente() {
        if (this.cliente == true || this.funcionario == true) {
            return false;
        } else {
            this.cliente = true;
            return true;
        }
    }

    public boolean atribuirPapelFuncionario() {
        if (this.cliente == true || this.funcionario == true) {
            return false;
        } else {
            this.funcionario = true;
            return true;
        }
    }

    public boolean removePapelCliente() {
        if (this.cliente) {
            this.cliente = false;
            return true;
        } else {
            return false;
        }
    }

    public boolean removePapelFuncionario() {
        if (this.funcionario) {
            this.funcionario = false;
            return true;
        } else {
            return false;
        }
    }

    public List<String> getEnderecos() {
        return this.enderecos;
    }

    public void adicionarEndereco(String ender) {
        this.enderecos.add(ender);
    }
}