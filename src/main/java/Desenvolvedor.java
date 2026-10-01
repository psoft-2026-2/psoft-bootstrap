public class Desenvolvedor implements Cargo {
    private boolean isLead;
    private int teamId;

    public Desenvolvedor(boolean isLead, int teamId) {
        this.isLead = isLead;
        this.teamId = teamId;
    }

    public boolean isLead() {
        return isLead;
    }

    public void setLead(boolean lead) {
        isLead = lead;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    @Override
    public String getCargo() {
        if (isLead) {
            return "Desenvolvedor Lead";
        }
        return "Desenvolvedor";
    }

    @Override
    public void executaFuncao() {
        if (isLead) {
            System.out.println("Desenvolvedor Lead do time " + teamId + " revisando codigo e auxiliando o time");
            return;
        }
        System.out.println("Desenvolvedor do time " + teamId + " escrevendo codigo");
    }

    @Override
    public Cargo promocao() {
        if (!isLead) {
            return new Desenvolvedor(true, teamId);
        }
        return new Gerente(teamId);
    }
}
