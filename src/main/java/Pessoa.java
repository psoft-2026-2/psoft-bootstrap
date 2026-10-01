import java.util.Objects;

public class Pessoa {
    private String cpf;
    private String nome;
    private Funcao funcao;

    public Pessoa(String cpf, String nome, Funcao funcao) {
        this.cpf = cpf;
        this.nome = nome;
        this.funcao = funcao;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public float getSalarioMensal() {
        return funcao.getSalarioMensal();
    }

    public int getCargaHorariaMensal() {
        return funcao.getCargaHorariaMensal();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public void setCargaHorariaMensal(int novaCarga) {
        funcao.setCargaHorariaMensal(novaCarga);
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
        return "CPF: " + cpf + "\nNome: " + nome;
    }
}