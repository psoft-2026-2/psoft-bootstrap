import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;
    private String profissao;
    private CPF cpf;
    private Phone telefone;
    private List<Address> enderecos;

    public Pessoa(String nome, LocalDate dataNascimento, String cpf) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = new CPF(cpf);
    }

    public String getNome() {
        return this.nome;
    }

    public int getIdade() {
        if (dataNascimento == null) {
            return 0;
        }
        return Period.between(this.dataNascimento, LocalDate.now()).getYears();
    }

    public void setdataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getProfissao() {
        return this.profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getCpf() {
        return this.cpf.getNumero();
    }

    public String getTelefone() {
        if (this.telefone == null) {
            return null;
        } else {
            return this.telefone.getNumeroFormatado();
        }
    }

    public void setTelefone(String tel) throws Exception {
        try {
            Phone newTel = new Phone(tel);
            this.telefone = newTel;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public List<Address> getEnderecos() {
        return this.enderecos;
    }

    public Address getEndereco(int index) {
        return this.enderecos.get(index);
    }

    public void addEndereco(Address address) {
        this.enderecos.add(address);
    }

    public Address removeEndereco(int index) {
        return this.enderecos.remove(index);
    }

    public void setEndereco(int index, Address address) {
        this.enderecos.set(index, address);
    }
}
