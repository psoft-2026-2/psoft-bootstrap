public class Empresa {
    private String nome;
    private Funcionario productOwner;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Funcionario getProductOwner() {
        return productOwner;
    }
    
    public void setProductOwner(Funcionario productOwner) {
        this.productOwner = productOwner;
    }

    public void removeProductOwner() {
        this.productOwner = null;
    }
}
