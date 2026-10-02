public class Desenvolvedor implements Cargo {
    public String getNome() {
        return "Desenvolvedor";
    }

    public boolean podePromoverPara(Cargo novoCargo) {
        return novoCargo instanceof Gerente;
    }
}