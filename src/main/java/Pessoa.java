import java.util.ArrayList;
import java.util.list;

public class Pessoa{
	
	private String nome;
	private String idade;
	private String cpf;
	private String telefone;
	private List<Endereco> enderecos;
	private Profissao profissao;
	
	private Funcao papel;

	public Pessoa(String nome, String idade, String cpf, String telefone){
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.telefone = telefone;

		this.enderecos = new ArrayList<>();
	}

	public String getNome(){
		return nome;
	}

	public String getIdade(){
		return idade;
	}

	public String getTelefone(){
		return telefone;
	}

	public String getCpf(){
		return cpf;
	}

	
	public void setTelefone(String telefone) {
        	this.telefone = telefone;
    	}

    	public List<Endereco> getEnderecos() {
        	return enderecos;
    	}

    	public void adicionarEndereco(Endereco endereco) {
        	enderecos.add(endereco);
    	}

    	public void removerEndereco(Endereco endereco) {
        	enderecos.remove(endereco);
    	}

    	public Profissao getProfissao() {
        	return profissao;
    	}

    	public void setProfissao(Profissao profissao) {
        	this.profissao = profissao;
    	}

	public Funcao getFuncao(){
		return papel;
	}

	public void setFuncao(Funcao papel){
		this.papel = papel;
	}

}
