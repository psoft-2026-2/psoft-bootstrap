public class Pessoa {
    private Cargo cargo;
    private String nome;

    public Pessoa(String cargo, String nome) throws Exception {
        this.nome = nome;

        switch (cargo) {
            case "Lider":
                this.cargo = new Lider();
                break;
            case "Desenvolvedor":
                this.cargo = new Desenvolvedor();
                break;
            default:
                throw new Exception("sem cargo não pode!'");
        }
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    

}
