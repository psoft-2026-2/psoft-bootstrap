package atv2;

public class PapelProductOwner implements Papel {
    public String getNome() { return "Product Owner"; }
    public void executar() { System.out.println("Supervisionando os produtos"); }
}