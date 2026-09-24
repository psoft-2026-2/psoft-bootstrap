
import java.util.Objects;

public class Cliente {
    private String nome;
    private String telefone;
    private String cpf;
    private Papel papel;

    Cliente(String nome, String telefone, String cpf, Papel papel) {
        this.cpf = cpf;
        this.nome = nome;
        this.cpf = cpf;
        this.papel = papel;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public Papel getPapel() {
        return papel;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.cpf);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.cpf, other.cpf);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{");
        sb.append("nome=").append(nome);
        sb.append(", telefone=").append(telefone);
        sb.append(", cpf=").append(cpf);
        sb.append(", papel=").append(papel);
        sb.append('}');
        return sb.toString();
    }

}