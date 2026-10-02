public class Gerente implements Cargo {
    public String getNome() {
        return "Gerente";
    }

    public boolean podePromoverPara(Cargo novoCargo) {
        return novoCargo instanceof ProductOwner;
    }
}