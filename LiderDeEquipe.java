public class LiderDeEquipe implements Papel {
    private Desenvolvedor devBase;

    public LiderDeEquipe(Desenvolvedor devBase) {
        this.devBase = devBase;
    }

    @Override
    public String getNomePapel() {
        return "Líder de Equipe (" + devBase.getNomePapel() + ")";
    }

    @Override
    public void realizarTrabalho() {
        devBase.realizarTrabalho();
        System.out.println("Coordenando as reuniões e a Sprint.");
    }
}