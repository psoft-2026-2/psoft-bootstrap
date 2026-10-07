public class Gerente implements Papel {
    @Override
    public String getNomePapel() {
        return "Gerente";
    }

    @Override
    public void realizarTrabalho() {
        System.out.println("Gerenciando o time e prazos.");
    }
}