public class Cliente {
    private String nome;
    private String cpf;
    private Perfil tipoPerfil;

    public Cliente(String cpf, String nome, Perfil tipoPerfil) {
        this.cpf = cpf;
        this.nome = nome;
        this.tipoPerfil = tipoPerfil;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setTipoPerfil(Perfil perfil){
        this.tipoPerfil = perfil;
    }
    
    public double calculaDesconto(){
        return this.tipoPerfil.getDesconto();
    }
}