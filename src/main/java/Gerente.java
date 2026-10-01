public class Gerente implements Cargo {
    @Override
    public Cargo evoluiPara() {
        return new ProductOwner();
    }
}
