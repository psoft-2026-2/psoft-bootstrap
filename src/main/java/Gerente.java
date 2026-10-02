public class Gerente implements Papel {
    private String descricao;
    private double salario;
    private int cargaHoraria;

    public Gerente(String descricao, double salario, int cargaHoraria) {
        this.descricao = descricao;
        this.salario = salario;
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String getDescricao() {  
        return descricao;
    }

    @Override
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public double getSalario() {
        return salario;
    }

    @Override
    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public int getCargaHoraria() {
        return cargaHoraria;
    }

    @Override
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    
}
