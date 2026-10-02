public class ProductOwner implements Papel {

    private String nome;

    public ProductOwner() {nome = "Product Owner";}

    public String getNome() {return nome;}

    public String trabalha() {return "prioriza o backlog e representa o cliente";}

    @Override
    public String toString() {return nome;}
}
