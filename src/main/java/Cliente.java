import PerfilAssinatura;

package main.java;
public class Cliente {

    private String nome;
    private PerfilAssinatura perfil;

    public Cliente(String nome, PerfilAssinatura perfil) {
        this.nome = nome;
        this.perfil = perfil;
    }

    public boolean ehPremium() {
        return perfil == PerfilAssinatura.PREMIUM;
    }

    public String getNome() {
        return nome;
    }

    public PerfilAssinatura getPerfil() {
        return perfil;
    }
}