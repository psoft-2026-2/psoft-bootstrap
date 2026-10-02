public class ProductOwner implements Cargo {
    public String getNome() {
        return "Product Owner";
    }

    public boolean podePromoverPara(Cargo novoCargo) {
        return false;
    }
}