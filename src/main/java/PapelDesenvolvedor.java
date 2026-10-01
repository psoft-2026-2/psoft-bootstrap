public class PapelDesenvolvedor implements Papel {

    @Override
    public String getNome() {
        return "Desenvolvedor";
    }

    @Override
    public void trabalhar() {
        System.out.println("Desenvolvedor trabalhando.");
    }
}
