public class Cliente {

    private String cpf;
    private String nome;
    private Assinatura assinatura;

    public Cliente(String cpf, String nome, Assinatura assinatura){
        this.cpf = cpf;
        this.nome = nome;
        this.assinatura = assinatura;
    }

    public double calculaDesconto(){
        if(this.assinatura == Assinatura.PREMIUM)
            return 0.05;
        else
            return 0;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public Assinatura getAssinatura() {
        return this.assinatura;
    }

    public void setCpf(String novo) {
        this.cpf = novo;
    }

    public void setNome(String novo) {
        this.nome = novo;
    }

    public void setAssinatura(Assinatura novo) {
        this.assinatura = novo;
    }
}

