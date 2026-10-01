public class Desenvolvedor implements Funcao {
    private float salarioHora;
    private int cargaHorariaMensal;
    
    public Desenvolvedor(float salarioHora, int cargaHorariaMensal) {
        this.salarioHora = salarioHora;
        this.cargaHorariaMensal = cargaHorariaMensal;
    }

    public float getSalarioHora() {
        return salarioHora;
    }

    public float getSalarioMensal() {
        return salarioHora * cargaHorariaMensal;
    }

    public int getCargaHorariaMensal() {
        return cargaHorariaMensal;
    }

    public void setCargaHorariaMensal(int novaCargaHoraria) {
        this.cargaHorariaMensal = novaCargaHoraria;
    }
}