import java.util.Objects;

public final class CPF {
    
    private final String valor;

    public CPF(String valor) {
        if (valor == null) {
            throw new IllegalArgumentException("CPF não pode ser nulo.");
        }
        
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CPF cpf = (CPF) o;
        return Objects.equals(valor, cpf.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    @Override
    public String toString() {
        return valor.substring(0, 3) + "." + valor.substring(3, 6) + "." + valor.substring(6, 9) + "." + valor.substring(9, 11);
    }
}
