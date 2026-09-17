import java.util.*;

public class Pessoa {
    
    private final String nome;
    private int idade;
    private final CPF cpf;
    private String telefone;
    private List<Endereco> enderecos;
    private String profissao;
    private Papel papel;
    
    public Pessoa(String nome, int idade, CPF cpf, String telefone, String profissao, Papel papel) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.telefone = telefone;
        this.enderecos = new ArrayList<>();
        this.profissao = profissao;
        this.papel = papel;
    }

	public String getNome() {
		return this.nome;
	}

	public int getIdade() {
		return this.idade;
	}

	public CPF getCpf() {
		return this.cpf;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public List<Endereco> getEnderecos() {
		return this.enderecos;
	}

	public String getProfissao() {
		return this.profissao;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void adicionaEndereco(Endereco endereco) {
		if (!this.enderecos.contains(endereco)) {
            this.enderecos.add(endereco);
        }
	}

    public void removeEndereco(Endereco endereco) {
        if (this.enderecos.contains(endereco)) {
            this.enderecos.remove(endereco);
        }
    }

    public Endereco buscarEndereco(Endereco endereco) {
        for (Endereco end : enderecos) {
            if (end.equals(endereco)) {
                return end;
            }
        }
        return null;
    }

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public Papel getPapel() {
		return papel;
	}

	public void setPapel(Papel papel) {
		this.papel = papel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + " | Idade: " + idade + " | CPF: " + cpf + " | Telefone: " + telefone + " | Profissão: " + profissao + "| Papel: " + papel;
	}

}
