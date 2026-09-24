public class Cliente{
    private String nome;
    private Cpf cpf;
    private Tipo assinatura;

    public Cliente(String nome, Cpf cpf, Tipo assinatura){
        this.nome = nome;
        this.cpf = cpf;
        this.assinatura = assinatura;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf(){
        return this.cpf.getCpf();
    }

    public Tipo getAssinatura(){
        return this.assinatura;
    }

    public void setAssinatura(Tipo a){
        this.assinatura = a;
    }

    @Override
    public String toString(){
        return this.nome + " do tipo " + this.assinatura;
    }
}