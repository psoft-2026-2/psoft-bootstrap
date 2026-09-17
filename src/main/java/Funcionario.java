package model;

public class Funcionario extends Pessoa {

    private double salario;

    public Funcionario(String nome, String cpf, int idade, String telefone, Profissao profissao, double salario) {
        super(nome, cpf, idade, telefone, profissao);
        this.salario = salario;
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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}