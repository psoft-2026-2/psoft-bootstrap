public class Sprint {
    private int duracao;
    private Lider lider;
    private int dataFinalizacao;

    public Sprint(int duracao, Lider lider) {
        this.duracao = duracao;
        this.lider = lider;
    }

    public int getDuracao() {
        return duracao;
    }

    public Lider getLider() {
        return lider;
    }

    public void setLider(Lider lider) {
        this.lider = lider;
    }

    public int getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(int dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }
}
