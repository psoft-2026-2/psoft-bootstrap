public final class Lider implements LiderTime {
    private String[] atribuicoes;

    public Lider(String[] atribuicoes) {
        this.atribuicoes = atribuicoes;
    }

    @Override
    public String[] getAtribuicoes() {
        return atribuicoes;
    }

    public void setAtribuicoes(String[] atribuicoes) {
        this.atribuicoes = atribuicoes;
    }
}
