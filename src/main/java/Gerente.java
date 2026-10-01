public class Gerente implements Papel {
    private String certificacao;

    public Gerente(String certificacao) {
        this.certificacao = certificacao;
    }

    @Override
    public String getNome() {
        return "Gerente";
    }

    @Override
    public void executar() {
        System.out.println("-> Gerenciando recursos, prazos, promovendo membros e aprovando entregas da equipe.");
    }
}