public class ProductOwner implements Papel {

    private Empresa empresa;

    public ProductOwner(Empresa emp) {
        this.empresa = emp;
    }

    public Empresa getEmp() {
        return empresa;
    }

    @Override
    public Papel getPapel() {
        return this;
    }
}
