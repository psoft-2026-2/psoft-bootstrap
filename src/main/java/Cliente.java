public class Cliente {

    private String cpf;
    private Perfil assinatura;
    
    public Cliente(String nome, String cpf, Perfil assinatura) {
        this.cpf = cpf;
        this.assinatura = assinatura;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Perfil getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(Perfil assinatura) {
        this.assinatura = assinatura;
    }

    public double desconto(){
        return assinatura.getDesconto();
    }

    @Override
    public String toString() {
        return "Cliente [cpf=" + cpf + ", assinatura=" + assinatura + "]";
    }

}
