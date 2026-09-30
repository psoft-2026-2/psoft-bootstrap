package main.java;

public class Colaborador {
    private String nome;
    private String email;
    private String papelAtual;

    public Colaborador(String nome, String email, String papelAtual) {
        this.nome = nome;
        this.email = email;
        this.papelAtual = papelAtual;
    }

    public void assumirPapel(String novoPapel) {
        this.papelAtual = novoPapel;
    }

    public void promoverGerente() {
        this.papelAtual = "Gerente";
    }

    public void promoverProductOwner() {
        this.papelAtual = "Product Owner";
    }

    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getPapelAtual() { return papelAtual; }
}