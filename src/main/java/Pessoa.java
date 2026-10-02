public class Pessoa {
    private String nome;
    private Cargo cargo;

    public Pessoa() {
    }

    public Pessoa(String nome, String cargo) {
        this.nome = nome;
        setCargo(cargo);
    }

    public String getNome() {
        return nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public String getFuncao() {
        return cargo.getFuncao();
    }

    public void setCargo(String cargo) {
        switch (cargo) {
            case "gerente":
                this.cargo = new Gerente();
                break;
            case "productOwner":
                this.cargo = new ProductOwner();
                break;
            default:
                this.cargo = new Dev();
                break;
        }
    }
}
