public class Sprint {

    private String id, dataInicio, dataTermino;
    private ProdutoSoftware produto;

    public Sprint(String id, ProdutoSoftware produto) {
        this.id = id;
        this.produto = produto;
    }

    public void inicia(String dataInicio) {
        if (this.dataInicio != null)
            throw new IllegalStateException("Sprint " + id + " já foi iniciada em " + this.dataInicio);
        this.dataInicio = dataInicio;
    }

    public void termina(String dataTermino) {
        if (dataInicio == null)
            throw new IllegalStateException("Sprint " + id + " ainda não foi iniciada");
        if (this.dataTermino != null)
            throw new IllegalStateException("Sprint " + id + " já foi encerrada em " + this.dataTermino);
        this.dataTermino = dataTermino;
    }

    public boolean emAndamento() {return dataInicio != null && dataTermino == null;}

    public boolean encerrada() {return dataTermino != null;}

    public String getId() {return id;}

    public String getDataInicio() {return dataInicio;}

    public String getDataTermino() {return dataTermino;}

    public ProdutoSoftware getProduto() {return produto;}

    public void setProduto(ProdutoSoftware produto) {this.produto = produto;}

    @Override
    public String toString() {
        return "Sprint [id=" + id + ", produto=" + produto.getNome() + ", inicio=" + dataInicio
                + ", termino=" + dataTermino + "]";
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Sprint other = (Sprint) obj;
        return id == null ? other.id == null : id.equals(other.id);
    }
}
