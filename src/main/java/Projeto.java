import java.util.ArrayList;
import java.util.List;

public class Projeto {

    private final String idProjeto;
    private final Time time;
    private final String descricao;
    private String status;
    private final List<Sprint> sprints;

    public Projeto(
            String idProjeto,
            Funcionario gerente,
            String descricao
    ) {

        if (idProjeto == null || idProjeto.isBlank()) {
            throw new IllegalArgumentException(
                    "O identificador do projeto é obrigatório."
            );
        }

        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException(
                    "A descrição do projeto é obrigatória."
            );
        }

        this.idProjeto = idProjeto;
        this.time = new Time(gerente);
        this.descricao = descricao;
        this.sprints = new ArrayList<>();
        this.status = "Em desenvolvimento!";
    }

    public void incluirDesenvolvedor(Funcionario dev) {
        time.addDesenvolvedor(dev);
    }

    public void removerDesenvolvedor(Funcionario dev) {
        time.removerDesenvolvedor(dev);
    }


    public void criarSprint(
            Funcionario dev,
            String descricao
    ) {

        if (!time.possuiDesenvolvedor(dev)) {
            throw new IllegalArgumentException(
                    "O líder da Sprint deve ser um desenvolvedor pertencente ao time."
            );
        }

        if (!sprints.isEmpty()) {

            Funcionario ultimoLider =
                    sprints.get(sprints.size() - 1).getLider();

            if (ultimoLider.equals(dev)) {
                throw new IllegalArgumentException(
                        "A próxima Sprint deve possuir um líder diferente da Sprint anterior."
                );
            }
        }

        sprints.add(
                new Sprint(dev, descricao)
        );
    }

    public List<Sprint> getSprints() {
        return List.copyOf(this.sprints);
    }

    public Time getTime() {
        return this.time;
    }

    public String getIdProjeto() {
        return this.idProjeto;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getStatus() {
        return this.status;
    }

    public void entregarProjeto() {
        this.status = "Entregue!";
    }

    @Override
    public String toString() {

        return "idProjeto: " + this.idProjeto + "\n" +
                "Descrição: " + this.descricao + "\n" +
                "Status: " + this.status;
    }
}