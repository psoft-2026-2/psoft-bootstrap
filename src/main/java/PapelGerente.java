public class PapelGerente implements Papel {

    @Override
    public String getNome() {
        return "Gerente";
    }

    @Override
    public void trabalhar() {
        System.out.println("Gerente trabalhando.");
    }
}
