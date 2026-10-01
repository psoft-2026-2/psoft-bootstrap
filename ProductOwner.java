public class ProductOwner implements Papel {
    @Override
    public String getNomePapel() {
        return "Product Owner";
    }

    @Override
    public void realizarTrabalho() {
        System.out.println("Definindo prioridades e escopo dos produtos.");
    }
}