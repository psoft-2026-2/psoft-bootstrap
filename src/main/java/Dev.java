public final class Dev implements Funcao {
    private String[] atribuicoes;

    public Dev(String[] atribuicoes) {
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
