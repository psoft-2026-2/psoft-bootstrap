public class Sprint {
    private String nomeSprint;
    private String dataInicio;
    private String dataFim;
    private Funcionario lider;
    
    public Sprint(String nomeSprint, String dataInicio, String dataFim, Funcionario lider) {
        this.nomeSprint = nomeSprint;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.lider = lider;
    }

    public String getNomeSprint() {
        return nomeSprint;
    }
    public void setNomeSprint(String nomeSprint) {
        this.nomeSprint = nomeSprint;
    }
    public String getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }
    public String getDataFim() {
        return dataFim;
    }
    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }
    public Funcionario getLider() {
        return lider;
    }
    public void setLider(Funcionario lider) {
        if (lider.getCargo() instanceof Desenvolvedor) {
            this.lider = lider;
        }
    }

    public void removerLider() {
        this.lider = null;
    }

    
}
