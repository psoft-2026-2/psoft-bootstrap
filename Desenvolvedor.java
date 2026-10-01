public class Desenvolvedor implements Papel {
    @Override
    public String getNomePapel() {
        return "Desenvolvedor";
    }

    @Override
    public void realizarTrabalho() {
        System.out.println("Escrevendo código e testes.");
    }
}