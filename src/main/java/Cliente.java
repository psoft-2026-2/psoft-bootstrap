public class Cliente {
    public Perfil perfil;
    public String nome;

    public Cliente(Perfil perfil, String nome) {
        this.perfil = perfil;
        this.nome = nome;
    } 

    public Perfil getPerfil() {
        return this.perfil;
    }

    public String getNome() {
        return this.nome;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
        
    } 
}