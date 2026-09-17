package model;

public class Cliente extends Pessoa {

    public Cliente(String nome, String cpf, int idade, String telefone, Profissao profissao) {
        super(nome, cpf, idade, telefone, profissao);
    }

    public String getNome() {
        return super.getNome();
    }

    public String getCpf() {
        return super.getCpf();
    }

    public int getIdade() {
        return super.getIdade();
    }

    public void setIdade(int idade) {
        super.setIdade(idade);
    }

    public String getTelefone() {
        return super.getTelefone();
    }

    public void setTelefone(String telefone) {
        super.setTelefone(telefone);
    }

    public Profissao getProfissao() {
        return super.getProfissao();
    }

    public void setProfissao(Profissao profissao) {
        super.setProfissao(profissao);
    }
}