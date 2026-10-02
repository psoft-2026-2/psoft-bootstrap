
public class Desenvolvedor implements Papel {

    @Override
    public String getNome() {
        return "Desenvolvedor";
    }

    @Override
    public String responsabilidades() {
        return "Escreve, testa e mantem o codigo do produto.";
    }

    public void desenvolve() {
        System.out.println("Desenvolvendo...");
    }
}
