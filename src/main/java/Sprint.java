import java.util.Date;

public class Sprint {
    private final int id;
    private Date date;
    private int teamId;
    private int softwareId;

    public Sprint(int id, Date date, int teamId, int softwareId) {
        this.id = id;
        this.date = date;
        this.teamId = teamId;
        this.softwareId = softwareId;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public int getTeamId() {
        return teamId;
    }

    public int getSoftwareId() {
        return softwareId;
    }
}
