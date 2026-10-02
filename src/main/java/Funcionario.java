public class Funcionario {
    private String nome;
    private Cargo cargo;
    private String cpf;
    private float salario;

    public Funcionario(String nome, String cpf, float salario){
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = new Desenvolvedor();
        this.salario = salario;
    }

    public void promoverAGerente(){
        if(!cargo.getDescricao().equals("Desenvolvedor"))
            throw new IllegalArgumentException("O funcionário já é gerente ou product owner");
        else this.cargo = new Gerente();
    }

    public void aumento(float valor){
        this.salario +=  valor;
    }

    public String getPapel() {
        return this.cargo.getDescricao();
    }

    public String getNome(){
        return this.nome;
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.cargo;
    }

    public void promoverAPO() {
       if (this.cargo.getDescricao().equals("Desenvolvedor"))
         throw new IllegalArgumentException("O funcionário precisa ser gerente para ser promovido a Product Owner.");
       else 
        this.cargo = new Gerente();
    }
}
