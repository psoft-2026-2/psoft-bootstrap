import java.util.Date;

public class Sprint {
    private int numero;
    private Date dataInicio;
    private Date dataFim;
    private Pessoa lider;

    public Sprint(int numero, Date dataInicio, Date dataFim, Pessoa lider) {
        if (!lider.temPapel("Líder de Equipe")) {
            lider.adicionarPapel(new LiderEquipe(dataInicio.toString()));
        }
        this.numero = numero;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.lider = lider;
    }

    public boolean isConcluido() {
        return new Date().after(dataFim);
    }

    public int getNumero() { return numero; }
    public Pessoa getLider() { return lider; }
    public Date getDataInicio() { return dataInicio; }
    public Date getDataFim() { return dataFim; }
}