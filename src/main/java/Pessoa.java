import java.util.*;


public class Pessoa {
    private String nome;
    private String cpf;
    private String telefone;
    private String profissao;
    private int idade;
    private Cargo cargo;
    private List<Endereco> enderecos;


    public Pessoa(String nome, String cpf, String telefone, String profissao, int idade, Cargo cargo) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.profissao = profissao;
        this.idade = idade;
        this.cargo = cargo;
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


    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public String getProfissao() {
        return this.profissao;
    }


    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }


    public int getIdade() {
        return this.idade;
    }


    public void setIdade(int idade) {
        this.idade = idade;
    }


    public Cargo getCargo() {
        return this.cargo;
    }


    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }


    @Override
    public String toString() {
        return "---Pessoa---\nnome: " + this.nome + "\ncpf: " + this.cpf + "\nidade: " + this.idade + "\ntelefone: "
        + this.telefone + "\nprofissão: " + this.profissao + "\n------------";
    }


    public String cadastraEndereco(String cidade, String cep, String rua, String bairro, int numero) {
        String result = "";
        for (Endereco e : enderecos) {
            if (e.getCep().equals(cep) && e.getNumero() == numero) {
                result = "Endereço já existente!";
            }
        }
        enderecos.add(new Endereco(cidade, cep, rua, bairro, numero));
        result = "Endereço cadastrado!";
        return result;
    }


    public String atualizaEndereco(String cidade, String cep, String rua, String bairro, int numero) {
        String result = "";
        for (Endereco e : enderecos) {
            if (e.getCep().equals(cep) && e.getNumero() == numero) {
                e.setCidade(cidade);
                e.setRua(rua);
                e.setBairro(bairro);
                result = "Endereço atualizado!";
            } else {
                result = "Endereço não encontrado!";
            }
        }
        return result;
    }


    public String removeEndereco(String cep, int numero) {
        String result = "";
        for (Endereco e : enderecos) {
            if (e.getCep().equals(cep) && e.getNumero() == numero) {
                enderecos.remove(numero);
                result = "Endereço removido!";
                break;
            } else {
                result = "Endereço inexistente!";
            }
        }
        return result;
    }


    public String listaEnderecos() {
        String result = "";
        if (enderecos.isEmpty()) {
            result = "Lista vazia!";
        } else {
            StringBuilder sb = new StringBuilder();
            for (Endereco e : enderecos) {
                sb.append(e.toString()).append("\n");
            }
            result = sb.toString();
        }
        return result;
    }


    public String mostraEndereco(String cep, int numero) {
        String result = "";
        for (Endereco e : enderecos) {
            if (e.getCep().equals(cep) && e.getNumero() == numero) {
                result = e.toString();
                break;
            } else {
                result = "Endereço inexistente!";
            }
        }
        return result;
    }
}

