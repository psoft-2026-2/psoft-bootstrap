public class Sprint {
    private String nome;
    private LocalData idSprint;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public Sprint(String nome, LocalData idSprint, LocalDate dataInicio, LocalDate dataFim) {
        this.nome = nome;
        this.idSprint = idSprint;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public String getNome() {
        return nome;
    }

    public String getIdSprint() {
        return idSprint;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
}