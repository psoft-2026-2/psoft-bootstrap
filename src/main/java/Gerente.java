public final class Gerente implements Funcao {
    private String[] atribuicoes;

    public Gerente(String[] atribuicoes) {
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
