public class ProductOwner implements Papel{
    @Override
    public String getNomePapel() {
        return toString();
    }

    @Override
    public String toString() {
        return "Papel: Product Owner";
    }
}
