package atv2;

public class PapelGerente implements Papel {
    public String getNome() { return "Gerente"; }
    public void executar() { System.out.println("Gerenciando o time"); }
}