import java.util.ArrayList;


public class Pessoa {
	private String nome;
    private String cpf;
    private int idade;
    private String tel;
    private Profissao profissao;
    private String[] enderecos;
	
    
    public Pessoa(String nome, String cpf, int idade, String tel, Profissao profissao, String[] enderecos) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.tel = tel;
		this.profissao = profissao;
		this.enderecos = enderecos;
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


	public void setIdade(int idade) {
		this.idade = idade;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public Profissao getProfissao() {
		return profissao;
	}


	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}


	public String[] getEnderecos() {
		return enderecos;
	}


	public void setEnderecos(String[] enderecos) {
		this.enderecos = enderecos;
	}
    
}
