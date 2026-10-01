import java.util.ArrayList;

public class Gerente implements Cargo {
    private int teamId;

    public Gerente(int teamId) {
        this.teamId = teamId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    @Override
    public String getCargo() {
        return "Gerente";
    }

    @Override
    public void executaFuncao() {
        System.out.println("Gerente do time " + teamId + " coordenando o time");
    }

    @Override
    public Cargo promocao() {
        return new ProductOwner(new ArrayList<>());
    }
}
