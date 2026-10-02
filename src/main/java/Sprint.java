public class Sprint {
    private Pessoa lider;
    private String dataInicio;
    private String dataFim;
    private String titulo;

    public Sprint() {
    }

    public Sprint(Pessoa lider, String dataInicio, String dataFim, String titulo) {
        this.lider = lider;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.titulo = titulo;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public void setLider(Pessoa lider) {
        this.lider = lider;
    }

    public String getDatas() {
        return dataInicio + " - " + dataFim;
    }

    public String getLider() {
        return lider.getNome();
    }

    public String getTitulo() {
        return titulo;
    }
}
