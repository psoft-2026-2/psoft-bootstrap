package model;

public class Cliente {

    private int idCliente;
    private String nome;
    private AssinaturaCliente perfil;

    public Cliente(int idCliente, String nome, AssinaturaCliente perfil) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.perfil = perfil;
    }

    public double getDesconto() {
        return perfil.getDesconto();
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNome() {
        return nome;
    }

    public AssinaturaCliente getPerfil() {
        return perfil;
    }
}