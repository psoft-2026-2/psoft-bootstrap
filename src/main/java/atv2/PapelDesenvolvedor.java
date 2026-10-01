package atv2;

public class PapelDesenvolvedor implements Papel {
    public String getNome() { return "Desenvolvedor"; }
    public void executar() { System.out.println("Desenvolvendo funcionalidades"); }
}