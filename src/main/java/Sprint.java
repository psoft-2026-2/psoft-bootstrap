import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Sprint {
    private Date dtIni;
    private Date dtFim;
    private Funcionario lider;

    public Sprint(Date dtIni) {
        this.dtIni = dtIni;
    }

    public List<Date> getDatas() {
        return Arrays.asList(dtIni, dtFim);
    }

    public Funcionario getLider() {
        return lider;
    }

    public void setLider(Funcionario lider) {
        this.lider = lider;
    }
}

