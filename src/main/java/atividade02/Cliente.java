package atividade02;
 
public class Cliente {
 
    private String nome;
    private String cpf;
    private PerfilAssinatura perfilAssinatura;
 
    public Cliente(String nome, String cpf, PerfilAssinatura perfilAssinatura) {
        this.nome = nome;
        this.cpf = cpf;
        this.perfilAssinatura = perfilAssinatura;
    }
 
    public PerfilAssinatura getPerfilAssinatura() {
        return perfilAssinatura;
    }
 
    public String getNome() {
        return nome;
    }
}