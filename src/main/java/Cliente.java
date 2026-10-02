public class Cliente {
    
    private String nome;
    private Assinatura perfil;

    public Cliente(String nome, Assinatura perfil) {
        this.nome = nome;
        this.perfil = perfil;
    }

    public String getNome() {
        return nome;
    }

    public Assinatura getPerfil() {
        return perfil;
    }

    public void setPerfil(Assinatura perfil) {
        this.perfil = perfil;
    }

    public double getDesconto(){
        return this.perfil.getPercentualDesconto();
    }

    @Override
    public String toString(){
        return "Nome: " + this.nome + "; Assinatura: " + this.perfil + ";";
    }
}
