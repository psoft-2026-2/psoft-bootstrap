public class Desenvolvedor implements FuncionarioTipo {

    @Override
    public String getNome() {
        return "Desenvolvedor";
    }

    @Override
    public String toString() {
        return getNome();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Desenvolvedor;
    }

    @Override
    public int hashCode() {
        return Desenvolvedor.class.hashCode();
    }
}
