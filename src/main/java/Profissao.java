import java.util.ArrayList;
import java.util.List;

public class Profissao {

    private String cargo;
    private List<String> responsabilidades;

    public Profissao(String cargo) { 
        this.cargo = cargo;
        this.responsabilidades = new ArrayList<>();
    }

    public void adicionarResponsabilidade(String responsabilidade) {
        responsabilidades.add(responsabilidade);
    }

    public void removerResponsabilidade(String responsabilidade) {
        responsabilidades.remove(responsabilidade);
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public List<String> getResponsabilidades() {
        return responsabilidades;
    }
}