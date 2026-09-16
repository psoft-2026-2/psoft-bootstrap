import java.util.ArrayList;

public class Pessoa {
	public Pessoa(String nome, Integer idade, String cpf, String telefone, String profissao,ArrayList<Endereco> enderecos, Papel papel) {
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.telefone = telefone;
		this.profissao = profissao;
		this.enderecos = enderecos;
		this.papel = papel;
	}
	String nome;
	Integer idade;
	String cpf;
	String telefone;
	String profissao;
	ArrayList<Endereco> enderecos;
	Papel papel;
	
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void addEndereco(String rua, String cep) {
		Endereco newEndereco = new Endereco(cep, rua);
		
		enderecos.add(newEndereco);
	}
	public ArrayList<Endereco> getEnderecos() {
		return enderecos;
	}
}
