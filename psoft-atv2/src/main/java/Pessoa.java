public class Pessoa {
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private Cargo cargoAtual;

    public Pessoa(String cpf, String nome, String email, String telefone, Cargo cargoAtual) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cargoAtual = cargoAtual;
    }

    public void promoverParaGerente() {
        if (this.cargoAtual != Cargo.DESENVOLVEDOR) {
            throw new IllegalStateException("Apenas desenvolvedores podem ser promovidos a Gerente.");
        }
        this.cargoAtual = Cargo.GERENTE;
    }

    public void promoverParaProductOwner() {
        if (this.cargoAtual != Cargo.GERENTE) {
            throw new IllegalStateException("Apenas gerentes podem ser promovidos a Product Owner.");
        }
        this.cargoAtual = Cargo.PRODUCT_OWNER;
    }

    public String getCpf() { 
        return cpf; 
    }

    public String getNome() {
        return nome; 
    }

    public String getEmail() {
        return email; 
    }

    public String getTelefone() {
        return telefone; 
    }

    public Cargo getCargoAtual() {
        return cargoAtual; 
    }
    
}
