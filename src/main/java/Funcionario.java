public class Funcionario {

    private final String nome;
    private Cargo cargo;
    private final String cpf;
    private float salario;

    public Funcionario(String nome, String cpf, float salario) {

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException(
                    "O nome do funcionário é obrigatório."
            );
        }

        if (cpf == null || cpf.isBlank()) {
            throw new IllegalArgumentException(
                    "O CPF do funcionário é obrigatório."
            );
        }

        if (salario < 0) {
            throw new IllegalArgumentException(
                    "O salário não pode ser negativo."
            );
        }

        this.nome = nome;
        this.cpf = cpf;
        this.cargo = new Desenvolvedor();

        this.salario = salario;
    }


    public void promoverAGerente() {

        if (!ehDesenvolvedor()) {
            throw new IllegalArgumentException(
                    "Apenas um desenvolvedor pode ser promovido a gerente."
            );
        }

        this.cargo = new Gerente();
    }


    public void promoverAPO() {

        if (!ehGerente()) {
            throw new IllegalArgumentException(
                    "O funcionário precisa ser gerente para ser promovido a Product Owner."
            );
        }

        this.cargo = new ProductOwner();
    }


    public void aumento(float valor) {

        if (valor < 0) {
            throw new IllegalArgumentException(
                    "O valor do aumento não pode ser negativo."
            );
        }

        this.salario += valor;
    }

    public boolean ehDesenvolvedor() {
        return cargo instanceof Desenvolvedor;
    }

    public boolean ehGerente() {
        return cargo instanceof Gerente;
    }

    public boolean ehProductOwner() {
        return cargo instanceof ProductOwner;
    }

    public String getPapel() {
        return this.cargo.getDescricao();
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public float getSalario() {
        return this.salario;
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.cargo.getDescricao();
    }
}