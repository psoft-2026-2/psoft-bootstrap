public class Gerente implements FuncionarioTipo {

    @Override
    public String getNome() {
        return "Gerente";
    }

    @Override
    public String toString() {
        return getNome();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Gerente;
    }

    @Override
    public int hashCode() {
        return Gerente.class.hashCode();
    }
}
