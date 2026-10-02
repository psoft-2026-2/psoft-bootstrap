public final class Pessoa {
    private String nome;
    private Funcao funcao;
    private LiderTime lider;
    private String cpf;

    public Pessoa(String nome, String cpf, Funcao funcao, LiderTime lider) {
        this.cpf = cpf;
        this.nome = nome;
        this.funcao = funcao;
        this.lider = lider;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public LiderTime getLider() {
        return lider;
    }

    public void setLider(LiderTime lider) {
        this.lider = lider;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isLider() {
        return lider != null;
    }

    public String[] getAtribuicoes() {
        return funcao.getAtribuicoes();
    }

    public String[] getAtribuicoesLideranca() {
        if (isLider()) {
            return lider.getAtribuicoes();
        }
        String[] atribuicoes = new String[0];
        return atribuicoes;
    }
}
