import java.util.ArrayList;

public class Pessoa{
    private String nome;
    private int idade;
    private String cpf;
    private ArrayList<Endereco> enderecos;
    private String telefone;
    private String profissao;

    public Pessoa(String nome, int idade, String cpf, ArrayList<Endereco> enderecos, String telefone, String profissao){
        validarNome(nome);
        validarCpf(cpf);
        validarIdade(idade);
        validarTelefone(telefone);
        validarProfissao(profissao);
        if (enderecos == null) {
            throw new IllegalArgumentException("enderecos nao pode ser nulo");
        }
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.enderecos = new ArrayList<>(enderecos);
        this.telefone = telefone;
        this.profissao = profissao;
    }

    private void validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("nome nao pode ser nulo ou vazio");
        }
    }

    private void validarCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("cpf nao pode ser nulo ou vazio");
        }
    }

    private void validarIdade(int idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("idade nao pode ser negativa");
        }
    }

    private void validarTelefone(String telefone) {
        if (telefone == null || telefone.trim().isEmpty()) {
            throw new IllegalArgumentException("telefone nao pode ser nulo ou vazio");
        }
    }

    private void validarProfissao(String profissao) {
        if (profissao == null || profissao.trim().isEmpty()) {
            throw new IllegalArgumentException("profissao nao pode ser nula ou vazia");
        }
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        validarIdade(idade);
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public ArrayList<Endereco> getEnderecos() {
        return new ArrayList<>(enderecos);
    }

    public void setEnderecos(ArrayList<Endereco> enderecos) {
        if (enderecos == null) {
            throw new IllegalArgumentException("enderecos nao pode ser nulo");
        }
        this.enderecos = new ArrayList<>(enderecos);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        validarTelefone(telefone);
        this.telefone = telefone;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        validarProfissao(profissao);
        this.profissao = profissao;
    }

    public void addEndereco(Endereco endereco) {
        if (endereco == null) {
            throw new IllegalArgumentException("endereco nao pode ser nulo");
        }
        this.enderecos.add(endereco);
    }

    public Endereco removeEndereco(String enderecoId) {
        if (enderecoId == null || enderecoId.trim().isEmpty()) {
            throw new IllegalArgumentException("enderecoId nao pode ser nulo ou vazio");
        }
        String id = enderecoId.trim();

        for (int i = 0; i < enderecos.size(); i++) {
            Endereco e = enderecos.get(i);
            if (e.getCep().equals(id)
                    || e.getLogradouro().equals(id)
                    || e.getNumero().equals(id)
                    || e.getBairro().equals(id)
                    || e.getCidadeUF().equals(id)
                    || e.toString().equals(id)) {
                return enderecos.remove(i);
            }
        }
        return null;
    }

    public String toString(){
        return "Nome: " + this.nome + ".\n" + 
                "Idade: " + this.idade + ".\n" +
                "CPF: " + this.cpf + ".\n" + 
                "Enderecos: " + this.enderecos.toString() + ".\n" + 
                "Telefone: " +  this.telefone + ".\n" +
                "Profissão: " + this.profissao + ".";
                
    }
}
