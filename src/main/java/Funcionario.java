public class Funcionario {
    private final String nome;
    private final String cpf;
    private String contato;
    private Papel funcao;

    public Funcionario(String nome, String cpf, String contato, Papel funcao) {
        this.nome = nome;
        this.cpf = cpf;
        this.contato = contato;
        this.funcao = funcao;
    }

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Papel getFuncao() {
		return funcao;
	}

	public void setFuncao(Papel funcao) {
		this.funcao = funcao;
	}

}
