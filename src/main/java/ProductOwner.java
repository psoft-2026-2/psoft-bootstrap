public class ProductOwner implements FuncionarioTipo {

    @Override
    public String getNome() {
        return "Product Owner";
    }

    @Override
    public String toString() {
        return getNome();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ProductOwner;
    }

    @Override
    public int hashCode() {
        return ProductOwner.class.hashCode();
    }
}
