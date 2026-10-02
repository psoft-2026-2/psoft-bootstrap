public class Pessoa {
    
    private String nome;
    private Cargo cargo;

    public Pessoa(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        if (cargo.equalsIgnoreCase("Desenvolvedor")) {
            this.cargo = new Desenvolvedor();
        } else if (cargo.equalsIgnoreCase("Gerente")) {
            this.cargo = new Gerente();
        } else if (cargo.equalsIgnoreCase("PO") || cargo.equalsIgnoreCase("Product Owner")) {
            this.cargo = new ProductOwner();
        }
    }

    @Override
    public String toString(){
        return "Funcionário: " + this.nome + "; Cargo: " + this.cargo;
    }
}
