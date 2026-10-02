public class Funcionario {

    private String nome;
    private String email;
    private String cpf;
    private int codigo;
    private Papel papel;
    private int numeroParticipacoes;

    public Funcionario(String nome, String email, String cpf, int codigo, Papel papel, int numeroParticipacoes) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.codigo = codigo;
        this.papel = papel;
        this.numeroParticipacoes = numeroParticipacoes;
    }

    public Funcionario(String nome, String email, String cpf, int codigo, int numeroParticipacoes) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.codigo = codigo;
        this.papel = new Desenvolvedor();
        this.numeroParticipacoes = numeroParticipacoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Papel getPapel() {
        return papel;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
    }

    public int getNumeroParticipacoes() {
        return numeroParticipacoes;
    }

    public void addNumeroParticipacoes() {
        this.numeroParticipacoes += 1;
    }

    public boolean promover(){
        if(this.papel.getNivel() == 1){
            return false;
        }
        else if(this.papel.getNivel() == 2){
            this.papel = new ProductOwner();
            return true;
        }
        this.papel = new Lider();
        return true;
    }
}
