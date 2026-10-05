import java.util.Objects;

public class Cliente {
    private String nome;
    private String CPF;
    private String assinatura;

    public Cliente(String nome, String CPF, String assinatura) {
        this.nome = nome;
        this.CPF = CPF;
        this.assinatura = assinatura;
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return CPF;
    }

    public String getAssinatura() {
        return assinatura;
    }

    public void mudarAssinatura(String a) {
        this.assinatura = a;
    }

    @Override
    public String toString() {
        return "Cliente{nome='" + nome + "', CPF='" + CPF + "', assinatura='" + assinatura + "'}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Cliente))
            return false;
        Cliente outro = (Cliente) obj;
        return Objects.equals(CPF, outro.CPF);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CPF);
    }
}
