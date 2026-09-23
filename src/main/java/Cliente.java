public class Cliente {
    private String nome;
    private Assinatura tipoPerfil;
    
    public Cliente(String nome, Assinatura tipoPerfil) {
        this.nome = nome;
        this.tipoPerfil = tipoPerfil;
    }

    public String getNome() {
        return nome;
    }

    public Assinatura getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(Assinatura tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

    public double temDesconto(){
        return  tipoPerfil.getDesconto();
    }

    @Override
    public String toString() {
        return "Cliente [nome=" + nome + ", tipoPerfil=" + tipoPerfil + "]";
    }
    
}
