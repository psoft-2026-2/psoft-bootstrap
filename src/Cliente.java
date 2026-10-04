/**
 * Cliente
 */
public class Cliente {
    private String nome;
    private String id;
    private AssinaturaPerfil perfil;

    public Cliente(){
        this.nome = nome;
        this.id = id;
        this.perfil = perfil;
    }

    public boolean perfilPremium(){
        return this.perfil == AssinaturaPerfil.PREMIUM;
    }

    public String getNome(){
        return nome;
    }

    public String getId(){
        return id;
    }

    public AssinaturaPerfil getPerfil(){
        return perfil;
    }


}
