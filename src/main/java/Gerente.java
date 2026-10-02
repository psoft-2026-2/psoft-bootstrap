public class Gerente implements Papel {
    @Override
    public String getNomePapel() {
        return toString();
    }

    @Override
    public String toString() {
        return "Papel: Gerente";
    }
}
