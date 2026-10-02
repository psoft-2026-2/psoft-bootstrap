public class Pessoa {
    private String nome;
    private Cargo cargo;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Pessoa(String nome, Cargo cargo) {
        this.nome = nome;
        this.cargo = cargo;
    }

    public void removerCargo(Cargo cargo) {
        if (this.cargo == cargo) {
            this.cargo = null;
        }
    }

    public void executarFuncao() {
        if (cargo != null) {
            cargo.executarFuncao();
        }
    }
}