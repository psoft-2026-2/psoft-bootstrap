import java.util.Date;

public class Sprint {
    private final int id;
    private Date data;
    private int teamId;
    private int softwareId;

    public Sprint(int id, Date data, int teamId, int softwareId) {
        this.id = id;
        this.data = data;
        this.teamId = teamId;
        this.softwareId = softwareId;
    }

    public int getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public int getTeamId() {
        return teamId;
    }

    public int getSoftwareId() {
        return softwareId;
    }
}
