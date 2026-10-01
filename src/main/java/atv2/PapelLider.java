package atv2;

public class PapelLider implements Papel {
    public String getNome() { return "Líder"; }
    public void executar() { System.out.println("Liderando a equipe na Sprint"); }
}