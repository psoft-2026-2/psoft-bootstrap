import java.util.*;

public abstract class Pessoa {
    private String nome;
    private String cpf;
    private int idade;
    private String telefone;
    private String profissao;
    private Map<Integer, Endereco> enderecos;
    
    public Pessoa(String nome, String cpf, int idade, String telefone, String profissao) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.telefone = telefone;
        this.profissao = profissao;
        this.enderecos = new HashMap<Integer, Endereco>();
    }

    public String cadastraEndereco(String rua, String bairro, String cep, String cidade, int numero, String complemento) {
        Endereco e = new Endereco(rua, bairro, cep, cidade, numero, complemento);
        if (!enderecos.containsValue(e)){
            enderecos.put(e.getIdEndereco(), e);
            return "endereço cadastrado";
        }
        return "esse endereco já existe";
    }
    
    public String removeEndereco(String rua, String bairro, String cep, String cidade, int numero, String complemento) {
        Endereco e = new Endereco(rua, bairro, cep, cidade, numero, complemento);
        if (!enderecos.containsValue(e)){
            return "endereço não cadastrado";
        }
        enderecos.values().remove(e);
        return "endereco removido";
    }
    
    public String atualizaEndereco(int idEndereco, String rua, String bairro, String cep, String cidade, int numero,
            String complemento) {
        Endereco novoEndereco = new Endereco(rua, bairro, cep, cidade, numero, complemento);

        Endereco endereco = enderecos.get(idEndereco);
        if (endereco == null) {
            return "endereço não cadastrado";
        }
        if (!endereco.equals(novoEndereco) && enderecos.containsValue(novoEndereco)) {
            return "esse endereco já existe";
        }
        endereco.setRua(rua);
        endereco.setBairro(bairro);
        endereco.setCep(cep);
        endereco.setCidade(cidade);
        endereco.setNumero(numero);
        endereco.setComplemento(complemento);
        return "endereço atualizado";
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getProfissao() {
        return profissao;
    }

    public Map<Integer, Endereco> getEnderecos() {
        return enderecos;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pessoa other = (Pessoa) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }
    
}