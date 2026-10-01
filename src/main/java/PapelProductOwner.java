public class PapelProductOwner implements Papel {

    @Override
    public String getNome() {
        return "Product Owner";
    }

    @Override
    public void trabalhar() {
        System.out.println("Product Owner trabalhando.");
    }
}
