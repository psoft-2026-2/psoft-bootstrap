public final class ProductOwner implements Funcao {
    private String[] atribuicoes;

    public ProductOwner(String[] atribuicoes) {
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
