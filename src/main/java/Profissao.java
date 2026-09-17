public class Profissao {
    private String nomeProfissao;
    private double salario;
    
    public Profissao(String nomeProfissao, double salario) {
        this.nomeProfissao = nomeProfissao;
        this.salario = salario;
    }

    public String getNomeProfissao() {
        return this.nomeProfissao;
    }
    public void setNomeProfissao(String novoNomeProfissao) {
        this.nomeProfissao = novoNomeProfissao;
    }

    public double getSalario() {
        return this.salario;
    }
    public void setSalario(double novoSalario) {
        this.salario = novoSalario;
    }
}