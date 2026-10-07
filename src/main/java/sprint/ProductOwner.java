package sprint;

public class ProductOwner implements Papel {
    private String area;

    public ProductOwner(String area) {
        this.area = area;
    }

    @Override
    public String getDescricao() {
        return "Product Owner (area: " + area + ")";
    }

    @Override
    public void executarFuncao() {
        System.out.println("  -> Supervisionando o backlog da area: " + area);
    }
}
