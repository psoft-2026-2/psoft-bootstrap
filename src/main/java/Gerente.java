public class Gerente implements Papel {
    @Override
    public double getSalario() {
        return 5000.0;
    }

    @Override
    public String getResponsabilidade() {
        return "Gerencia e Organiza um time";
    }
}