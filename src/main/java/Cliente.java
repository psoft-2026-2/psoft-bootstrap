public class Cliente {
    private String nome;
    private String CPF;
    private String email;
    private Perfil perfil;

    public Cliente(String nome, String cPF, String email, Perfil perfil) {
        this.nome = nome;
        CPF = cPF;
        this.email = email;
        this.perfil = perfil;
    }
    
    
    public void setCPF(String cPF) {
        CPF = cPF;
    }


    public Perfil getPerfil() {
        return perfil;
    }


    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCPF() {
        return CPF;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Double getDesconto() {
        return perfil.desconto();
    }

    @Override
    public String toString() {
        return "Cliente [nome=" + nome + ", CPF=" + CPF + ", email=" + email + "]";
    }
}
