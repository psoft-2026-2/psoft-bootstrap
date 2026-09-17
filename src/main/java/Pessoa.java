import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Pessoa {
	
	private String nome, cpf, telefone, profissao;
	private int idade;
	private List<String> enderecos;
	
	public Pessoa(String nome, String cpf, String telefone, String profissao, int idade) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.profissao = profissao;
		this.idade = idade;
		this.enderecos = new ArrayList<String>();
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
	
	public String getProfissao() {
		return profissao;
	}
	
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public List<String> getEnderecos() {
		return this.enderecos;
	}
	
	public void addEndereco(String endereco) {
		this.enderecos.add(endereco);
	}

	public boolean removeEndereco(String endereco) {
		return this.enderecos.remove(endereco);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cpf);
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
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ", profissao=" + profissao
				+ ", idade=" + idade + "]";
	}
}
