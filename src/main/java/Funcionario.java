public class Funcionario {
    private String nome;
    private Cargo cargo;

    public Funcionario(String nome, Cargo cargoInicial) {
        this.nome = nome;
        this.cargo = cargoInicial;
    }

    public String getNome() {
        return nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void alteraCargoDev() {
        this.cargo = new Desenvolvedor();
    }

    public void alteraCargoGerente() {
        this.cargo = new Gerente();
    }

    public void alteraCargoProd() {
        this.cargo = new ProdOwner();
    }
}
