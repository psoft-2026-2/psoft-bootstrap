public class Desenvolvedor implements Cargo {
    @Override
    public Cargo evoluiPara() {
        return new Gerente();
    }
}
