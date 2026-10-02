
public class ProductOwner implements Papel {

    @Override
    public String getNome() {
        return "Product Owner";
    }

    @Override
    public String responsabilidades() {
        return "Supervisiona todos os produtos de software desenvolvidos.";
    }

    public void supervisiona() {
        System.out.println("Supervisionando...");
    }
}
